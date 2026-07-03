package Semantic.Python;

import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {
    private String scopeName;
    private SymbolTable parent;
    private Map<String, Symbol> table = new LinkedHashMap<>();

    public SymbolTable(String scopeName, SymbolTable parent) {
        this.scopeName = scopeName;
        this.parent = parent;
    }
    public Symbol lookup(String name) {
        if (table.containsKey(name)) {
            return table.get(name);
        }
        if (parent != null) {
            return parent.lookup(name);
        }
        return null;
    }


    public void define(Symbol symbol) {

        Symbol old = table.get(symbol.name);

        if (old != null) {

            System.err.println(
                    "Semantic Error: Duplicate Definition -> Variable '"
                            + symbol.name
                            + "' first defined at line "
                            + old.line
                            + " and redefined at line "
                            + symbol.line
            );

            return;
        }

        table.put(symbol.name, symbol);
    }

    public String getScopeName() { return scopeName; }
    public SymbolTable getParent() { return parent; }
    public Map<String, Symbol> getSymbols() { return table; }


    public void printTable() {
        System.out.println("=========================================================================");
        System.out.println(" SCOPE NAME: " + scopeName);
        System.out.println(" PARENT SCOPE: " + (parent != null ? parent.getScopeName() : "None"));
        System.out.println("=========================================================================");

        System.out.printf("| %-20s | %-15s | %-10s | %-15s |\n", "Symbol Name", "Type", "Line", "Scope");
        System.out.println("-------------------------------------------------------------------------");

        if (table.isEmpty()) {
            System.out.printf("| %-65s |\n", "No symbols defined in this scope.");
        } else {
            for (Symbol sym : table.values()) {
                System.out.printf("| %-20s | %-15s | %-10d | %-15s |\n",
                        sym.name, sym.type, sym.line, this.scopeName);
            }
        }
        System.out.println("=========================================================================\n");
    }

}