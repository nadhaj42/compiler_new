package AST.html_css_jinja.css;

import AST.html_css_jinja.Node;

import java.util.List;

public class CssQualifiedRule extends CssStatement{
    public List<Node> selectors;
    public List<Node>body;
    public CssQualifiedRule(int line,List<Node> selectors,List<Node>body){
        super("CssQualifiedRule",line);
        this.selectors=selectors;
        this.body=body;
    }
    public String toString(){
        String message=super.toString()+"{\n(";
        if(selectors!=null)
            for(Node selector:selectors)
                message+=selector.toString()+"\n";
        message+=")\n";
        if(body!=null)
            for(Node declaration:body)
                message+=declaration.toString()+"\n";
        message+="}\n";
        return message;
    }

}
