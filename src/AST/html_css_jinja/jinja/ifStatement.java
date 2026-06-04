package AST.html_css_jinja.jinja;

import AST.html_css_jinja.ContentNode;
import AST.html_css_jinja.Statement;
import AST.html_css_jinja.Expression.ExpressionNode;

import java.util.List;

public class ifStatement extends Statement {

    public ExpressionNode condition;
    public ContentNode thenBranch;
    public List<ElifBranch> elifBranch;
    public ElseBranch elseBranch;

    public ifStatement(
            int line,
            ExpressionNode condition,
            ContentNode thenBranch,
            List<ElifBranch> elifBranch,
            ElseBranch elseBranch
    ) {
        super("ifStatement", line);
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elifBranch = elifBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public String toString() {
        String message = super.toString() + "{\nstart ifStatement\n";
        message += condition.toString() + "\n";

        message += "then {\n";
        if (thenBranch != null)

            message += thenBranch.toString() + "\n";
        message += "}\n";

        if (elifBranch != null) {
            message += "elif {\n";
            for (ElifBranch stmt : elifBranch)
                message += stmt.toString() + "\n";
            message += "}\n";
        }

        if (elseBranch != null) {
            message += "else {\n";
            message += elseBranch.toString() + "\n";
            message += "}\n";
        }

        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}


