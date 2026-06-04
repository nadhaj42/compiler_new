package AST.html_css_jinja.Expression;

public class Identifier extends ExpressionNode {
    public String text;

    public Identifier(String text,int line) {
        super("Identifier", line);
        this.text = text;
    }
    public String toString() {
        String message = super.toString() + "{\nstart Identifier\n" + text + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
