package AST.html_css_jinja.html;

import java.util.List;

public class SelfClosingElement extends Element {
    public SelfClosingElement(int line,String tag, List<Attribute> attributes){
        super(line,"SelfClosingElement",tag,attributes);
    }
    public String toString() {
        String message = super.toString() + "{\n"+tag+"\n";
        if (attributes != null)
            for (Attribute attribute : attributes)
                message += attribute.toString() + "\n";
        message += "}\n";
        return message;
    }
}
