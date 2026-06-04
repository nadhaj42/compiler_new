package AST.html_css_jinja.Expression;

public class IndexAccess extends ExpressionNode {
    public ExpressionNode target;
    public ExpressionNode index;

    public IndexAccess(ExpressionNode target, ExpressionNode index, int line) {
        super("IndexAccess", line);
        this.target = target;
        this.index = index;
    }

    public String toString() {
        String message = super.toString() + "{\nstart IndexAccess\n" + target.toString() + "\n" + index.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
