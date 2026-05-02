package AST.Python.Statement.Expr.LogicalExpr;

import AST.Python.Statement.Expr.Logical;

public class Not extends Logical {
    public Logical left;
    public Logical right;

    public Not(Logical left, Logical right, int line) {
        super("Not", line);
        this.left = left;
        this.right = right;
    }

    public String toString() {
        String message = super.toString() + "{start Not\n" + left.toString() + "\n" + right.toString() + "\nend Not\n}";
        return message;
    }
}
