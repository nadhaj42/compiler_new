package AST.html_css_jinja.css;

import AST.html_css_jinja.ContentNode;

import java.util.List;

public class StyleBlock extends ContentNode {
    public List<CssRule> rules;

    public StyleBlock( List<CssRule> rules, int line) {
        super("StyleBlock", line);
        this.rules = rules;
    }

    public String toString() {
        String message = super.toString() + "{\nstart StyleBlock\n";

        if (rules != null) {
            message += "attributes {\n";
            for (CssRule stmt : rules)
                message += stmt.toString() + "\n";
            message += "}\n";
        }
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}

