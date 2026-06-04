package AST.html_css_jinja.html;

import AST.html_css_jinja.Expression.ExpressionNode;

public class ExpressionAttribute extends AttributeValueNode {
    public ExpressionNode expression;

    public ExpressionAttribute(ExpressionNode expression, int line) {
        super("ExpressionAttribute", line);
        this.expression = expression;
    }

    public String toString() {
        String message = super.toString() + "{\nstart ExpressionAttribute\n" + expression.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
