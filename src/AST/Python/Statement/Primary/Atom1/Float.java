package AST.Python.Statement.Primary.Atom1;

import AST.Python.Statement.Primary.Atom;

public class Float extends Atom {
    public float value;

    public Float(float value, int line) {
        super("Float", line);
        this.value = value;
    }

    public String toString() {
        String message = super.toString() + "{start Float\n"+ value + "\nend Float\n}";
        return message;
    }
}
