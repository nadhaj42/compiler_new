package AST.Python.Statement;

import AST.Python.PythonNode;

import java.util.List;

public class ParameterList extends PythonNode {
    public List<Parameter> parameters;
    public ParameterList(int line,List<Parameter> parameters) {
        super("ParameterList",line);
        this.parameters = parameters;
    }

    public String toString() {
        String message = super.toString() + "{\nstart ParameterList\n";
        if (parameters != null){
            for (Parameter element : parameters)
                message += element.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
