package AST.html_css_jinja.Expression;

public class Member extends ExpressionNode{
    public ExpressionNode object;
    public String member;

    public Member(ExpressionNode object, String member, int line) {
        super("Member", line);
        this.object = object;
        this.member = member;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Member\n" + object.toString() + "\n" +  member + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
