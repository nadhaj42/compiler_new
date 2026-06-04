package AST.Python.Statement.test.Atom1;

import AST.Python.Statement.test.Atom;

public class StringLiteral extends Atom {
    public String value;

    public StringLiteral(String value, int line) {
        super("StringLiteral", line);
        this.value = value;
    }

    public String toString() {
        String message = super.toString() + "{\nstart StringLiteral\n"+ value + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
