package AST.html_css_jinja.html;

import AST.html_css_jinja.ContentNode;

import java.util.List;

public class HtmlElementNode extends ContentNode {
    public final String tagName;
    public final List<HtmlAttributeNode> attributes;
    public final List<ContentNode> children;

    public HtmlElementNode(String tagName, List<HtmlAttributeNode> attributes, List<ContentNode> children, int line) {
        super("HtmlElementNode", line);
        this.tagName = tagName;
        this.attributes = attributes;
        this.children = children;
    }

    public String toString() {
        String message = super.toString() + "{\nstart HtmlElementNode\n";
        message += tagName + "\n";

        if (attributes != null) {
            message += "attributes {\n";
            for (HtmlAttributeNode stmt : attributes)
                message += stmt.toString() + "\n";
            message += "}\n";
        }
        if (children != null) {
            message += "children {\n";
            for (ContentNode stmt : children)
                message += stmt.toString() + "\n";
            message += "}\n";
        }
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
