package AST.html_css_jinja.html;

import AST.html_css_jinja.Node;

import java.util.List;

public class Attribute extends Node {
    public Node name;
    public List<Node> value; // بدل String

    public Attribute(int line,Node name, List<Node> value) {
        super("Attribute",line);
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        String message = super.toString() + "{\n"+name.toString()+"\n";
        if (value != null)
            for (Node statement : value)
                message += statement.toString() + "\n";
        message += "}\n";
        return message;
    }
}
