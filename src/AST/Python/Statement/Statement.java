package AST.Python.Statement;

import AST.Python.PythonNode;

public  abstract class Statement extends PythonNode {
    public Statement(String nameNode,int line){
        super(nameNode,line);
    }
    public  String toString(){
        return super.toString();
    }
}
