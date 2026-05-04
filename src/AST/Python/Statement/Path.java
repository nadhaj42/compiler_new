package AST.Python.Statement;

import AST.Python.PythonNode;
import AST.Python.Statement.test.Atom1.Variable;

import java.util.List;

public class Path extends PythonNode {
    public List<Variable> elements;
    public Path(int line,List<Variable> elements) {
        super("Path",line);
        this.elements = elements;
    }

    public String toString() {
        String message = super.toString() + "{start Path\n";
        if (elements != null){
            for (Variable element : elements)
                message += element.toString() + "\n";}
        message += "end Path}\n";
        return message;
    }
}
