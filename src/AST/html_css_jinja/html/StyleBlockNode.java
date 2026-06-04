package AST.html_css_jinja.html;

import AST.html_css_jinja.Node;

public class StyleBlockNode extends Node {
    public String cssContent;

    public StyleBlockNode(String cssContent,int line) {
        super("StyleBlockNode", line);
        this.cssContent = cssContent;
    }
    public String toString() {
        String message = super.toString() + "{\nstart StyleBlockNode\n" + cssContent + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
