//package AST.html_css_jinja.css;
//
//import AST.html_css_jinja.Node;
//
//public  abstract class  CssValueNode extends Node {
//    public CssValueNode(String nameNode, int line) {
//        super(nameNode, line);
//    }
//
//    public String toString() {
//        return super.toString();
//    }
//}


package AST.html_css_jinja.css;

import AST.html_css_jinja.Node;

public abstract class CssValueNode extends Node {

    public boolean precededByComma = false;

    public CssValueNode(String nameNode, int line) {
        super(nameNode, line);
    }

    public String toString() {
        return super.toString();
    }
}