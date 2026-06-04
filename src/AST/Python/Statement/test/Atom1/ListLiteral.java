package AST.Python.Statement.test.Atom1;

import AST.Python.PythonNode;
import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.test.Atom;

import java.util.List;

public class ListLiteral extends Atom {
    public List<PythonNode> elements;

    public ListLiteral(int line, List<PythonNode> elements) {
        super("ListLiteral", line);
        this.elements = elements;
    }

    public String toString() {
        String message = super.toString() + "{start ListLiteral\n";
        if (elements != null) {
            for (PythonNode element : elements)
                message += element.toString() + "\n";
        }
        message += "end ListLiteral}\n";
        return message;
    }
}
