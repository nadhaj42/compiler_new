package AST.html_css_jinja.css;

public class CssLiteral extends CssValueNode {
    public String text;

    public CssLiteral(String text,int line) {
        super("CssLiteral", line);
        this.text = text;
    }
    public String toString() {
        String message = super.toString() + "{\nstart CssLiteral\n" + text + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
