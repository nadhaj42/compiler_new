package AST.Python.Statement;

import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.Primary.Primary;

public class Assignment extends Statement {
    public Primary primary;
    public Expr expr;

    public Assignment(Expr expr, Primary primary, int line) {
        super("Assignment", line);
        this.expr = expr;
        this.primary = primary;
    }

    public String toString() {
        String message = super.toString() + "{start Assignment\n" +primary.toString() +"\n"+expr.toString() + "\nend Assignment\n}";
        return message;
    }
}
