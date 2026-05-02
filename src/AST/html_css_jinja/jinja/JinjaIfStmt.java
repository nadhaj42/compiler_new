package AST.html_css_jinja.jinja;

import AST.html_css_jinja.Node;

import java.util.List;

public class JinjaIfStmt extends Node {
    public String condition;
    public List<Node> thenBranch;
    public List<Node> elifBranches;
    public List<Node> elseBranch;

    public JinjaIfStmt(int line, String condition, List<Node> thenBranch, List<Node> elifBranches, List<Node> elseBranch) {
        super("JinjaIfStmt", line);
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
        this.elifBranches = elifBranches;
    }

    @Override
    public String toString() {
        String message = super.toString() + "{\n";
        message += condition.toString() + "\n";
        if (thenBranch != null)
            for (Node statement : thenBranch)
                message += statement.toString() + "\n";
        if (elifBranches != null) {
            message += "elif branch(\n";
            for (Node statement : elifBranches)
                message += statement.toString() + "\n";
            message += ")\n";
        }
        if (elseBranch != null) {
            message += "elif branch(\n";
            for (Node statement : elseBranch)
                message += statement.toString() + "\n";
            message += ")\n";
        }
        message += "}\n";
        return message;
    }
}

