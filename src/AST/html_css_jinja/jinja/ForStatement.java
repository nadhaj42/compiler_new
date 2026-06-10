package AST.html_css_jinja.jinja;

import AST.html_css_jinja.ContentNode;
import AST.html_css_jinja.Statement;

import java.util.List;

public class ForStatement extends Statement {
    public List<ContentNode> body;
    public ForControl  control;
    public ForStatement(int line,List<ContentNode> body,ForControl  control) {
        super("ForStatement",line);
        this.control = control;
        this.body=body;
    }

    public String toString() {
        String message = super.toString() + "{\nstart ForStatement\n"+control.toString()+'\n';
        message += "body {\n";
        if (body != null){
            for (ContentNode element : body)
                message += element.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}

