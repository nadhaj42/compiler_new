package AST.Python.Statement;

import AST.Python.Statement.test.ArgumentList;
import AST.Python.Statement.test.Test;

public class Decortator extends  Statement{

    public Test prinary;
    public ArgumentList argumentList = null;
    public Statement statement;

    public Decortator(Test prinary, ArgumentList argumentList, Statement statement, int line) {
        super("Decortator", line);
        this.prinary = prinary;
        this.argumentList = argumentList;
        this.statement=statement;
    }

    public String toString() {
        String message = super.toString() + "{start Decortator\n" + prinary.toString() + "\n";
        if (argumentList != null)
            message += argumentList.toString() + "\n;";
        message += statement.toString()+"end Decortator\n}";
        return message;
    }

}
