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
        String message = super.toString() + "{\nstart ListIndex\n";
        if (prinary != null)
            message += prinary.toString() + "\n";
        message += expr.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
