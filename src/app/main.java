package app;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import antlr2.*;
import antlr.*;
//import Visitor.Python.PythonVisitor;
//import Visitor.html_css_jinja.visitor;

class Main {

    public static void main(String[] args) throws Exception {


        String filePath = "test/test.txt";
        //String filePath = "test/test2.txt";
        CharStream input = CharStreams.fromFileName(filePath);

     //   if (isPythonFile(filePath)) {
            runPython(input);
//        } else {
//            runHtmlJinja(input);
//        }
    }

    private static void runPython(CharStream input) {
        pythonLexer lexer = new pythonLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        pythonParser parser = new pythonParser(tokens);
        ParseTree tree = parser.prog();
// طباعة الشجرة بشكل منسق (Lisp-style format)
        System.out.println(tree.toStringTree(parser).replace(" (", "\n("));//        PythonVisitor visitor = new PythonVisitor();
//        AST.Python.PythonNode root = visitor.visit(tree);
//
//        Program ast = (Program) root;
//
//        System.out.println("Python Ast:");
//        System.out.println(ast.toString());
//
//        System.out.println("\n============================================================");
//        System.out.println("              STEP 4: SYMBOL TABLE                          ");
//        System.out.println("============================================================");

//        Visitor.Python.SymbolTableVisitor stv = new Visitor.Python.SymbolTableVisitor();
//
//        stv.visit(ast);
//
//        stv.getTable().print();
    }
//
//    private static void runHtmlJinja(CharStream input) {
//
//        jinjaLexer lexer = new jinjaLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        jinjaParser parser = new jinjaParser(tokens);
//        ParseTree tree = parser.prog();
//
//        visitor v = new visitor();
//        AST.html_css_jinja.Node root = v.visit(tree);
//        AST.html_css_jinja.Program ast = (AST.html_css_jinja.Program) root;
//
//        System.out.println("html_css_jinja Ast:");
//        System.out.println(ast.toString());
//    }
//
//    private static boolean isPythonFile(String filePath) {
//        return filePath.contains("test.txt");
//    }
}