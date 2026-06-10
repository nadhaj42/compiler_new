
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import antlr.pythonLexer;
import antlr.pythonParser;
import antlr2.jinjaLexer;
import antlr2.jinjaParser;
import Visitor.Python.PythonVisitor;
import Visitor.html_css_jinja.visitor;
import AST.html_css_jinja.*;
import AST.Python.PythonNode;
import Semantic.Python.SymbolTableFiller;
// استيراد مكتبات ANTLR الأساسية
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class Main {
    public static void main(String[] args) throws Exception {

//        String code = """
//
//        x = 5
//        y = 3.14
//        name = "hello"
//        flag = True
//        nothing = None
//
//
//        z = x + y
//        w = x * 2 - 1
//
//
//        result = x > 3 and flag
//        result2 = x == 5 or y < 10
//        result3 = not flag
//
//        print(x)
//        print(x, y, name)
//
//
//        if x > 3:
//            y = 1
//        elif x == 3:
//           y = 2
//        else:
//            y = 0
//
//
//        while x > 0:
//            x = x - 1
//
//
//        for i in myList:
//            print(i)
//
//
//       myList = [1, 2, 3]
//
//
//       myDict = {"key": "value"}
//
//
//        def add(a, b):
//            return a + b
//
//
//        result = add(x, y)
//
//
//       obj.name
//
//        myList[0]
//
//
//        import math
//        from os import path
//
//
//        with open("file") as f:
//           print(f)
//
//        squares = [x * x for x in myList]
//        """;


//        String code = """
//        @myDecorator(arg1, arg2)
//        def myFunc():
//            return 1
//
//        result = add(x=5, y=10)
//        """;
//        String code = """
//                def outer(x):
//                    def inner(y):
//                        return x + y
//                    return inner(x)
//
//                def greet(name, msg="hello"):
//                    print(name)
//
//                @myDecorator
//                def myFunc():
//                    return 1
//
//                result = obj.method(x)[0].name
//
//                matrix = [[1, 2], [3, 4]]
//                data = {"key": [1, 2, 3]}
//
//                x = -5
//                y = +x
//
//                evens = [x for x in myList if x > 0]
//
//                def check(x):
//                    while x > 0:
//                        if x == 5:
//                            return x
//                        x = x - 1
//
//                from os.path import join
//
//                result = (x + y) * (z - 1)
//                flag = not x > 5 and y < 10 or z == 0
//                """;

//        // 1. Lexer
//        CharStream input = CharStreams.fromString(code);
//        pythonLexer lexer = new pythonLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//
//        // 2. Parser
//        pythonParser parser = new pythonParser(tokens);
//        ParseTree tree = parser.prog();
//
//        // 3. Visitor — يبني الـ AST
//        PythonVisitor visitor = new PythonVisitor();
//        PythonNode ast = visitor.visit(tree);
//
//        // 4. اطبع الـ AST
//        if (ast != null) {
//            System.out.println(ast.toString());
//        } else {
//            System.out.println("AST is null!");
//        }
//
//
//        //كود الsymboltable
//        try {
//
//            String pythonCode =
//                    "# Global variables\n" +
//                            "tax_rate = 0.15\n" +
//                            "user_name = \"Ahmad\"\n" +
//                            "\n" +
//                            "def calculate_bill(price, qty):\n" +
//                            "    # Local variables inside function\n" +
//                            "    subtotal = price * qty\n" +
//                            "    total = subtotal + (subtotal * tax_rate)\n" +
//                            "    print(user_name)\n" +
//                            "    return total\n" +
//                            "\n" +
//                            "final_price = calculate_bill(100, 2)\n" +
//                            "print(final_price)";
//
//            System.out.println("--- Processing Python Code ---\n");
//
//            // 2. إعداد الـ Lexer والـ Parser
//
//
//            pythonLexer pyLexer = new pythonLexer(CharStreams.fromString(pythonCode));
//            CommonTokenStream pyTokens = new CommonTokenStream(pyLexer);
//            pythonParser pyParser = new pythonParser(pyTokens);
//
//
//            ParseTree pyTree = pyParser.prog();
//
//            //  استخدام  Visitor الخاص ببايثون لبناء الـ AST
//            PythonVisitor pyVisitor = new PythonVisitor();
//            Program pyProgramAST = (Program) pyVisitor.visit(pyTree);
//
//            //  تشغيل الـ Symbol Table Filler لإنشاء وطباعة الجداول
//            SymbolTableFiller pyFiller = new SymbolTableFiller();
//            pyFiller.fillAndPrint(pyProgramAST);
//        } catch (Exception e) {
//            System.err.println("Error during execution: " + e.getMessage());
//            e.printStackTrace();
//        }

        System.out.println("\n========== Jinja/HTML Visitor Test ==========");

//        String jinjaCode = """
//                <html>
//                <head><title>Test</title></head>
//                <body>
//                    <div class="{{ myClass }}">
//                        {% if user %}
//                            <p>Hello {{ user.name }}</p>
//                        {% else %}
//                            <p>Hello Guest</p>
//                        {% endif %}
//                        {% for item in items %}
//                            <li>{{ item | upper }}</li>
//                        {% endfor %}
//                    </div>
//                </body>
//                </html>
//                """;


        String jinjaCode = """
        <html>
        <head>
            <meta charset="UTF-8">
            <link rel='stylesheet' href='/static/style.css'>
            <style>
                body {
                    background-color: #fff;
                    font-size: 16px;
                }
                .container {
                    max-width: 1200px;
                }
            </style>
        </head>
        <body>

            <!-- 1. Basic Expression -->
            <h1>{{ title }}</h1>

            <!-- 2. Member Access -->
            <p>{{ user.name }}</p>

            <!-- 3. Index Access -->
            <p>{{ items[0] }}</p>

            <!-- 4. Filter simple -->
            <p>{{ name | upper }}</p>

            <!-- 5. Filter with args -->
            <p>{{ name | truncate(50) }}</p>

            <!-- 6. Binary Operation -->
            <p>{{ x + y }}</p>
            <p>{{ count > 0 }}</p>

            <!-- 7. Function Call -->
            <p>{{ range(10) }}</p>

            <!-- 8. Ternary Expression -->
            <p>{{ "yes" if flag else "no" }}</p>

            <!-- 9. Simple if -->
            {% if user %}
                <p>Logged in</p>
            {% endif %}

            <!-- 10. if / else -->
            {% if score > 90 %}
                <p>Excellent</p>
            {% else %}
                <p>Keep trying</p>
            {% endif %}

            <!-- 11. if / elif / else -->
            {% if score > 90 %}
                <p>A</p>
            {% elif score > 70 %}
                <p>B</p>
            {% elif score > 50 %}
                <p>C</p>
            {% else %}
                <p>F</p>
            {% endif %}

            <!-- 12. Simple for -->
            {% for item in items %}
                <li>{{ item }}</li>
            {% endfor %}

            <!-- 13. For with filter -->
            {% for user in users %}
                <p>{{ user.name | upper }}</p>
            {% endfor %}

            <!-- 14. Nested if inside for -->
            {% for product in products %}
                {% if product.available %}
                    <div>{{ product.name }}</div>
                {% else %}
                    <div>Sold Out</div>
                {% endif %}
            {% endfor %}

            <!-- 15. Nested for inside if -->
            {% if showList %}
                <ul>
                {% for item in items %}
                    <li>{{ item }}</li>
                {% endfor %}
                </ul>
            {% endif %}

            <!-- 16. Expression in attribute -->
            <div class="{{ myClass }}">content</div>

            <!-- 17. Mixed attribute text + expression -->
            <div class="prefix-{{ name }}-suffix">content</div>

            <!-- 18. Multiple attributes with expressions -->
            <input type="text" name="{{ fieldName }}" value="{{ fieldValue }}">

            <!-- 19. Boolean attribute -->
            <input type="checkbox" checked>

            <!-- 20. Self closing -->
            <br>
            <img src="{{ imageUrl }}" alt="{{ imageAlt }}">

            <!-- 21. Chained member access -->
            <p>{{ user.profile.avatar }}</p>

            <!-- 22. Chained filter -->
            <p>{{ name | lower | truncate(20) }}</p>

            <!-- 23. Complex expression in if -->
            {% if user.age > 18 and user.verified %}
                <p>Access granted</p>
            {% endif %}

            <!-- 24. For with multiple vars -->
            {% for key, value in data %}
                <p>{{ key }}: {{ value }}</p>
            {% endfor %}

        </body>
        </html>
        """;


        try {
            // 1. Lexer
            CharStream jinjaInput = CharStreams.fromString(jinjaCode);
            jinjaLexer jLexer = new jinjaLexer(jinjaInput);

            // 2. Parser
            CommonTokenStream jinjaTokens = new CommonTokenStream(jLexer);
            jinjaParser jParser = new jinjaParser(jinjaTokens);
            jinjaParser.ProgContext jinjaTree = jParser.prog();

            // 3. Visitor — يبني الـ AST
            visitor jinjaVisitor = new visitor();
            Node jinjaAst = jinjaVisitor.visit(jinjaTree);

            // 4. اطبع الـ AST
            System.out.println("\n--- Jinja AST ---");
            if (jinjaAst != null) {
                System.out.println(jinjaAst.toString());
            } else {
                System.out.println("Jinja AST is null!");
            }

        } catch (Exception e) {
            System.err.println("Jinja Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

