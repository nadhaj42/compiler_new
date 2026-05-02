package AST.Python.Statement;

import AST.Python.Statement.Expr.Expr;

public class While extends Statement{
    public Expr expr;
    public Suite statement;

    public While(Expr expr,Suite statement, int line) {
        super("While", line);
        this.expr = expr;
        this.statement = statement;
    }

    public String toString() {
        String message = super.toString() + "{start While\n";
        message += expr.toString() + "\n;";
        message +=statement.toString()+ "\nend While\n";
        return message;
    }
}
