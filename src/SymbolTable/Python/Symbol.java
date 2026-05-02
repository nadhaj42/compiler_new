package SymbolTable.Python;


public class Symbol {
    public String name;
    public SymbolKind kind;
    public int line;
    public String scopeName;

    public Symbol(String name, SymbolKind kind, int line, String scopeName) {
        this.name = name;
        this.kind = kind;
        this.line = line;
        this.scopeName = scopeName;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-10s | %-10s | line %-3d | scope %-10s |",
                name, kind, line, scopeName
        );
    }
}