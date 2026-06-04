package AST.Python.Statement.Expr.LogicalExpr;

import AST.Python.Statement.Expr.Logical;

public class Not extends Logical {
    public Logical operand;  // بدل left و right

    public Not(Logical operand, int line) {
        super("Not", line);
        this.operand = operand;
    }

    public String toString() {
        return super.toString()
                + "{start Not\n"
                + operand.toString()
                + "\nend Not\n}";
    }
}