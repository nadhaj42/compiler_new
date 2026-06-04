package AST.Python.Statement.test;

public class FunctionCall extends Operation {

    public Test prinary;
    public ArgumentList argumentList = null;

    public FunctionCall(Test prinary, ArgumentList argumentList, int line) {
        super("FunctionCall", line);
        this.prinary = prinary;
        this.argumentList = argumentList;
    }

    public String toString() {
        String message = super.toString() + "{start FunctionCall\n";
        if (prinary != null)
            message += prinary.toString() + "\n";
        if (argumentList != null)
            message += argumentList.toString() + "\n";
        message += "end FunctionCall\n}";
        return message;
    }
}
