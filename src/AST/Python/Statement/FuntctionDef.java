package AST.Python.Statement;

import AST.Python.Statement.test.Atom1.Variable;

public class FuntctionDef extends  Statement {

    public Variable variable;
    public ParameterList parameters;
    public Statement statement;

    public FuntctionDef(Variable variable, ParameterList parameters, Statement statement, int line) {
        super("FuntctionDef", line);
        this.variable = variable;
        this.parameters = parameters;
        this.statement=statement;
    }

    public String toString() {
        String message = super.toString() + "{start FuntctionDef\n" + variable.toString() + "\n";
        if (parameters != null){
                message += parameters.toString() + "\n";}
        message += statement.toString()+"end FuntctionDef\n}";
        return message;
    }
}
