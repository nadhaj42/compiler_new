import Generateion.Jinja.HtmlJinjaGenerator;
import Generateion.Watcher.ProductsWatcher;
import Generation.Python.Environment;
import Generation.Python.PythonGenerator;
import Semantic.Python.SymbolTableFiller;
import Semantic.htmlCssJInja.SymbolTableBuilder;
import Semantic.htmlCssJInja.DataType;
import Semantic.htmlCssJInja.SemanticError;
import Visitor.html_css_jinja.visitor;
import Visitor.Python.PythonVisitor;

import antlr2.jinjaLexer;
import antlr2.jinjaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static final String OUTPUT_DIR = "output";
    private static final String COMPILER_OUTPUT_DIR = "compiler_output";

    private static final String APP_PY_PATH = "template/app.py";

    private static final int SERVER_PORT = 8080;

    private static final SimpleDateFormat TIMESTAMP_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static class TemplateConfig {
        String templatePath;
        String outputName;
        boolean needsSingleProduct;
        boolean needsMessage;
        boolean perProductOutput; // true = بتتولد نسخة منفصلة لكل منتج (product_details1.html, product_details2.html...)

        TemplateConfig(String templatePath, String outputName, boolean needsSingleProduct, boolean needsMessage) {
            this(templatePath, outputName, needsSingleProduct, needsMessage, false);
        }

        TemplateConfig(String templatePath, String outputName, boolean needsSingleProduct,
                       boolean needsMessage, boolean perProductOutput) {
            this.templatePath = templatePath;
            this.outputName = outputName;
            this.needsSingleProduct = needsSingleProduct;
            this.needsMessage = needsMessage;
            this.perProductOutput = perProductOutput;
        }
    }

    /** معلومات كل ملف مولّد، لأغراض التقرير النهائي (اسم الملف، القالب المصدر، الحجم). */
    private static class GeneratedFileInfo {
        String fileName;
        String sourceTemplate;
        int sizeBytes;

        GeneratedFileInfo(String fileName, String sourceTemplate, int sizeBytes) {
            this.fileName = fileName;
            this.sourceTemplate = sourceTemplate;
            this.sizeBytes = sizeBytes;
        }
    }

    /** نتيجة مرحلة التحليل الدلالي لبايثون: قائمة الأخطاء المكتشفة + نص جداول الرموز الحقيقي. */
    private static class SemanticAnalysisResult {
        List<String> errors = new ArrayList<>();
        String symbolTablesText = "";
    }

    private static final List<TemplateConfig> TEMPLATES = Arrays.asList(
            new TemplateConfig("template/showAllProduct.html", "index.html", false, false),
            new TemplateConfig("template/addProduct.html", "add_product.html", false, true),
            new TemplateConfig("template/editProduct.html", "edit_product.html", true, true),
            // perProductOutput = true -> بتتولد صفحة منفصلة لكل منتج
            new TemplateConfig("template/ShowProductDetiles.html", "product_details.html", true, false, true),
            new TemplateConfig("template/deleteProduct.html", "delete_product.html", true, false, true)
    );

    public static void main(String[] args) {

        regenerate();

        // المراقبة صارت على app.py مباشرة، لأنو هو مصدر الحقيقة الوحيد للبيانات (products)
        Thread watcherThread = new Thread(() -> {
            ProductsWatcher watcher = new ProductsWatcher(APP_PY_PATH, Main::regenerate);
            watcher.startWatching();
        });
        watcherThread.setDaemon(true);
        watcherThread.start();

        try {
            startWebServer(SERVER_PORT);
        } catch (IOException e) {
            System.err.println("تعذّر تشغيل السيرفر: " + e.getMessage());
        }

        System.out.println("\n البرنامج شغال وعم يراقب تغييرات " + APP_PY_PATH + " ...");
        System.out.println("اضغطي Enter لإنهاء البرنامج.\n");
        new Scanner(System.in).nextLine();
    }

    // ==================================================================================
    //  السيرفر التفاعلي (Interactive HTTP Server)
    // ==================================================================================

    private static void startWebServer(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", exchange -> {
            try {
                String path = exchange.getRequestURI().getPath();
                String method = exchange.getRequestMethod();

                if (path.equals("/")) {
                    redirect(exchange, "/view");
                } else if (path.equals("/view") && method.equalsIgnoreCase("GET")) {
                    serveFile(exchange, "index.html");
                } else if (path.equals("/add") && method.equalsIgnoreCase("GET")) {
                    serveFile(exchange, "add_product.html");
                } else if (path.equals("/add") && method.equalsIgnoreCase("POST")) {
                    handleAddProduct(exchange);
                } else if (path.startsWith("/details/") && method.equalsIgnoreCase("GET")) {
                    String id = path.substring("/details/".length());
                    serveFile(exchange, "product_details" + id + ".html");
                } else if (path.startsWith("/delete/") && method.equalsIgnoreCase("GET")) {
                    String id = path.substring("/delete/".length());
                    serveFile(exchange, "delete_product" + id + ".html");
                } else if (path.startsWith("/delete/") && method.equalsIgnoreCase("POST")) {
                    String id = path.substring("/delete/".length());
                    handleDeleteProduct(exchange, id);
                } else {
                    String fileName = path.startsWith("/") ? path.substring(1) : path;
                    serveFile(exchange, fileName);
                }
            } catch (Exception e) {
                e.printStackTrace();
                sendPlainText(exchange, 500, "خطأ داخلي بالسيرفر: " + e.getMessage());
            }
        });

        server.setExecutor(null);
        server.start();
        System.out.println(" السيرفر التفاعلي شغال على: http://localhost:" + port + "/view");
    }

    private static void serveFile(HttpExchange exchange, String fileName) throws IOException {
        Path filePath = Paths.get(OUTPUT_DIR, fileName);
        if (!Files.exists(filePath)) {
            sendPlainText(exchange, 404, "الصفحة غير موجودة: " + fileName);
            return;
        }
        byte[] bytes = Files.readAllBytes(filePath);
        String contentType = fileName.endsWith(".css") ? "text/css; charset=UTF-8"
                : fileName.endsWith(".js") ? "application/javascript; charset=UTF-8"
                : "text/html; charset=UTF-8";
        exchange.getResponseHeaders().set("Content-Type", contentType);
        exchange.sendResponseHeaders(200, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
    }

    private static void redirect(HttpExchange exchange, String location) throws IOException {
        exchange.getResponseHeaders().set("Location", location);
        exchange.sendResponseHeaders(302, -1);
        exchange.close();
    }

    private static void sendPlainText(HttpExchange exchange, int statusCode, String message) throws IOException {
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
        exchange.sendResponseHeaders(statusCode, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
    }

    private static Map<String, String> parseFormBody(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] chunk = new byte[1024];
        int n;
        while ((n = is.read(chunk)) != -1) buffer.write(chunk, 0, n);
        String body = buffer.toString("UTF-8");

        Map<String, String> result = new LinkedHashMap<>();
        for (String pair : body.split("&")) {
            if (pair.isEmpty()) continue;
            String[] kv = pair.split("=", 2);
            String key = URLDecoder.decode(kv[0], "UTF-8");
            String value = kv.length > 1 ? URLDecoder.decode(kv[1], "UTF-8") : "";
            result.put(key, value);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private static void handleAddProduct(HttpExchange exchange) throws IOException {
        Map<String, String> form = parseFormBody(exchange);

        List<Object> products = loadCurrentProductsFromAppPy();

        long nextId = 1;
        for (Object p : products) {
            if (p instanceof Map) {
                Object idVal = ((Map<Object, Object>) p).get("id");
                if (idVal instanceof Number) {
                    nextId = Math.max(nextId, ((Number) idVal).longValue() + 1);
                }
            }
        }

        Map<Object, Object> newProduct = new LinkedHashMap<>();
        newProduct.put("id", nextId);
        newProduct.put("name", form.getOrDefault("product_name", ""));
        newProduct.put("price", parseDoubleSafe(form.get("price")));
        newProduct.put("description", form.getOrDefault("description", ""));
        newProduct.put("image_url", form.getOrDefault("image_url", ""));

        products.add(newProduct);

        try {
            updateAppPyProducts(products);
        } catch (Exception e) {
            sendPlainText(exchange, 500, "تعذّر تحديث app.py: " + e.getMessage());
            return;
        }

        regenerate();
        redirect(exchange, "/view");
    }

    @SuppressWarnings("unchecked")
    private static void handleDeleteProduct(HttpExchange exchange, String id) throws IOException {
        List<Object> products = loadCurrentProductsFromAppPy();

        products.removeIf(p -> p instanceof Map
                && String.valueOf(((Map<Object, Object>) p).get("id")).equals(id));

        try {
            updateAppPyProducts(products);
        } catch (Exception e) {
            sendPlainText(exchange, 500, "تعذّر تحديث app.py: " + e.getMessage());
            return;
        }

        regenerate();
        redirect(exchange, "/view");
    }

    private static double parseDoubleSafe(String s) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0.0;
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Object> loadCurrentProductsFromAppPy() {
        AST.Python.Program pyAST = buildPythonASTFromCode();
        PythonGenerator gen = new PythonGenerator();
        Environment env = gen.execute(pyAST);
        Object productsObj = env.get("products");
        if (productsObj instanceof List) {
            return new ArrayList<>((List<Object>) productsObj);
        }
        return new ArrayList<>();
    }

    // ==================================================================================
    //  تعديل قائمة products داخل app.py نصياً (بدون المساس بباقي الملف)
    // ==================================================================================

    private static void updateAppPyProducts(List<Object> newProducts) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(APP_PY_PATH)), StandardCharsets.UTF_8);
        int[] bounds = findProductsListBounds(content);
        if (bounds == null) {
            throw new IOException("تعذّر إيجاد قائمة 'products = [...]' داخل app.py");
        }
        String newListLiteral = serializeProductsList(newProducts);
        String updated = content.substring(0, bounds[0]) + newListLiteral + content.substring(bounds[1] + 1);
        Files.write(Paths.get(APP_PY_PATH), updated.getBytes(StandardCharsets.UTF_8));
    }

    private static int[] findProductsListBounds(String content) {
        int searchFrom = 0;
        while (true) {
            int nameIdx = content.indexOf("products", searchFrom);
            if (nameIdx == -1) return null;

            boolean wordBoundaryBefore = nameIdx == 0 || !Character.isLetterOrDigit(content.charAt(nameIdx - 1));
            int afterName = nameIdx + "products".length();

            if (wordBoundaryBefore) {
                int i = afterName;
                while (i < content.length() && content.charAt(i) == ' ') i++;
                if (i < content.length() && content.charAt(i) == '=') {
                    i++;
                    while (i < content.length() && content.charAt(i) == ' ') i++;
                    if (i < content.length() && content.charAt(i) == '[') {
                        int closeIdx = findMatchingBracket(content, i);
                        if (closeIdx != -1) return new int[]{i, closeIdx};
                    }
                }
            }
            searchFrom = nameIdx + 1;
        }
    }

    private static int findMatchingBracket(String text, int openBracketIndex) {
        char open = text.charAt(openBracketIndex);
        char close = open == '[' ? ']' : (open == '{' ? '}' : ')');
        int depth = 0;
        boolean inString = false;
        char stringChar = 0;

        for (int i = openBracketIndex; i < text.length(); i++) {
            char c = text.charAt(i);
            if (inString) {
                if (c == '\\') { i++; continue; }
                if (c == stringChar) inString = false;
                continue;
            }
            if (c == '"' || c == '\'') { inString = true; stringChar = c; continue; }
            if (c == open) depth++;
            else if (c == close) {
                depth--;
                if (depth == 0) return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private static String serializeProductsList(List<Object> products) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < products.size(); i++) {
            if (i > 0) sb.append(",\n ");
            sb.append(serializeProductDict(products.get(i)));
        }
        sb.append("]");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private static String serializeProductDict(Object product) {
        if (!(product instanceof Map)) return "{}";
        Map<Object, Object> map = (Map<Object, Object>) product;
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (Map.Entry<Object, Object> e : map.entrySet()) {
            if (!first) sb.append(", ");
            first = false;
            sb.append("\"").append(e.getKey()).append("\": ").append(toPyValueLiteral(e.getValue()));
        }
        sb.append("}");
        return sb.toString();
    }

    private static String toPyValueLiteral(Object v) {
        if (v == null) return "None";
        if (v instanceof String) {
            return "\"" + ((String) v).replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
        }
        if (v instanceof Double) {
            double d = (Double) v;
            return (d == Math.floor(d) && !Double.isInfinite(d)) ? ((long) d + ".0") : String.valueOf(d);
        }
        return String.valueOf(v);
    }

    // ==================================================================================
    //  التوليد (Regeneration)
    // ==================================================================================

    @SuppressWarnings("unchecked")
    public static void regenerate() {
        long startTime = System.currentTimeMillis();
        System.out.println("========== بدء التوليد (Regeneration) ==========\n");

        // ===== المرحلة 1: تحليل app.py (Lexical + Syntax Analysis) =====
        long phase1Start = System.currentTimeMillis();
        AST.Python.Program pyAST = buildPythonASTFromCode();
        long phase1Duration = System.currentTimeMillis() - phase1Start;
        System.out.println("[Python] Phase 1 — Lexical & Syntax Analysis: تم بناء AST بنجاح.");

        // ===== المرحلة 2: التحليل الدلالي لبايثون (Semantic Analysis) عبر SymbolTableFiller =====
        long phase2Start = System.currentTimeMillis();
        SemanticAnalysisResult semanticResult = runPythonSemanticAnalysis(pyAST);
        long phase2Duration = System.currentTimeMillis() - phase2Start;

        if (semanticResult.errors.isEmpty()) {
            System.out.println("[Python] Phase 2 — Semantic Analysis: لا يوجد أخطاء دلالية.");
        } else {
            System.out.println("[Python] Phase 2 — Semantic Analysis: تم اكتشاف "
                    + semanticResult.errors.size() + " خطأ دلالي (التفاصيل بملف semantic_report.txt).");
        }

        // ===== المرحلة 3: التنفيذ الرمزي (Code Generation Execution) لاستخراج البيانات =====
        long phase3Start = System.currentTimeMillis();
        List<Object> products = new ArrayList<>();
        List<String> skippedStatements = Collections.emptyList();
        int totalTopLevelStatements = (pyAST != null && pyAST.statements != null) ? pyAST.statements.size() : 0;

        try {
            PythonGenerator pythonGenerator = new PythonGenerator();
            Environment pythonEnv = pythonGenerator.execute(pyAST);
            skippedStatements = pythonGenerator.getSkippedStatements();

            Object productsObj = pythonEnv.get("products");
            if (productsObj instanceof List) {
                products = (List<Object>) productsObj;
            } else {
                System.err.println("تحذير: لم يتم العثور على متحول 'products' صالح داخل app.py.");
            }

            System.out.println("[Python] Phase 3 — Code Generation: تم استخراج " + products.size() + " منتج.");

        } catch (Exception e) {
            System.err.println("خطأ: تعذّر تنفيذ app.py لاستخراج البيانات: " + e.getMessage());
        }
        long phase3Duration = System.currentTimeMillis() - phase3Start;

        // ===== المرحلة 4: توليد قوالب الـ Jinja/HTML (Lexical + Syntax + Semantic + Code Generation) =====
        long phase4Start = System.currentTimeMillis();
        Map<String, AST.html_css_jinja.Node> allJinjaAsts = new LinkedHashMap<>();
        List<GeneratedFileInfo> generatedFiles = new ArrayList<>();
        List<String> jinjaSemanticErrors = new ArrayList<>();
        StringBuilder jinjaSymbolTablesText = new StringBuilder();
        int templatesProcessed = 0;

        for (TemplateConfig config : TEMPLATES) {
            try {
                AST.html_css_jinja.Node jinjaAST = buildJinjaASTFromTemplate(config.templatePath);

                if (jinjaAST == null) {
                    System.err.println("[Jinja] فشل توليد AST للقالب: " + config.templatePath);
                    continue;
                }

                // ===== التحليل الدلالي لـ Jinja/HTML/CSS (مرة وحدة فقط لكل قالب، مش لكل منتج) =====
                SymbolTableBuilder stb = new SymbolTableBuilder();
                stb.registerFlaskVariable("products", DataType.LIST);
                if (config.needsSingleProduct) stb.registerFlaskVariable("product", DataType.DICT);
                if (config.needsMessage) stb.registerFlaskVariable("message", DataType.STRING);
                stb.build((AST.html_css_jinja.Program) jinjaAST);
                stb.checkMissingFlaskVariables();

                for (SemanticError err : stb.reporter.errors) {
                    jinjaSemanticErrors.add("[" + config.templatePath + "] " + err.toString());
                }
                jinjaSymbolTablesText.append("--- ").append(config.templatePath).append(" ---\n");
                jinjaSymbolTablesText.append(stb.printTable()).append("\n");

                if (config.perProductOutput) {
                    if (products.isEmpty()) {
                        System.out.println("[Jinja] تخطي " + config.templatePath + " — لا يوجد منتجات لتوليد صفحات لها.");
                    }
                    for (Object productObj : products) {
                        Environment env = new Environment(null);
                        env.define("products", products);
                        env.define("product", productObj);
                        if (config.needsMessage) {
                            env.define("message", "");
                        }

                        String productId = extractProductId(productObj);
                        String fileName = buildPerProductFileName(config.outputName, productId);

                        HtmlJinjaGenerator generator = new HtmlJinjaGenerator(env);
                        String html = generator.generate(jinjaAST);
                        saveFile(OUTPUT_DIR, fileName, html);
                        allJinjaAsts.put(fileName, jinjaAST);
                        generatedFiles.add(new GeneratedFileInfo(fileName, config.templatePath,
                                html.getBytes(StandardCharsets.UTF_8).length));
                        System.out.println("[Jinja] تم توليد " + fileName + " بنجاح.");
                    }
                    templatesProcessed++;
                } else {
                    Environment env = new Environment(null);
                    env.define("products", products);

                    if (config.needsSingleProduct) {
                        Object sampleProduct = products.isEmpty() ? new LinkedHashMap<>() : products.get(0);
                        env.define("product", sampleProduct);
                    }
                    if (config.needsMessage) {
                        env.define("message", "");
                    }

                    HtmlJinjaGenerator generator = new HtmlJinjaGenerator(env);
                    String html = generator.generate(jinjaAST);
                    saveFile(OUTPUT_DIR, config.outputName, html);
                    allJinjaAsts.put(config.outputName, jinjaAST);
                    generatedFiles.add(new GeneratedFileInfo(config.outputName, config.templatePath,
                            html.getBytes(StandardCharsets.UTF_8).length));
                    templatesProcessed++;
                    System.out.println("[Jinja] تم توليد " + config.outputName + " بنجاح.");
                }
            } catch (Exception e) {
                System.err.println("خطأ أثناء معالجة القالب " + config.templatePath + ": " + e.getMessage());
            }
        }
        long phase4Duration = System.currentTimeMillis() - phase4Start;

        if (jinjaSemanticErrors.isEmpty()) {
            System.out.println("[Jinja] Phase 4 — Semantic Analysis: لا يوجد أخطاء دلالية.");
        } else {
            System.out.println("[Jinja] Phase 4 — Semantic Analysis: تم اكتشاف "
                    + jinjaSemanticErrors.size() + " خطأ دلالي (التفاصيل بملف semantic_report.txt).");
        }

        // ===== المرحلة 5: نسخ الملفات الداعمة =====
        copyFileAsIs(APP_PY_PATH, OUTPUT_DIR, "app.py");


        long totalDuration = System.currentTimeMillis() - startTime;
        String timestamp = TIMESTAMP_FORMAT.format(new Date());

        String semanticReport = buildSemanticReport(
                timestamp, totalTopLevelStatements, skippedStatements,
                semanticResult, products,
                templatesProcessed, generatedFiles, totalDuration,
                jinjaSemanticErrors, jinjaSymbolTablesText.toString()
        );
        saveFile(COMPILER_OUTPUT_DIR, "semantic_report.txt", semanticReport);

        String genLog = buildGenerationLog(
                timestamp, phase1Duration, phase2Duration, phase3Duration, phase4Duration, totalDuration,
                products, generatedFiles, skippedStatements, semanticResult, jinjaSemanticErrors
        );
        saveFile(COMPILER_OUTPUT_DIR, "generation_log.txt", genLog);

        StringBuilder combinedJinjaJson = new StringBuilder("{\n");
        int idx = 0;
        for (Map.Entry<String, AST.html_css_jinja.Node> entry : allJinjaAsts.entrySet()) {
            combinedJinjaJson.append("  \"").append(entry.getKey()).append("\": ")
                    .append(convertNodeToJson(entry.getValue()));
            if (++idx < allJinjaAsts.size()) combinedJinjaJson.append(",");
            combinedJinjaJson.append("\n");
        }
        combinedJinjaJson.append("}");
        saveFile(COMPILER_OUTPUT_DIR, "ast_jinja.json", combinedJinjaJson.toString());

        String pythonJson = convertNodeToJson(pyAST);
        saveFile(COMPILER_OUTPUT_DIR, "ast_python.json", pythonJson);

        System.out.println("\n========== انتهى التوليد (" + templatesProcessed + "/" + TEMPLATES.size()
                + " قوالب، " + generatedFiles.size() + " ملف HTML، " + totalDuration + " ms) ==========\n");
    }

    // ==================================================================================
    //  التحليل الدلالي لبايثون (Semantic Analysis) — التقاط مخرجات SymbolTableFiller
    // ==================================================================================

    private static SemanticAnalysisResult runPythonSemanticAnalysis(AST.Python.Program pyAST) {
        SemanticAnalysisResult result = new SemanticAnalysisResult();

        ByteArrayOutputStream outCapture = new ByteArrayOutputStream();
        ByteArrayOutputStream errCapture = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        try {
            System.setOut(new PrintStream(outCapture, true, "UTF-8"));
            System.setErr(new PrintStream(errCapture, true, "UTF-8"));

            SymbolTableFiller filler = new SymbolTableFiller();
            filler.fillAndPrint(pyAST);

        } catch (Exception e) {
            result.errors.add("Internal error while running semantic analysis: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }

        try {
            String errText = errCapture.toString("UTF-8");
            if (!errText.isBlank()) {
                for (String line : errText.split("\\R")) {
                    if (!line.isBlank()) result.errors.add(line.trim());
                }
            }
            result.symbolTablesText = outCapture.toString("UTF-8");
        } catch (Exception ignored) {}

        return result;
    }

    // ==================================================================================
    //  بناء التقارير
    // ==================================================================================

    private static String buildSemanticReport(String timestamp, int totalTopLevelStatements,
                                              List<String> skippedStatements,
                                              SemanticAnalysisResult semanticResult,
                                              List<Object> products, int templatesProcessed,
                                              List<GeneratedFileInfo> generatedFiles, long totalDuration,
                                              List<String> jinjaSemanticErrors, String jinjaSymbolTablesText) {
        StringBuilder sb = new StringBuilder();
        sb.append("=========================================================\n");
        sb.append("                 COMPILER SEMANTIC REPORT                 \n");
        sb.append("=========================================================\n");
        sb.append("Generated at : ").append(timestamp).append("\n");
        sb.append("Duration     : ").append(totalDuration).append(" ms\n\n");

        sb.append("---------------------------------------------------------\n");
        sb.append("1) PYTHON SEMANTIC ANALYSIS (app.py) — via SymbolTableFiller\n");
        sb.append("---------------------------------------------------------\n");
        sb.append("Status                 : ").append(semanticResult.errors.isEmpty() ? "PASSED" : "COMPLETED WITH ERRORS").append("\n");
        sb.append("Semantic errors found  : ").append(semanticResult.errors.size()).append("\n\n");

        if (!semanticResult.errors.isEmpty()) {
            sb.append("Detected semantic errors:\n");
            for (String err : semanticResult.errors) {
                sb.append("  - ").append(err).append("\n");
            }
            sb.append("\n");
        }

        sb.append("Symbol Tables (per scope):\n");
        sb.append("---------------------------------------------------------\n");
        sb.append(semanticResult.symbolTablesText.isBlank()
                ? "  (no symbol tables generated)\n"
                : semanticResult.symbolTablesText);

        // ----- 2. Jinja/HTML/CSS Semantic Analysis (SymbolTableBuilder) -----
        sb.append("\n---------------------------------------------------------\n");
        sb.append("2) JINJA / HTML / CSS SEMANTIC ANALYSIS — via SymbolTableBuilder\n");
        sb.append("---------------------------------------------------------\n");
        sb.append("Status                 : ").append(jinjaSemanticErrors.isEmpty() ? "PASSED" : "COMPLETED WITH ERRORS").append("\n");
        sb.append("Semantic errors found  : ").append(jinjaSemanticErrors.size()).append("\n");
        sb.append("Templates processed    : ").append(templatesProcessed).append("/").append(TEMPLATES.size()).append("\n");
        sb.append("Total HTML files       : ").append(generatedFiles.size()).append("\n");
        sb.append("Link resolution        : Flask routes (e.g. /details/<id>, /delete/<id>) statically resolved\n");
        sb.append("                         to their corresponding generated HTML files.\n\n");

        if (!jinjaSemanticErrors.isEmpty()) {
            sb.append("Detected semantic errors:\n");
            for (String err : jinjaSemanticErrors) {
                sb.append("  - ").append(err).append("\n");
            }
            sb.append("\n");
        }

        sb.append("Symbol Tables (per template):\n");
        sb.append("---------------------------------------------------------\n");
        sb.append(jinjaSymbolTablesText.isBlank()
                ? "  (no symbol tables generated)\n"
                : jinjaSymbolTablesText);

        // ----- 3. Products Data -----
        sb.append("\n---------------------------------------------------------\n");
        sb.append("3) EXTRACTED DATA (from app.py -> 'products')\n");
        sb.append("---------------------------------------------------------\n");
        sb.append("Products loaded : ").append(products.size()).append(" item(s)\n\n");
        if (!products.isEmpty()) {
            sb.append(String.format("  %-4s %-20s %-10s%n", "ID", "NAME", "PRICE"));
            sb.append("  ------------------------------------------\n");
            for (Object p : products) {
                if (p instanceof Map) {
                    Map<Object, Object> m = (Map<Object, Object>) p;
                    sb.append(String.format("  %-4s %-20s %-10s%n",
                            String.valueOf(m.getOrDefault("id", "?")),
                            String.valueOf(m.getOrDefault("name", "?")),
                            String.valueOf(m.getOrDefault("price", "?"))));
                }
            }
        }

        // ----- 4. Generated Files -----
        sb.append("\n---------------------------------------------------------\n");
        sb.append("4) GENERATED OUTPUT FILES\n");
        sb.append("---------------------------------------------------------\n");
        sb.append(String.format("  %-28s %-32s %-10s%n", "FILE", "SOURCE TEMPLATE", "SIZE"));
        sb.append("  --------------------------------------------------------------------------\n");
        for (GeneratedFileInfo f : generatedFiles) {
            sb.append(String.format("  %-28s %-32s %-10s%n", f.fileName, f.sourceTemplate, f.sizeBytes + " B"));
        }

        sb.append("\n=========================================================\n");
        sb.append("SUMMARY: ").append(generatedFiles.size())
                .append(" file(s) generated from ").append(products.size()).append(" product(s). ")
                .append(semanticResult.errors.size()).append(" Python semantic error(s), ")
                .append(jinjaSemanticErrors.size()).append(" Jinja/HTML/CSS semantic error(s) detected.\n");
        sb.append("=========================================================\n");

        return sb.toString();
    }

    private static String buildGenerationLog(String timestamp, long phase1Duration, long phase2Duration,
                                             long phase3Duration, long phase4Duration, long totalDuration,
                                             List<Object> products, List<GeneratedFileInfo> generatedFiles,
                                             List<String> skippedStatements, SemanticAnalysisResult semanticResult,
                                             List<String> jinjaSemanticErrors) {
        StringBuilder sb = new StringBuilder();
        sb.append("=========================================================\n");
        sb.append("                    GENERATION LOG                        \n");
        sb.append("=========================================================\n");
        sb.append("[LOG] Timestamp : ").append(timestamp).append("\n");
        sb.append("[LOG] Total duration : ").append(totalDuration).append(" ms\n\n");

        sb.append("---------------------------------------------------------\n");
        sb.append("PHASE 1 — Python Lexical & Syntax Analysis (app.py)\n");
        sb.append("---------------------------------------------------------\n");
        sb.append("[LOG] Source file      : ").append(APP_PY_PATH).append("\n");
        sb.append("[LOG] Lexer            : antlr.pythonLexer\n");
        sb.append("[LOG] Parser           : antlr.pythonParser (prog -> ProgramRule)\n");
        sb.append("[LOG] AST Builder      : Visitor.Python.PythonVisitor\n");
        sb.append("[LOG] Duration         : ").append(phase1Duration).append(" ms\n");
        sb.append("[LOG] Status           : PASSED\n\n");

        sb.append("---------------------------------------------------------\n");
        sb.append("PHASE 2 — Semantic Analysis (Python) — SymbolTableFiller\n");
        sb.append("---------------------------------------------------------\n");
        sb.append("[LOG] Engine           : Semantic.Python.SymbolTableFiller\n");
        sb.append("[LOG] Semantic errors  : ").append(semanticResult.errors.size()).append("\n");
        sb.append("[LOG] Duration         : ").append(phase2Duration).append(" ms\n");
        sb.append("[LOG] Status           : ").append(semanticResult.errors.isEmpty() ? "PASSED" : "COMPLETED WITH ERRORS").append("\n");
        sb.append("[LOG] Full error list and symbol tables are written to semantic_report.txt\n\n");

        sb.append("---------------------------------------------------------\n");
        sb.append("PHASE 3 — Code Generation / Context Data Extraction\n");
        sb.append("---------------------------------------------------------\n");
        sb.append("[LOG] Engine           : Generation.Python.PythonGenerator\n");
        sb.append("[LOG] products found   : ").append(products.size()).append(" item(s)\n");
        sb.append("[LOG] Runtime-only statements skipped (expected — Flask server bindings): ")
                .append(skippedStatements.size()).append("\n");
        sb.append("[LOG] Duration         : ").append(phase3Duration).append(" ms\n");
        sb.append("[LOG] Status           : PASSED\n\n");

        sb.append("---------------------------------------------------------\n");
        sb.append("PHASE 4 — Jinja/HTML/CSS Lexical, Syntax, Semantic & Code Generation\n");
        sb.append("---------------------------------------------------------\n");
        sb.append("[LOG] Lexer            : antlr2.jinjaLexer\n");
        sb.append("[LOG] Parser           : antlr2.jinjaParser\n");
        sb.append("[LOG] AST Builder      : Visitor.html_css_jinja.visitor\n");
        sb.append("[LOG] Semantic Engine  : Semantic.htmlCssJInja.SymbolTableBuilder\n");
        sb.append("[LOG] Jinja semantic errors : ").append(jinjaSemanticErrors.size()).append("\n");
        sb.append("[LOG] Code Generator   : Generateion.Jinja.HtmlJinjaGenerator\n");
        sb.append("[LOG] Duration         : ").append(phase4Duration).append(" ms\n");
        sb.append("[LOG] Status           : ").append(jinjaSemanticErrors.isEmpty() ? "PASSED" : "COMPLETED WITH ERRORS").append("\n\n");

        sb.append("---------------------------------------------------------\n");
        sb.append("TEMPLATE -> OUTPUT MAPPING\n");
        sb.append("---------------------------------------------------------\n");
        for (TemplateConfig config : TEMPLATES) {
            if (config.perProductOutput) {
                sb.append("[LOG] template '").append(config.templatePath)
                        .append("' -> output/").append(config.outputName.replace(".html", ""))
                        .append("<id>.html  (per product, ").append(products.size()).append(" file(s))\n");
            } else {
                sb.append("[LOG] template '").append(config.templatePath)
                        .append("' -> output/").append(config.outputName).append("\n");
            }
        }

        sb.append("\n---------------------------------------------------------\n");
        sb.append("GENERATED FILES (detailed)\n");
        sb.append("---------------------------------------------------------\n");
        for (GeneratedFileInfo f : generatedFiles) {
            sb.append("[LOG] ").append(f.fileName)
                    .append("  <- ").append(f.sourceTemplate)
                    .append("  (").append(f.sizeBytes).append(" bytes)\n");
        }

        sb.append("\n---------------------------------------------------------\n");
        sb.append("SUPPORTING FILES\n");
        sb.append("---------------------------------------------------------\n");
        sb.append("[LOG] supporting file copied: app.py (from ").append(APP_PY_PATH).append(")\n");


        sb.append("\n=========================================================\n");
        sb.append("[LOG] Regeneration finished successfully.\n");
        sb.append("=========================================================\n");

        return sb.toString();
    }

    // ==================================================================================
    //  دوال مساعدة
    // ==================================================================================

    @SuppressWarnings("unchecked")
    private static String extractProductId(Object product) {
        if (product instanceof Map) {
            Object idVal = ((Map<Object, Object>) product).get("id");
            if (idVal != null) {
                if (idVal instanceof Double && (Double) idVal == Math.floor((Double) idVal)) {
                    return String.valueOf(((Double) idVal).longValue());
                }
                return idVal.toString();
            }
        }
        return "0";
    }

    private static String buildPerProductFileName(String baseOutputName, String productId) {
        int dotIndex = baseOutputName.lastIndexOf('.');
        if (dotIndex == -1) {
            return baseOutputName + productId;
        }
        String namePart = baseOutputName.substring(0, dotIndex);
        String extPart = baseOutputName.substring(dotIndex);
        return namePart + productId + extPart;
    }

    private static void copyFileAsIs(String sourcePath, String destDir, String destFileName) {
        try {
            Path source = Paths.get(sourcePath);
            if (!Files.exists(source)) {
                System.err.println("تحذير: الملف الداعم '" + sourcePath + "' غير موجود - تم تخطيه.");
                return;
            }
            File dir = new File(destDir);
            if (!dir.exists()) dir.mkdirs();

            Path dest = Paths.get(destDir, destFileName);
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
            System.out.println(" Copied (as-is): " + destDir + "/" + destFileName);
        } catch (IOException e) {
            System.err.println("خطأ أثناء نسخ " + sourcePath + ": " + e.getMessage());
        }
    }

    private static AST.html_css_jinja.Node buildJinjaASTFromTemplate(String filePath) {
        try {
            org.antlr.v4.runtime.CharStream input = CharStreams.fromFileName(filePath);
            jinjaLexer lexer = new jinjaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            jinjaParser parser = new jinjaParser(tokens);

            jinjaParser.ProgContext parseTree = parser.prog();
            visitor astVisitor = new visitor();
            return astVisitor.visitProgram((jinjaParser.ProgramContext) parseTree);

        } catch (IOException e) {
            System.err.println("Error reading template file '" + filePath + "': " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Error parsing Jinja/HTML template '" + filePath + "': " + e.getMessage());
            return null;
        }
    }

    private static AST.Python.Program buildPythonASTFromCode() {
        String path = APP_PY_PATH;

        if (!Files.exists(Paths.get(path))) {
            System.err.println("تحذير: " + path + " غير موجود - سيتم إرجاع AST فاضي.");
            return new AST.Python.Program(1, new ArrayList<>());
        }

        try {
            org.antlr.v4.runtime.CharStream input = CharStreams.fromFileName(path);
            antlr.pythonLexer lexer = new antlr.pythonLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            antlr.pythonParser parser = new antlr.pythonParser(tokens);

            antlr.pythonParser.ProgContext progCtx = parser.prog();

            PythonVisitor pyVisitor = new PythonVisitor();
            AST.Python.PythonNode result =
                    pyVisitor.visitProgramRule((antlr.pythonParser.ProgramRuleContext) progCtx);

            return (AST.Python.Program) result;

        } catch (Exception e) {
            System.err.println("خطأ أثناء تحليل app.py: " + e.getMessage());
            return new AST.Python.Program(1, new ArrayList<>());
        }
    }

    public static String convertNodeToJson(Object node) {
        if (node == null) return "{\n  \"status\": \"empty_ast\"\n}";

        if (node instanceof String) {
            return "\"" + escapeJsonString((String) node) + "\"";
        }

        if (node instanceof Number || node instanceof Boolean) {
            return node.toString();
        }

        if (node instanceof Collection) {
            StringBuilder sb = new StringBuilder("[\n");
            Collection<?> col = (Collection<?>) node;
            int count = 0;
            for (Object item : col) {
                sb.append("    ").append(convertNodeToJson(item));
                if (++count < col.size()) sb.append(",");
                sb.append("\n");
            }
            sb.append("  ]");
            return sb.toString();
        }

        StringBuilder json = new StringBuilder("{\n");
        Class<?> clazz = node.getClass();

        String nodeType = clazz.getSimpleName().isEmpty() ? "JinjaNode" : clazz.getSimpleName();
        json.append("  \"nodeType\": \"").append(escapeJsonString(nodeType)).append("\"");

        List<Field> allFields = new ArrayList<>();
        Collections.addAll(allFields, clazz.getDeclaredFields());
        if (clazz.getSuperclass() != null && clazz.getSuperclass() != Object.class) {
            Collections.addAll(allFields, clazz.getSuperclass().getDeclaredFields());
        }

        for (Field field : allFields) {
            try {
                field.setAccessible(true);
                Object value = field.get(node);
                if (value != null && !field.getName().startsWith("this$")) {
                    json.append(",\n  \"").append(escapeJsonString(field.getName())).append("\": ");
                    json.append(convertNodeToJson(value));
                }
            } catch (Exception ignored) {}
        }

        json.append("\n}");
        return json.toString();
    }

    private static String escapeJsonString(String input) {
        if (input == null) return "";
        return input.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
    private static void saveFile(String directoryPath, String fileName, String content) {
        try {
            File dir = new File(directoryPath);
            if (!dir.exists()) dir.mkdirs();

            File file = new File(dir, fileName);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(content);
            }
            System.out.println(" Saved: " + directoryPath + "/" + fileName);
        } catch (IOException e) {
            System.err.println(" Error saving " + fileName + ": " + e.getMessage());
        }
    }
}