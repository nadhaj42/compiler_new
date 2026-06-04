package AST.html_css_jinja.css;

import AST.html_css_jinja.Node;

import java.util.List;

public class CssRule extends Node {
    public  String selector;
    public List<CssDeclaration> declarations;

    public CssRule(String selector, List<CssDeclaration> declarations, int line) {
        super("CssRule", line);
        this.selector = selector;
        this.declarations = declarations;
    }

    public String toString() {
        String message = super.toString() + "{\nstart CssRule\n";
        message += selector + "\n";

        if (declarations != null) {
            message += "attributes {\n";
            for (CssDeclaration stmt : declarations)
                message += stmt.toString() + "\n";
            message += "}\n";
        }
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}

