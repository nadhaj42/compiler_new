package AST.html_css_jinja.html;

import AST.html_css_jinja.Node;

import java.util.List;

public class PairedElement extends Element {
    public List<Node> chidren;

    public PairedElement(int line,String tag, List<Attribute> attributes, List<Node> chidren) {
        super(line,"PairedElement",tag, attributes);
        this.chidren = chidren;
    }

    public String toString() {
        String message = super.toString() + "{\n"+tag+"\n(";
        if (attributes != null)
            for (Attribute attribute : attributes)
                message += attribute.toString() + "\n";
        message += ")\n";
        if (chidren != null)
            for (Node stetement : chidren)
                message += stetement.toString() + "\n";
        message += "}\n";

        return message;
    }
}
