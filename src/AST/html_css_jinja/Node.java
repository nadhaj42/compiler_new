package AST.html_css_jinja;

public abstract class Node {
    public String nameNode ;
    public int line;
    public Node(String nameNode,int line){
        this.nameNode=nameNode;
        this.line=line;
    }

   public String toString(){
         return nameNode + "(" + line+")\n";
   }
}
