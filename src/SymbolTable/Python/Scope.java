package SymbolTable.Python;


import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
    public String name;
    public Scope parent;
    private Map<String, Symbol> symbols = new LinkedHashMap<>();

    public Scope(String name, Scope parent) {
        this.name = name;
        this.parent = parent;
    }

    public boolean define(Symbol symbol) {
        if (symbols.containsKey(symbol.name))
            return false; // redeclaration
        symbols.put(symbol.name, symbol);
        return true;
    }

    public Symbol resolve(String name) {
        if (symbols.containsKey(name))
            return symbols.get(name);
        if (parent != null)
            return parent.resolve(name);
        return null;
    }

    public Collection<Symbol> getSymbols() {
        return symbols.values();
    }
}