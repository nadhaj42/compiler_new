package AST.html_css_jinja.css;

import AST.html_css_jinja.Node;

public abstract class  CssStatement extends Node {
    public CssStatement(String nameNode,int line){
        super(nameNode,line);
    }
  public  String toString(){
        return super.toString();
  }
}
