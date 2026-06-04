package AST.Python.Statement;

import AST.Python.PythonNode;
import AST.Python.Statement.Expr.Expr;

public class ElseIf extends PythonNode {
    public Expr expr;
    public Suite statements;

    public ElseIf( Expr expr, Suite statements, Statement statement, int line) {
        super("ElseIf", line);
        this.expr = expr;
        this.statements=statements;
    }

    public String toString() {
        String message = super.toString() + "{\nstart ElseIf\n" + expr.toString() + "\n";
        if (statements != null){
            message += statements.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
