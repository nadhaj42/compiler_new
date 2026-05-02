package AST.Python.Statement.Primary.Atom1;

import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.Primary.Atom;

import java.util.List;

public class SetLiteral extends Atom {
    public List<Expr> elements;
    public SetLiteral(int line,List<Expr> elements) {
        super("SetLiteral",line);
        this.elements = elements;
    }

    public String toString() {
        String message = super.toString() + "{start SetLiteral\n";
        if (elements != null){
            for (Expr element : elements)
                message += element.toString() + "\n";}
        message += "end SetLiteral}\n";
        return message;
    }
}
