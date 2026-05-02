package AST.html_css_jinja.css;

import AST.html_css_jinja.Node;

import java.util.List;

public class CssStyle extends Node {
    public List<Node> statements;

    public CssStyle(int line, List<Node> statements) {
        super("CssStyle", line);
        this.statements = statements;

    }

    public String toString() {
        String message = super.toString() + "{\n";
        if (statements!=null)
            for (Node statement : statements)
                message += statement.toString() + "\n";
        message += "}\n";
        return message;
    }
}
