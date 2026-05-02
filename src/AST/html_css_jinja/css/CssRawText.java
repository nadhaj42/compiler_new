package AST.html_css_jinja.css;

import AST.html_css_jinja.Node;

public class CssRawText extends Node {
    public String text;

    public CssRawText(int line,String text) {
        super("CssRawText",line);
        this.text = text;
    }

    public String toString() {
        String message=super.toString()+"{\n"+text+"\n}\n";
        return message;
    }
}
