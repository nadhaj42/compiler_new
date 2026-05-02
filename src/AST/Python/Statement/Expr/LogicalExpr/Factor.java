package AST.Python.Statement.Expr.LogicalExpr;

import AST.Python.PythonNode;
import AST.Python.Statement.Expr.Logical;

public class Factor extends Logical {
    public String op;
    public PythonNode index;

    public Factor(PythonNode index, String op, int line) {
        super("Factor", line);
        this.index = index;
        this.op = op;
    }

    public String toString() {
        String message = super.toString() + "{start Factor\n" + index.toString() +"\n"+ op + "\nend Factor\n}";
        return message;
    }
}
