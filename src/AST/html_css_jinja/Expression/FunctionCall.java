package AST.html_css_jinja.Expression;

import AST.html_css_jinja.css.CssDeclaration;

import java.util.List;

public class FunctionCall extends ExpressionNode {
    public  ExpressionNode function;
    public List<ExpressionNode> arguments;

    public FunctionCall(ExpressionNode function, List<ExpressionNode> argumentss, int line) {
        super("FunctionCall", line);
        this.function = function;
        this.arguments = argumentss;
    }

    public String toString() {
        String message = super.toString() + "{\nstart FunctionCall\n";
        message += function.toString() + "\n";

        if (arguments != null) {
            message += "arguments {\n";
            for (ExpressionNode stmt : arguments)
                message += stmt.toString() + "\n";
            message += "}\n";
        }
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}

