package AST.html_css_jinja.css;

import AST.html_css_jinja.Node;

public class CssValue extends Node {
    public String parts;

    public CssValue(int line,String parts) {
        super("CssValue", line);
        this.parts = parts;

    }

    public String toString() {
        String message=super.toString()+"{\n"+parts+"\n}";
        return message;
    }
}

