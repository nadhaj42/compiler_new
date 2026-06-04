package AST.html_css_jinja.html;

public class StringAttribute extends AttributeValueNode {
    public String value;

    public StringAttribute(String value, int line) {
        super("StringAttribute", line);
        this.value = value;
    }

    public String toString() {
        String message = super.toString() + "{\nstart StringAttribute\n" + value + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}

