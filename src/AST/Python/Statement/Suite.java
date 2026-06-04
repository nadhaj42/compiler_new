package AST.Python.Statement;

import AST.Python.PythonNode;

import java.util.List;

public class Suite extends Statement {
    public List<Statement> statements;
    public Suite(int line,List<Statement> statements) {
        super("Suite",line);
        this.statements = statements;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Suite\n";
        if (statements != null){
            for (Statement element : statements)
                message += element.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
