package AST.html_css_jinja.html;

import AST.html_css_jinja.Node;

public class TextContent extends Node {
    public String text;

    public TextContent(int line,String text) {
        super("TextContent",line);
        this.text = text;
    }

    public String toString() {
        String message=super.toString()+"{\n"+text+"\n}\n";
        return message;
    }
}
