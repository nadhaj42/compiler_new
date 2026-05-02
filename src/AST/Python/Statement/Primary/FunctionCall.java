package AST.Python.Statement.Primary;

public class FunctionCall extends Primary {

    public Primary prinary;
    public ArgumentList argumentList = null;

    public FunctionCall(Primary prinary, ArgumentList argumentList, int line) {
        super("FunctionCall", line);
        this.prinary = prinary;
        this.argumentList = argumentList;
    }

    public String toString() {
        String message = super.toString() + "{start FunctionCall\n" + prinary.toString() + "\n";
        if (argumentList != null)
            message += argumentList.toString() + "\n;";
        message += "end FunctionCall\n}";
        return message;
    }
}
