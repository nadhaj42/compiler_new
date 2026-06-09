package Semantic.htmlCssJInja;


import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
    public String name;
    private Map<String, Symbol> symbols = new LinkedHashMap<>();

    public Scope(String name) {
        this.name = name;
    }

    public void define(Symbol symbol) {
        symbols.put(symbol.name, symbol);
    }

    public Collection<Symbol> getSymbols() {
        return symbols.values();
    }
}