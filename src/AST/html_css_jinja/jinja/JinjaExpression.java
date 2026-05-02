package AST.html_css_jinja.jinja;

import AST.html_css_jinja.Node;

public class JinjaExpression extends Node {
    public Node expression;

    public JinjaExpression(int line,Node expression) {
        super("JinjaExpression",line);
        this.expression = expression;
    }

    public String toString() {
        String message=super.toString()+"{\n"+expression+"\n}\n";
        return message;
    }
}
