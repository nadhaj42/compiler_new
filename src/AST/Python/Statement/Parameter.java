package AST.Python.Statement;

import AST.Python.PythonNode;
import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.Primary.Atom1.Variable;

public class Parameter extends PythonNode {

    public Variable variable;
    public Expr expr = null;

    public Parameter(Expr expr, Variable variable, int line) {
        super("Parameter", line);
        this.variable = variable;
        this.expr = expr;
    }

    public String toString() {
        String message = super.toString() + "{start Parameter\n" + variable.toString() + "\n";
        if (expr != null)
            message += expr.toString() + "\n;";
        message += "end Parameter\n";
        return message;
    }
}
