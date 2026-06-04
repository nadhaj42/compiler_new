package AST.Python.Statement.Expr;

import AST.Python.Statement.test.Atom1.Variable;
import AST.Python.Statement.Expr.Logical;
public class ListComprehension extends Logical {

    public Expr element;
    public Variable variable;
    public Expr iterable;
    public Expr condition;

    public ListComprehension(
            Expr element,
            Variable variable,
            Expr iterable,
            Expr condition,
            int line
    ) {
        super("ListComprehension", line);
        this.element = element;
        this.variable = variable;
        this.iterable = iterable;
        this.condition = condition;
    }

    @Override
    public String toString() {
        String message = super.toString()
                + "{start ListComprehension\n"
                + "element: " + element.toString()
                + "variable: " + variable.toString()
                + "iterable: " + iterable.toString();
        if (condition != null)
            message += "condition: " + condition.toString();
        message += "end ListComprehension}\n";
        return message;
    }
}