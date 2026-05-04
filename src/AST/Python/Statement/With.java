package AST.Python.Statement;

import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.test.Atom1.Variable;

public class With extends Statement{

    public Expr expr;
    public Variable variable = null;
    public Suite statement;

    public With(Expr expr, Variable variable,Suite statement, int line) {
        super("With", line);
        this.variable = variable;
        this.expr = expr;
        this.statement = statement;
    }

    public String toString() {
        String message = super.toString() + "{start With\n" + expr.toString() + "\n";
        if (variable != null)
            message += variable.toString() + "\n;";
        message +=statement.toString()+ "\nend With\n";
        return message;
    }
}
