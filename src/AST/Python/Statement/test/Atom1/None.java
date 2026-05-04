package AST.Python.Statement.test.Atom1;

import AST.Python.Statement.test.Atom;

public class None extends Atom {
    public None( int line) {
        super("None", line);
    }

    public String toString() {
        String message = super.toString() + "{start None\n"+ "None" + "\nend None\n}";
        return message;
    }
}
