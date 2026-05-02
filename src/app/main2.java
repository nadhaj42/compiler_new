package app;

////import Visitor.html_css_jinja.visitor;
//import Visitor.html_css_jinja.SymbolTableVisitor;
//import AST.html_css_jinja.Node;
//import AST.html_css_jinja.Program;
//import SymbolTable.htmlCssJInja.SymbolTable;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import antlr2.jinjaLexer;
import antlr2.jinjaParser;

import java.nio.file.Files;
import java.nio.file.Path;

class main2 {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("test/deleteProduct.txt");
        String code = Files.readString(path);
        CharStream input = CharStreams.fromString(code);

        jinjaLexer lexer = new jinjaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();


        jinjaParser parser = new jinjaParser(tokens);
        ParseTree tree = parser.prog();


        System.out.println(tree.toStringTree(parser).replace(" (", "\n("));//        PythonVisitor visitor = new PythonVisitor();
//
//        visitor astVisitor = new visitor();
//        Node astRoot = astVisitor.visit(tree);
//
//        if (astRoot != null) {
//            System.out.println(astRoot.toString());
//
//            System.out.println("\n============================================================");
//            System.out.println("                       SYMBOL TABLE                          ");
//            System.out.println("============================================================");
//
//            SymbolTableVisitor stv = new SymbolTableVisitor();
//            SymbolTable table = stv.build((Program) astRoot);
//
//            table.print();
//
//        } else {
//            System.err.println("\n[ERROR]: AST Root is null.");
//        }
    }
}