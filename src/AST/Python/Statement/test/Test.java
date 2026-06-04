package AST.Python.Statement.test;

import AST.Python.PythonNode;
import AST.Python.Statement.Suite;

import java.util.List;

public  class Test extends PythonNode {
    public Atom atom;
    public List<Operation> operations;

    public Test(Atom atom, List<Operation> operations, int line) {
        super("Test", line);
        this.atom = atom;
        this.operations = operations;
    }
    public String toString() {
        String message = super.toString() + "{\nstart Test\n"+atom.toString()+"\n";
        if (operations != null){
            for (PythonNode statement : operations)
                message += statement.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
