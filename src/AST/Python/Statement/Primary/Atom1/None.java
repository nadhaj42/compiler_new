package AST.Python.Statement.Primary.Atom1;

import AST.Python.Statement.Primary.Atom;

public class None extends Atom {
    public None( int line) {
        super("None", line);
    }

    public String toString() {
        String message = super.toString() + "{start None\n"+ "None" + "\nend None\n}";
        return message;
    }
}
