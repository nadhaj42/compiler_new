package AST.html_css_jinja.Expression;

public class Number extends ExpressionNode{
    public double text;

    public Number(double text,int line) {
        super("Number", line);
        this.text = text;
    }
    public String toString() {
        String message = super.toString() + "{\nstart Number\n" + text + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
