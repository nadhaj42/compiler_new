import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import antlr.pythonLexer;
import antlr.pythonParser;
import Visitor.Python.PythonVisitor;
import AST.Python.PythonNode;
import Semantic.Python.SymbolTableFiller;
// استيراد مكتبات ANTLR الأساسية
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;




// استيراد الكلاسات الخاصة بمشروعك (تأكدي من مطابقة اسم الحزمة لديكِ)
import antlr.pythonLexer; // أو antlr2.pythonLexer حسب المجلد الصحيح لقواعدك
import antlr.pythonParser;
import AST.Python.Program;
import Visitor.Python.PythonVisitor;

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




        String code = """
        @myDecorator(arg1, arg2)
        def myFunc():
            return 1

        result = add(x=5, y=10)
        """;
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

        // 1. Lexer
        CharStream input = CharStreams.fromString(code);
        pythonLexer lexer = new pythonLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 2. Parser
        pythonParser parser = new pythonParser(tokens);
        ParseTree tree = parser.prog();

        // 3. Visitor — يبني الـ AST
        PythonVisitor visitor = new PythonVisitor();
        PythonNode ast = visitor.visit(tree);

        // 4. اطبع الـ AST
        if (ast != null) {
            System.out.println(ast.toString());
        } else {
            System.out.println("AST is null!");
        }


        //كود الsymboltable
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
                            "final_price = calculate_bill(100, 2)\n" +
                            "print(final_price)";

            System.out.println("--- Processing Python Code ---\n");

            // 2. إعداد الـ Lexer والـ Parser


            pythonLexer pyLexer = new pythonLexer(CharStreams.fromString(pythonCode));
            CommonTokenStream pyTokens = new CommonTokenStream(pyLexer);
            pythonParser pyParser = new pythonParser(pyTokens);


            ParseTree pyTree = pyParser.prog();

            //  استخدام  Visitor الخاص ببايثون لبناء الـ AST
            PythonVisitor pyVisitor = new PythonVisitor();
            Program pyProgramAST = (Program) pyVisitor.visit(pyTree);

            //  تشغيل الـ Symbol Table Filler لإنشاء وطباعة الجداول
            SymbolTableFiller pyFiller = new SymbolTableFiller();
            pyFiller.fillAndPrint(pyProgramAST);
        } catch (Exception e) {
            System.err.println("Error during execution: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

