package AST.html_css_jinja;

public  abstract class Statement extends ContentNode {
    public Statement(String nameNode, int line) {
        super(nameNode, line);
    }

    public String toString() {
        return super.toString();
    }
}
