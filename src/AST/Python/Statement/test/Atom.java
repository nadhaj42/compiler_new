package AST.Python.Statement.test;

import AST.Python.PythonNode;

public abstract class Atom extends PythonNode {
    public Atom(String nameNode, int line) {
        super(nameNode, line);
    }

    public String toString() {
        return super.toString();
    }
}
