package AST.html_css_jinja.Expression;

import AST.html_css_jinja.Node;

public abstract class ExpressionNode extends Node {
    public ExpressionNode(String nameNode, int line) {
        super(nameNode, line);
    }

    public String toString() {
        return super.toString();
    }
}
