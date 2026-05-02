package AST.Python.Statement.Primary.Atom1;

import AST.Python.Statement.Primary.Atom;

public class StringLiteral extends Atom {
    public String value;

    public StringLiteral(String value, int line) {
        super("StringLiteral", line);
        this.value = value;
    }

    public String toString() {
        String message = super.toString() + "{start StringLiteral\n"+ value + "\nend StringLiteral\n}";
        return message;
    }
}
