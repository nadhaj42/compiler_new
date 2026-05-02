package AST.html_css_jinja.jinja;

import AST.html_css_jinja.Node;

public class JinjaRawStatement extends Node {
    public String text;

    public JinjaRawStatement(int line, String text) {
        super("JinjaRawStatement", line);
        this.text = text;
    }

    @Override
    public String toString() {
        String message = super.toString() + "{\n" + text + "\n}\n";
        return message;
    }
}