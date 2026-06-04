package AST.Python.Statement.test.Atom1;

import AST.Python.PythonNode;
import AST.Python.Statement.Expr.Expr;

public class KeyValuePair extends PythonNode {
    public Expr key;
    public Expr value;

    public KeyValuePair(Expr key, Expr value, int line) {
        super("KeyValuePair", line);
        this.key = key;
        this.value = value;
    }

    public String toString() {
        String message = super.toString() + "{start KeyValuePair\n" +key.toString() +"\n"+value.toString() + "\nend KeyValuePair\n}";
        return message;
    }
}
