package AST.Python.Statement.Expr.LogicalExpr;

import AST.Python.Statement.Expr.Logical;

public class Or extends Logical {
    public Logical left;
    public Logical right;

    public Or(Logical left, Logical right, int line) {
        super("Or", line);
        this.left = left;
        this.right = right;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Or\n" +left.toString() +"\n"+right.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
