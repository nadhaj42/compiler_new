package AST.html_css_jinja.html;

import AST.html_css_jinja.Node;

public  abstract class AttributeValueNode extends Node {
    public AttributeValueNode(String nameNode, int line) {
        super(nameNode, line);
    }

    public String toString() {
        return super.toString();
    }
}
