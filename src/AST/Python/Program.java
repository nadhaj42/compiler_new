package AST.Python;

import AST.Python.Statement.Statement;

import java.util.List;

public class Program extends PythonNode {
    public List<Statement> statements;

    public Program(int line,List<Statement> statements) {
        super("Program",line);
        this.statements = statements;
    }


    @Override
    public String toString() {
        String message = super.toString() + "{start program\n";
        if (statements != null){
            for (PythonNode statement : statements)
                message += statement.toString() + "\n";}
        message += "end program}\n";
        return message;
    }
}
