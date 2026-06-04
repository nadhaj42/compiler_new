package AST.html_css_jinja.css;

import AST.html_css_jinja.ContentNode;
import AST.html_css_jinja.Node;
import AST.html_css_jinja.html.HtmlAttributeNode;

import java.util.List;

public class CssDeclaration extends Node {
    public  String property;
    public  List<CssValueNode> values;

    public CssDeclaration(String property, List<CssValueNode> values, int line) {
        super("CssDeclaration", line);
        this.property = property;
        this.values = values;
    }

    public String toString() {
        String message = super.toString() + "{\nstart CssDeclaration\n";
        message += property + "\n";

        if (values != null) {
            message += "attributes {\n";
            for (CssValueNode stmt : values)
                message += stmt.toString() + "\n";
            message += "}\n";
        }
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}


