package AST.html_css_jinja.Expression;

public class StringNode extends ExpressionNode{
    public String text;

    public StringNode(String text,int line) {
        super("StringNode", line);
        this.text = text;
    }
    public String toString() {
        String message = super.toString() + "{\nstart StringNode\n" + text + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
