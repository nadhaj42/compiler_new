package AST.Python.Statement.test.Atom1;

import AST.Python.Statement.test.Atom;

import java.util.List;

public class DistLiteral extends Atom {
    public List<KeyValuePair> elements;

    public DistLiteral(int line, List<KeyValuePair> elements) {
        super("DistLiteral", line);
        this.elements = elements;
    }

    public String toString() {
        String message = super.toString() + "{start DistLiteral\n";
        if (elements != null) {
            for (KeyValuePair element : elements)
                message += element.toString() + "\n";
        }
        message += "end DistLiteral}\n";
        return message;
    }
}
