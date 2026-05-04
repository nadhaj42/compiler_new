package AST.Python.Statement.test;

import AST.Python.PythonNode;

import java.util.List;

public class ArgumentList extends PythonNode {
    public Argument argument;
    public List<Argument> elements;

    public ArgumentList(int line, List<Argument> elements,Argument argument) {
        super("ArgumentList", line);
        this.elements = elements;
        this.argument=argument;
    }

    public String toString() {
        String message = super.toString() + "{start ArgumentList\n"+argument.toString()+"\n";
        if (elements != null) {
            for (Argument element : elements)
                message += element.toString() + "\n";
        }
        message += "end ArgumentList}\n";
        return message;
    }
}
