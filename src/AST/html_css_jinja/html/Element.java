package AST.html_css_jinja.html;

import AST.html_css_jinja.Node;

import java.util.List;

public abstract class Element extends Node {
    public String tag;
    public List<Attribute> attributes;

    public Element(int line,String nameNode,String tag, List<Attribute> attributes) {
        super(nameNode,line);
        this.tag = tag;
        this.attributes = attributes;
    }
    public  String toString(){
        return super.toString();
    }


}
