package AST.html_css_jinja.css;

import AST.html_css_jinja.Node;

import java.util.List;

public class CssDeclaration extends Node {
    public Node property;
    public List<Node> value;

    public CssDeclaration( int line,Node property, List<Node> value) {
        super("CssDeclaration",line);
        this.property = property;
        this.value = value;
    }

    public String toString() {
        String message=super.toString()+"{\n"+property.toString()+"\n(";
        if (value!=null)
            for (Node statement : value)
                message += statement.toString() + "\n";
        message += "}\n";
        return message;
    }
}
