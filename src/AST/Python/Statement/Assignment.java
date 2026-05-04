package AST.Python.Statement;

import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.test.Test;

public class Assignment extends Statement {
    public Test test;
    public Expr expr;

    public Assignment(Expr expr, Test test, int line) {
        super("Assignment", line);
        this.expr = expr;
        this.test = test;
    }

    public String toString() {
        String message = super.toString() + "{start Assignment\n" + test.toString() +"\n"+expr.toString() + "\nend Assignment\n}";
        return message;
    }
}
