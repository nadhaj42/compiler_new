package AST.Python.Statement.Primary;

import AST.Python.Statement.Primary.Atom1.Variable;

public class AttributeAccess extends Primary {
    public Primary prinary;
    public Variable var;

    public AttributeAccess(Primary prinary, Variable var, int line) {
        super("AttributeAccess", line);
        this.prinary = prinary;
        this.var = var;
    }

    public String toString() {
        String message = super.toString() + "{start AttributeAccess\n" +prinary.toString() +"\n"+var.toString() + "\nend AttributeAccess\n}";
        return message;
    }
}
