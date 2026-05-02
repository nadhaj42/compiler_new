package AST.Python.Statement.Primary.Atom1;

import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.Primary.Atom;

import java.util.List;

public class ListLiteral extends Atom {
    public List<Expr> elements;
    public ListLiteral(int line,List<Expr> elements) {
        super("ListLiteral",line);
        this.elements = elements;
    }

    public String toString() {
        String message = super.toString() + "{start ListLiteral\n";
        if (elements != null){
            for (Expr element : elements)
                message += element.toString() + "\n";}
        message += "end ListLiteral}\n";
        return message;
    }
}
