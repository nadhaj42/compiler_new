package AST.Python.Statement.Primary;

import AST.Python.PythonNode;

public abstract class Primary extends PythonNode {
    public Primary(String nameNode, int line) {
        super(nameNode, line);
    }

    public String toString() {
        return super.toString();
    }
}
