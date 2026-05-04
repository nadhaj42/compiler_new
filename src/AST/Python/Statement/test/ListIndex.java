package AST.Python.Statement.test;

import AST.Python.Statement.Expr.Expr;

public class ListIndex extends Operation {
    public Test prinary;
    public Expr expr;

    public ListIndex(Test prinary, Expr expr, int line) {
        super("ListIndex", line);
        this.prinary = prinary;
        this.expr = expr;
    }

    public String toString() {
        String message = super.toString() + "{start ListIndex\n" +prinary.toString() +"\n"+expr.toString() + "\nend ListIndex\n}";
        return message;
    }
}
