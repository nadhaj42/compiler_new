package AST.Python.Statement.Primary.Atom1;

import AST.Python.Statement.Primary.Atom;

public class Number extends Atom {
    public int value;

    public Number(int value, int line) {
        super("Number", line);
        this.value = value;
    }

    public String toString() {
        String message = super.toString() + "{start Number\n"+ value + "\nend Number\n}";
        return message;
    }
}
