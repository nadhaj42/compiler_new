package AST.Python.Statement;

import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.Primary.Atom1.Variable;

public class For extends Statement {

    public Expr expr;
    public Variable variable = null;
    public Suite statement;

    public For(Expr expr, Variable variable,Suite statement, int line) {
        super("For", line);
        this.variable = variable;
        this.expr = expr;
        this.statement = statement;
    }

    public String toString() {
        String message = super.toString() + "{start For\n" + variable.toString() + "\n";
            message += expr.toString() + "\n;";
        message +=statement.toString()+ "\nend For\n";
        return message;
    }
}

