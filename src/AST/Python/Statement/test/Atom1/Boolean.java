package AST.Python.Statement.test.Atom1;

import AST.Python.Statement.test.Atom;

public class Boolean extends Atom {
    public boolean value;

    public Boolean(boolean value, int line) {
        super("Boolean", line);
        this.value = value;
    }

    public String toString() {
        String message = super.toString() + "{start Boolean\n"+ value + "\nend Boolean\n}";
        return message;
    }
}
