package AST.Python.Statement.test;

import AST.Python.PythonNode;
import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.test.Atom1.Variable;

public class Argument extends PythonNode {
    public Expr expr;
    public Variable var = null;

    public Argument(Expr expr, Variable var, int line) {
        super("Argument", line);
        this.expr = expr;
        this.var = var;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Argument\n";
        if (var != null)
            message += var.toString() + "\n";
        message += expr.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
