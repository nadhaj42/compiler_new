package AST.html_css_jinja.jinja;

import AST.html_css_jinja.Statement;

public class EndifMarker extends Statement {
    public EndifMarker(int line) {
        super("EndifMarker", line);
    }
}