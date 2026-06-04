package AST.html_css_jinja.jinja;

import AST.html_css_jinja.ContentNode;
import AST.html_css_jinja.Statement;
import AST.html_css_jinja.Expression.ExpressionNode;

import java.util.List;

public class ElifBranch extends Statement {
    public ExpressionNode expr;
    public List<ContentNode> statements;

    public ElifBranch(ExpressionNode expr, List<ContentNode> statement, int line) {
        super("ElifBranch", line);
        this.expr = expr;
        this.statements=statement;
    }

    public String toString() {
        String message = super.toString() + "{\nstart ElifBranch\n" + expr.toString() + "\n";
        if (statements != null){
            for (ContentNode statement : statements)
                message += statement.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}

