package AST.Python.Statement.Expr.LogicalExpr;

import AST.Python.Statement.Expr.Logical;

public class Not extends Logical {
    public Logical operand;  // بدل left و right

    public Not(Logical operand, int line) {
        super("Not", line);
        this.operand = operand;
    }

    public String toString() {
      String message= super.toString()
                + "{\nstart Not\n"
                + operand.toString()
                + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;

    }
}