package AST.Python.Statement.test;

import AST.Python.Statement.Expr.Logical;
import java.util.List;

public class Primary extends Logical {

    public Atom atom;
    public List<Operation> operations;

    public Primary(
            Atom atom,
            List<Operation> operations,
            int line
    ) {
        super("Primary", line);
        this.atom = atom;
        this.operations = operations;
    }

    @Override
    public String toString() {
        String message = super.toString() + "{\nstart Primary\n" + atom.toString() + "\n";
        if (operations != null) {
            for (Operation op : operations)
                message += op.toString() + "\n";
        }
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}