package AST.html_css_jinja.jinja;

import AST.Python.Statement.Suite;
import AST.html_css_jinja.ContentNode;
import AST.html_css_jinja.Node;
import AST.html_css_jinja.Statement;

import java.util.List;

public class ElseBranch extends Statement {
    public List<ContentNode> statements;
    public ElseBranch(int line,List<ContentNode> statements) {
        super("ElseBranch",line);
        this.statements = statements;
    }

    public String toString() {
        String message = super.toString() + "{\nstart ElseBranch\n";
        if (statements != null){
            for (ContentNode statement : statements)
                message += statement.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}

