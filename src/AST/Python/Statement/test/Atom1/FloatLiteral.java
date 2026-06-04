package AST.Python.Statement.test.Atom1;

import AST.Python.Statement.test.Atom;

public class FloatLiteral extends Atom {
    public float value;

    public FloatLiteral(float value, int line) {
        super("Float", line);
        this.value = value;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Float\n"+ value + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
