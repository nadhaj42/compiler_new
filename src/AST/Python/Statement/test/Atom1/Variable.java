package AST.Python.Statement.test.Atom1;

import AST.Python.Statement.test.Atom;

public class Variable extends Atom {
    public String name;

    public Variable( String name, int line) {
        super("Variable", line);
        this.name = name;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Variable\n"+ name + "\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
