package AST.html_css_jinja.jinja;

import AST.html_css_jinja.Node;

import java.util.List;

public class JinjaForStmt extends Node {
    public List<Node>  variable;
    public Node iterable;
   public List<Node> body;

    public JinjaForStmt(int line,List<Node> variable, Node iterable, List<Node> body) {
        super("JinjaForStmt",line);
        this.body = body;
        this.variable = variable;
        this.iterable = iterable;
    }

    public String toString() {
        String message = super.toString() + "{\n(";
        if (variable != null)
            for (Node statement : variable)
                message += statement.toString() + "\n";
        message += ")\n"+iterable.toString()+"\n";
        if (body != null)
            for (Node statement : body)
                message += statement.toString() + "\n";
        message += "}\n";
        return message;
    }
}
