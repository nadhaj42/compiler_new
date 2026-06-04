package AST.Python.Statement;

import AST.Python.Statement.Expr.Expr;

public class Return extends Statement{
    public Expr expr = null;

    public Return(Expr expr, int line) {
        super("Return", line);
        this.expr = expr;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Return\n";
        if (expr != null){
            message += expr.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
