package AST.Python.Statement.Expr.LogicalExpr;

import AST.Python.Statement.Expr.Logical;

public class Comparison extends Logical {
    public Logical left;
    public String op;
    public Logical right;

    public Comparison(Logical left, String op, Logical right, int line) {
        super("Comparison", line);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public String toString() {
        String message = super.toString() + "{start Comparison\n" + left.toString()  + "\n" +  op + "\n" + right.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
