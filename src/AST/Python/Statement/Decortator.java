package AST.Python.Statement;

import AST.Python.Statement.test.ArgumentList;
import AST.Python.Statement.test.Primary;


public class Decortator extends  Statement{

    public Primary prinary;
    public ArgumentList argumentList = null;
    public Statement statement;

    public Decortator(Primary prinary, ArgumentList argumentList, Statement statement, int line) {
        super("Decortator", line);
        this.prinary = prinary;
        this.argumentList = argumentList;
        this.statement=statement;
    }

    public String toString() {
        String message = super.toString() + "{start Decortator\n" + prinary.toString() + "\n";
        if (argumentList != null)
            message += argumentList.toString() + "\n;";
        message += statement.toString()+"\n";
        message += "}\nend"+super.toString()+"\n";
        return message;
    }

}
