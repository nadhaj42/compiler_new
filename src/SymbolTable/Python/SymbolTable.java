package SymbolTable.Python;

import java.util.*;

public class SymbolTable {
    private Scope currentScope;
    private List<Scope> allScopes = new ArrayList<>();

    // في كود SymbolTable.java
    public SymbolTable() {
        enterScope("global");
        define(new Symbol("__name__", SymbolKind.VARIABLE, 0, "global"));
        define(new Symbol("open", SymbolKind.FUNCTION, 0, "global"));
        define(new Symbol("len", SymbolKind.FUNCTION, 0, "global"));
    }

    public void enterScope(String name) {
        Scope scope = new Scope(name, currentScope);
        currentScope = scope;
        allScopes.add(scope);
    }

    public void exitScope() {
        if (currentScope.parent != null) {
            currentScope = currentScope.parent;
        }
    }

    public boolean define(Symbol symbol) {
        return currentScope.define(symbol);
    }

    public Symbol resolve(String name) {
        return currentScope.resolve(name);
    }

    // Fixed: Added the missing method
    public String resolveScopeName() {
        return (currentScope != null) ? currentScope.name : "unknown";
    }

    public void print() {
        System.out.println("\n====== SYMBOL TABLE ======");
        for (Scope scope : allScopes) {
            System.out.println("\nScope: " + scope.name);
            System.out.println("-----------------------------------");
            for (Symbol s : scope.getSymbols()) {
                System.out.println(s);
            }
        }
    }

    private static class Scope {
        String name;
        Scope parent;
        Map<String, Symbol> symbols = new LinkedHashMap<>();

        Scope(String name, Scope parent) {
            this.name = name;
            this.parent = parent;
        }

        boolean define(Symbol sym) {
            if (symbols.containsKey(sym.name)) return false;
            symbols.put(sym.name, sym);
            return true;
        }

        Symbol resolve(String name) {
            if (symbols.containsKey(name)) return symbols.get(name);
            if (parent != null) return parent.resolve(name);
            return null;
        }

        Collection<Symbol> getSymbols() {
            return symbols.values();
        }
    }
}