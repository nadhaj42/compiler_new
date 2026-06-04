package AST.html_css_jinja.html;

import AST.html_css_jinja.ContentNode;

public class HtmlAttributeNode extends ContentNode {
    public final String name;

    public final AttributeValueNode value;

    public HtmlAttributeNode(String name, AttributeValueNode value, int line) {
        super("AttributeNode", line);
        this.name = name;
        this.value = value;
    }

    public String toString() {
        String message = super.toString() + "{\nstart HtmlAttributeNode\n" + name + "\n" + value.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
