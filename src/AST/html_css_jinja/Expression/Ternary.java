package AST.html_css_jinja.Expression;

public class Ternary extends ExpressionNode {
    public ExpressionNode trueExp;
    public ExpressionNode condition;
    public ExpressionNode falseExp;

    public Ternary(ExpressionNode trueExp, ExpressionNode condition, ExpressionNode falseExp, int line) {
        super("Ternary", line);
        this.trueExp = trueExp;
        this.condition = condition;
        this.falseExp = falseExp;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Ternary\n" + trueExp.toString() + "\n" +  condition.toString() + "\n" + falseExp.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
