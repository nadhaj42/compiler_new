package AST.Python.Statement.test.Atom1;

import AST.Python.Statement.test.Atom;

public class FloatLiteral extends Atom {
    public float value;

    public FloatLiteral(float value, int line) {
        super("Float", line);
        this.value = value;
    }

    public String toString() {
        String message = super.toString() + "{start Float\n"+ value + "\nend Float\n}";
        return message;
    }
}
