package AST.html_css_jinja.css;

import AST.html_css_jinja.Node;

import java.util.List;

public class CssAtRule extends CssStatement {
    public String name;
    public List<Node> prelude;
    public List<Node> body;

    public CssAtRule(int line,String name, List<Node> prelude, List<Node> body) {
        super("CssAtRule",line);
        this.name = name;
        this.prelude = prelude;
        this.body = body;
    }

    public String toString() {
        String message=super.toString()+"{\n"+name+"(\n";
        if(prelude!=null)
            for(Node statement:prelude)
                message+=statement.toString()+"\n";
        message+=")\n";
        if(body!=null)
            for(Node statement:body)
                message+=statement.toString()+"\n";
        message+="}\n";
        return message;
    }
}
