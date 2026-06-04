package AST.html_css_jinja.css;

import AST.html_css_jinja.Expression.ExpressionNode;

public class CssExpression extends CssValueNode {
    public ExpressionNode expression;

    public CssExpression(ExpressionNode expression, int line) {
        super("CssExpression", line);
        this.expression = expression;
    }

    public String toString() {
        String message = super.toString() + "{\nstart CssExpression\n" + expression.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
