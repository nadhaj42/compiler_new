package AST.Python.Statement;

import AST.Python.PythonNode;

import java.util.List;

public class Else extends PythonNode {
    public List<Suite> statements;
    public Else(int line,List<Suite> statements) {
        super("Else",line);
        this.statements = statements;
    }

    public String toString() {
        String message = super.toString() + "{\nstart Else\n";
        if (statements != null){
            for (Suite statement : statements)
                message += statement.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
