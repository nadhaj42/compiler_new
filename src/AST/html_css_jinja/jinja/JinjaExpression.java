package AST.html_css_jinja.jinja;

import AST.html_css_jinja.ContentNode;
import AST.html_css_jinja.Expression.ExpressionNode;

public class JinjaExpression extends ContentNode {
    public ExpressionNode expression;

    public JinjaExpression(ExpressionNode expression, int line) {
        super("JinjaExpression", line);
        this.expression = expression;
    }

    public String toString() {
        String message = super.toString() + "{\nstart JinjaExpression\n" + expression.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
