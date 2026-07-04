import Semantic.htmlCssJInja.DataType;
import Semantic.htmlCssJInja.SymbolTableBuilder;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import antlr.pythonLexer;
import antlr.pythonParser;
import antlr2.jinjaLexer;
import antlr2.jinjaParser;
import Visitor.Python.PythonVisitor;
import Visitor.html_css_jinja.visitor;
import AST.html_css_jinja.*;
import Semantic.Python.SymbolTableFiller;

public class Main {
    public static void main(String[] args) throws Exception {

        //runPythonPart();
        runJinjaPart();

    }

    // ==========================================================
    // PYTHON PART
    // ==========================================================
    private static void runPythonPart() {
        System.out.println("========== Python Symbol Table Test ==========\n");
        try {
            String pythonCode =
                    "# Global variables\n" +
                            "tax_rate = 0.15\n" +
                            "user_name = \"Ahmad\"\n" +
                            "\n" +
                            "def calculate_bill(price, qty):\n" +
                            "    # Local variables inside function\n" +
                            "    subtotal = price * qty\n" +
                            "    total = subtotal + (subtotal * tax_rate)\n" +
                            "    print(user_name)\n" +
                            "    return total\n" +
                            "\n" +
                            "result = Z + y\n" +
                            "x = 5\n" +
                            "x = \"hello\"\n" +
                            "a = 5\n" +
                            "b = \"hello\"\n" +
                            "c = a + b\n" +
                            "l = 5\n" +
                            "l = 10\n" +
                            "calculate_bill = 50\n" +
                            "return 10\n" +
                            "div = 10 / 0\n" +
                            "age = 20\n" +
                            "age = None\n" +
                            "final_price = calculate_bill(100, 2)\n" +
                            "print(final_price)";

            pythonLexer pyLexer = new pythonLexer(CharStreams.fromString(pythonCode));
            CommonTokenStream pyTokens = new CommonTokenStream(pyLexer);
            pythonParser pyParser = new pythonParser(pyTokens);
            ParseTree pyTree = pyParser.prog();

            PythonVisitor pyVisitor = new PythonVisitor();
            AST.Python.Program pyProgramAST = (AST.Python.Program) pyVisitor.visit(pyTree);

            SymbolTableFiller pyFiller = new SymbolTableFiller();
            pyFiller.fillAndPrint(pyProgramAST);

        } catch (Exception e) {
            System.err.println("Error during Python processing: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ==========================================================
    // JINJA / HTML / CSS PART
    // ==========================================================
    private static void runJinjaPart() {
        System.out.println("\n========== Jinja/HTML Semantic Test ==========\n");

        String jinjaCode = """
                <!DOCTYPE html>
                                                                                  <html lang="ar">
                                                                                  <head>
                                                                                  <meta charset="UTF-8">
                                                                                  <title>عرض المنتجات</title>
                                                                                  <style>
                                                                                  /* ===== عام ===== */
                                                                                  body {
                                                                                      font-family: Arial, sans-serif;
                                                                                      margin: 0;
                                                                                      padding: 0;
                                                                                      background-color: #f7f7f7;
                                                                                      direction: rtl;
                                                                                  }
                
                                                                                  /* ===== Navbar ===== */
                                                                                  .navbar {
                                                                                      background-color: #333;
                                                                                      color: #fff;
                                                                                      display: flex;
                                                                                      justify-content: space-between;
                                                                                      align-items: center;
                                                                                      padding: 10px 20px;
                                                                                  }
                                                                                  .navbar .logo {
                                                                                      font-size: 1.8em;
                                                                                      font-weight: bold;
                                                                                  }
                                                                                  .nav-links a {
                                                                                      color: #fff;
                                                                                      text-decoration: none;
                                                                                      margin-left: 15px;
                                                                                      font-weight: 500;
                                                                                      transition: color 0.3s;
                                                                                  }
                                                                                  .nav-links a:hover {
                                                                                      color: #28a745;
                                                                                      text-decoration: underline;
                                                                                  }
                
                                                                                  /* ===== الصفحة ===== */
                                                                                  .page {
                                                                                      padding: 30px;
                                                                                      max-width: 1000px;
                                                                                      margin: auto;
                                                                                      display: grid;
                                                                                      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                                                                                      gap: 20px;
                                                                                  }
                
                                                                                  /* ===== بطاقة المنتج ===== */
                                                                                  .product-card {
                                                                                      background-color: #fff;
                                                                                      border-radius: 12px;
                                                                                      padding: 20px;
                                                                                      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
                                                                                      transition: transform 0.3s, box-shadow 0.3s;
                                                                                      display: flex;
                                                                                      flex-direction: column;
                                                                                      align-items: center;
                                                                                      text-align: center;
                                                                                  }
                                                                                  .product-card:hover {
                                                                                      transform: translateY(-5px);
                                                                                      box-shadow: 0 8px 20px rgba(0,0,0,0.2);
                                                                                  }
                                                                                  .product-card img {
                                                                                      width: 100%;
                                                                                      max-width: 200px;
                                                                                      height: auto;
                                                                                      border-radius: 10px;
                                                                                      margin-bottom: 15px;
                                                                                  }
                                                                                  .product-card h2 {
                                                                                      margin: 10px 0;
                                                                                      font-size: 1.5em;
                                                                                  }
                                                                                  .product-card p {
                                                                                      margin: 5px 0;
                                                                                      font-size: 1em;
                                                                                      color: #555;
                                                                                  }
                                                                                  .price {
                                                                                      color: #28a745;
                                                                                      font-weight: bold;
                                                                                      font-size: 1.2em;
                                                                                      margin-bottom: 10px;
                                                                                  }
                                                                                  .product-card a {
                                                                                      display: inline-block;
                                                                                      margin-top: 10px;
                                                                                      padding: 8px 12px;
                                                                                      background-color: #28a745;
                                                                                      color: #fff;
                                                                                      border-radius: 6px;
                                                                                      text-decoration: none;
                                                                                      transition: background 0.3s;
                                                                                  }
                                                                                  .product-card a:hover {
                                                                                      background-color: #218838;
                                                                                  }
                                                                                  </style>
                                                                                  </head>
                                                                                  <body>
                
                                                                                  <nav class="navbar">
                                                                                      <div class="logo">متجري</div>
                                                                                      <div class="nav-links">
                                                                                          <a href="/add">إضافة منتج</a>
                                                                                          <a href="/view">عرض المنتجات</a>
                                                                                      </div>
                                                                                  </nav>
                
                                                                                  <div class="page">
                                                                                      {% for product in products %}
                                                                                      <div class="product-card">
                                                                                          <h2>{{ product.name }}</h2>
                                                                                          {% if product.image_url %}
                                                                                          <img src="{{ product.image_url }}" alt="{{ product.name }}">
                                                                                          {% endif %}
                                                                                          <p class="price">{{ product.price }} ر.س</p>
                                                                                          <p>{{ product.description }}</p>
                                                                                          <a href="/details/{{ product.id }}">تفاصيل المنتج</a>
                
                                                                                          <!-- BUG 1: Division By Zero -->
                                                                                          <p>{{ product.price / 0 }}</p>
                
                                                                                          <!-- BUG 2: Type Mismatch -->
                                                                                          {% if product.price > "expensive" %}
                                                                                          <p>Too expensive</p>
                                                                                          {% endif %}
                
                                                                                          <!-- BUG 3: Scope Error (nested for shadows outer 'product') -->
                                                                                          {% for product in product.relatedItems %}
                                                                                              <p>{{ product }}</p>
                                                                                          {% endfor %}
                
                                                                                      </div>
                                                                                      {% endfor %}
                
                                                                                      <!-- BUG 4: Undefined Variable (product used after its for-loop closed) -->
                                                                                      <p>{{ product.name }}</p>
                
                                                                                      <!-- BUG 5: Duplicate Definition -->
                                                                                      {% for cat, cat in categories %}
                                                                                          <p>{{ cat }}</p>
                                                                                      {% endfor %}
                
                                                                                      <!-- BUG 6: Type Error (discount inferred as NUMBER via round, then used as iterable) -->
                                                                                      <p>{{ discount | round }}</p>
                                                                                      {% for d in discount %}
                                                                                          <p>{{ d }}</p>
                                                                                      {% endfor %}
                
                                                                                  </div>
                
                                                                                  </body>
                                                                                  </html>
                
        """;

        try {
            // 1. Lexer + Parser
            CharStream jinjaInput = CharStreams.fromString(jinjaCode);
            jinjaLexer jLexer = new jinjaLexer(jinjaInput);
            CommonTokenStream jinjaTokens = new CommonTokenStream(jLexer);
            jinjaParser jParser = new jinjaParser(jinjaTokens);
            jinjaParser.ProgContext jinjaTree = jParser.prog();

            // 2. Visitor - builds the AST
            visitor jinjaVisitor = new visitor();
            Program astRoot = (Program) jinjaVisitor.visit(jinjaTree);

            System.out.println("--- Jinja AST ---");
            if (astRoot != null) {
                System.out.println(astRoot.toString());
            } else {
                System.out.println("Jinja AST is null!");
                return;
            }

            // 3. SymbolTableBuilder - builds the table + runs all semantic checks
            SymbolTableBuilder stBuilder = new SymbolTableBuilder();
            stBuilder.registerFlaskVariable("products", DataType.LIST);

            stBuilder.build(astRoot);
            stBuilder.checkMissingFlaskVariables();

            // 4. Print Symbol Table
            System.out.println("===== SYMBOL TABLE =====");
            System.out.println(stBuilder.printTable());

            // 5. Print Semantic Errors
            System.out.println("===== SEMANTIC ERRORS =====");
            if (stBuilder.reporter.hasErrors()) {
                System.err.println(stBuilder.reporter.printErrors());
            } else {
                System.out.println("No semantic errors found.");
            }

        } catch (Exception e) {
            System.err.println("Jinja Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}