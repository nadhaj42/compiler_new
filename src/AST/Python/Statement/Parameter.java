package AST.Python.Statement;

import AST.Python.PythonNode;
import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.test.Atom1.Variable;

public class Parameter extends PythonNode {

    public Variable variable;
    public Expr expr = null;

    public Parameter(Expr expr, Variable variable, int line) {
        super("Parameter", line);
        this.variable = variable;
        this.expr = expr;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Parameter\n" + variable.toString() + "\n";
        if (expr != null)
            message += expr.toString() + "\n;";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
