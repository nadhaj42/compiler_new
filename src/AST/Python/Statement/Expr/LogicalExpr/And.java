package AST.Python.Statement.Expr.LogicalExpr;

import AST.Python.Statement.Expr.Logical;

public class And extends Logical{
    public Logical left;
    public Logical right;

    public And(Logical left, Logical right, int line) {
        super("And", line);
        this.left = left;
        this.right = right;
    }

    public String toString() {
        String message = super.toString() + "{start And\n" +left.toString() +"\n"+right.toString() + "\nend And\n}";
        return message;
    }
}
