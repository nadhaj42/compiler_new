package AST.Python.Statement.test.Atom1;

import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.test.Atom;

import java.util.List;

public class SetLiteral extends Atom {
    public List<Expr> elements;
    public SetLiteral(int line,List<Expr> elements) {
        super("SetLiteral",line);
        this.elements = elements;
    }

    public String toString() {
        String message = super.toString() + "{\nstart SetLiteral\n";
        if (elements != null){
            for (Expr element : elements)
                message += element.toString() + "\n";}
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
