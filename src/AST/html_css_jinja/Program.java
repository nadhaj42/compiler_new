package AST.html_css_jinja;

import java.util.List;

public class Program extends Node {
    public List<Node> statements;


    public Program(int line, List<Node> statements) {
        super("Program",line);
        this.statements = statements;

    }

    @Override
    public String toString() {
        String message="{\n"+super.toString();
       if(statements.size()!=0)
           for(Node statement:statements)
               message+=statement.toString()+"\n";
        message += "}\nend"+super.toString()+"\n";
             return message;
    }
}
