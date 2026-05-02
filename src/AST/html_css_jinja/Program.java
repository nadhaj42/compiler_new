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
        String message=super.toString()+"{\n";
       if(statements.size()!=0)
           for(Node statement:statements)
               message+=statement.toString()+"\n";
       message+="}\n";
             return message;
    }
}
