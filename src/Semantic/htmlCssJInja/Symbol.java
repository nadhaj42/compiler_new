package Semantic.htmlCssJInja;

public class Symbol {
    public String name;
    public String kind;
    public String scope;
    public int line;

    public Symbol(String name, String kind, String scope, int line) {
        this.name = name;
        this.kind = kind;
        this.scope = scope;
        this.line = line;
    }
}