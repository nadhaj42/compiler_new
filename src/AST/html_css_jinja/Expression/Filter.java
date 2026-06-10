package AST.html_css_jinja.Expression;

import java.util.List;

public class Filter extends ExpressionNode {
    public  ExpressionNode input;
    public String filterName;
    public List<ExpressionNode> arguments;

    public Filter(ExpressionNode input,String filterName, List<ExpressionNode> argumentss, int line) {
        super("Filter", line);
        this.filterName=filterName;
        this.input = input;
        this.arguments = argumentss;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Filter\n";
        message += input.toString() + "\n"+filterName+'\n';

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
