package AST.html_css_jinja.Expression;

import AST.Python.Statement.Expr.Logical;

public class BinaryNode extends ExpressionNode{
    public ExpressionNode left;
    public String op;
    public ExpressionNode right;

    public BinaryNode(ExpressionNode left, String op, ExpressionNode right, int line) {
        super("BinaryNode", line);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public String toString() {
        String message = super.toString() + "{\nstart BinaryNode\n" + left.toString() + "\n" +  op + "\n" + right.toString() + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
