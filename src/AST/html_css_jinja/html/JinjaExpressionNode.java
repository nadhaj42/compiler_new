package AST.html_css_jinja.html;

import AST.html_css_jinja.Expression.ExpressionNode;
import AST.html_css_jinja.Node;

public class JinjaExpressionNode extends Node {

  public ExpressionNode expression;

    public JinjaExpressionNode(ExpressionNode expression,int line) {
        super("JinjaExpressionNode", line);
        this.expression = expression;
    }
    public String toString() {
        String message = super.toString() + "{\nstart JinjaExpressionNode\n" + expression.toString() + "\n}";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
