package AST.Python.Statement;

import AST.Python.Statement.Expr.Expr;

import java.util.List;

public class If extends Statement{

    public Expr condition;
    public Suite thenBranch;
    public List<ElseIf> elifBranch;
    public Else  elseBranch;

    public If(
            int line,
            Expr condition,
            Suite thenBranch,
            List<ElseIf> elifBranch,
            Else  elseBranch
    ) {
        super("If", line);
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elifBranch = elifBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public String toString() {
        String message = super.toString() + "{start If\n";
        message += condition.toString() + "\n";

        message += "then {\n";
        if (thenBranch != null)

                message += thenBranch.toString() + "\n";
        message += "}\n";

        if (elifBranch != null) {
            message += "elif {\n";
            for (ElseIf stmt : elifBranch)
                message += stmt.toString() + "\n";
            message += "}\n";
        }

        if (elseBranch != null) {
            message += "else {\n";
                message += elseBranch.toString() + "\n";
            message += "}\n";
        }

        message += "end If}\n";
        return message;
    }
}
