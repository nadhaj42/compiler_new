package AST.Python.Statement;

import AST.Python.Statement.test.ArgumentList;

public class Print extends  Statement{

    public ArgumentList variables = null;

    public Print( ArgumentList variables, int line) {
        super("Print", line);
        this.variables = variables;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Print\n";
        if (variables != null){
            message += variables.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
