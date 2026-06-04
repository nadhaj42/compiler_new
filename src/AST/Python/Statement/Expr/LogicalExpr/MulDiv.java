package AST.Python.Statement.Expr.LogicalExpr;

import AST.Python.Statement.Expr.Logical;

public class MulDiv extends Logical{
    public Logical left;
    public String op;
    public Logical right;

    public MulDiv(Logical left, String op, Logical right, int line) {
        super("MulDiv", line);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public String toString() {
        String message = super.toString() + "{\nstart MulDiv\n" + left.toString() + "\n" +  op + "\n" + right.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
