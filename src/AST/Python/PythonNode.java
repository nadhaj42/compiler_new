package AST.Python;

public abstract class  PythonNode {
    public String nameNode ;
    public int line;
    public PythonNode(String nameNode,int line){
        this.nameNode=nameNode;
        this.line=line;
    }

    public String toString(){
        return nameNode + "(" + line+"):\n";
    }
}
