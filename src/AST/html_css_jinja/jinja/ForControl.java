package AST.html_css_jinja.jinja;

import AST.html_css_jinja.Node;
import AST.html_css_jinja.Expression.ExpressionNode;

import java.util.List;

public class ForControl extends Node {
    public List<ExpressionNode> iterables;
    public ExpressionNode iterable;
    public ForControl(int line,List<ExpressionNode> iterables,ExpressionNode iterable) {
        super("ForControl",line);
        this.iterables = iterables;
        this.iterable=iterable;
    }

    public String toString() {
        String message = super.toString() + "{\nstart ForControl\n"+iterable.toString()+'\n';
        if (iterables != null){
            for (ExpressionNode element : iterables)
                message += element.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}

