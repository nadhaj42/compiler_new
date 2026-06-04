package AST.html_css_jinja.html;

import AST.html_css_jinja.ContentNode;

public class HtmlTextNode extends ContentNode {
    public String text;

    public HtmlTextNode(String text,int line) {
        super("HtmlTextNode", line);
        this.text = text;
    }
    public String toString() {
        String message = super.toString() + "{\nstart HtmlTextNode\n" + text + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
