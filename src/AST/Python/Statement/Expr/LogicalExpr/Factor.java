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
        // الـ operator قبل الـ operand
        String message = super.toString()
                + "{start Factor\n"
                + op + "\n"           // ← op أولاً
                + index.toString()
                + "\nend Factor\n}";
        return message;
    }
}