package AST.Python.Statement;

import AST.Python.PythonNode;

import java.util.List;

public class Suite extends PythonNode {
    public List<Statement> statements;
    public Suite(int line,List<Statement> statements) {
        super("Suite",line);
        this.statements = statements;
    }

    public String toString() {
        String message = super.toString() + "{start Suite\n";
        if (statements != null){
            for (Statement element : statements)
                message += element.toString() + "\n";}
        message += "end Suite}\n";
        return message;
    }
}
