package AST.Python.Statement.Primary;

import AST.Python.Statement.Expr.Expr;

public class ListIndex extends Primary {
    public Primary prinary;
    public Expr expr;

    public ListIndex(Primary prinary, Expr expr, int line) {
        super("ListIndex", line);
        this.prinary = prinary;
        this.expr = expr;
    }

    public String toString() {
        String message = super.toString() + "{start ListIndex\n" +prinary.toString() +"\n"+expr.toString() + "\nend ListIndex\n}";
        return message;
    }
}
