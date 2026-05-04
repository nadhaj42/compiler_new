package AST.Python.Statement.test;

import AST.Python.Statement.test.Atom1.Variable;

public class AttributeAccess extends Operation {
    public Test prinary;
    public Variable var;

    public AttributeAccess(Test prinary, Variable var, int line) {
        super("AttributeAccess", line);
        this.prinary = prinary;
        this.var = var;
    }

    public String toString() {
        String message = super.toString() + "{start AttributeAccess\n" +prinary.toString() +"\n"+var.toString() + "\nend AttributeAccess\n}";
        return message;
    }
}
