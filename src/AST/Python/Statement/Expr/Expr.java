package AST.Python.Statement.Expr;

import AST.Python.Statement.Statement;

public abstract class Expr extends Statement {
    public Expr(String nameNode, int line) {
        super(nameNode, line);
    }

    public String toString() {
        return super.toString();
    }
}
