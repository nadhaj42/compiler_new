package Visitor.Python;//package Visitor.Python;
//
//import AST.Python.*;
//
//import AST.Python.Statement.Expr.Expr;
//import SymbolTable.Python.*;
//
//public class SymbolTableVisitor {
//
//    private SymbolTable table = new SymbolTable();
//
//    public void visit(PythonNode node) {
//        if (node == null) return;
//
//        if (node instanceof Program p) {
//            for (PythonNode stmt : p.statements)
//                visit(stmt);
//        }
//
//        else if (node instanceof Assignment a) {
//            if (a.target instanceof Variable v) {
//                table.define(new Symbol(
//                        v.name,
//                        SymbolKind.VARIABLE,
//                        v.line,
//                        table.resolve(v.name) == null ? table.resolveScopeName() : "local"
//                ));
//            }
//            visit(a.value);
//        }
//
//        else if (node instanceof Variable v) {
//            if (table.resolve(v.name) == null) {
//                System.err.println(
//                        "Semantic Error: variable '" + v.name +
//                                "' used before declaration at line " + v.line
//                );
//            }
//        }
//
//        else if (node instanceof FunctionDef f) {
//            table.define(new Symbol(
//                    f.name,
//                    SymbolKind.FUNCTION,
//                    f.line,
//                    "global"
//            ));
//
//            table.enterScope("func:" + f.name);
//
//            for (Parmeter p : f.parameters) {
//                table.define(new Symbol(
//                        p.name,
//                        SymbolKind.PARAMETER,
//                        p.line,
//                        f.name
//                ));
//            }
//
//            for (PythonNode stmt : f.body)
//                visit(stmt);
//
//            table.exitScope();
//        }
//
//        else if (node instanceof Block b) {
//            table.enterScope("block");
//            for (PythonNode stmt : b.body)
//                visit(stmt);
//            table.exitScope();
//        }
//
//        else if (node instanceof IfStmt i) {
//            visit(i.condition);
//            for (var s : i.thenBranch) visit(s);
//            if (i.elseBranch != null)
//                for (var s : i.elseBranch) visit(s);
//        }
//
//        else if (node instanceof WhileStmt w) {
//            visit(w.condition);
//            table.enterScope("while");
//            for (var s : w.body) visit(s);
//            table.exitScope();
//        }
//
//        else if (node instanceof ForStmt f) {
//            table.enterScope("for");
//            table.define(new Symbol(
//                    f.iterator,
//                    SymbolKind.VARIABLE,
//                    f.line,
//                    "for"
//            ));
//            visit(f.iterable);
//            for (var s : f.body) visit(s);
//            table.exitScope();
//        }
//
//        else if (node instanceof Expr e) {
//            if (e instanceof AddSub a) {
//                visit(a.left); visit(a.right);
//            } else if (e instanceof MulDiv m) {
//                visit(m.left); visit(m.right);
//            } else if (e instanceof Comparison c) {
//                visit(c.left); visit(c.right);
//            }
//        }
//    }
//
//    public SymbolTable getTable() {
//        return table;
//    }
//}