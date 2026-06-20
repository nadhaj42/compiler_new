package Semantic.htmlCssJInja;



import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {

    public String scopeName;
    public Scope parent;
    public Map<String, Symbol> symbols;

    public Scope(String scopeName, Scope parent) {
        this.scopeName = scopeName;
        this.parent = parent;
        this.symbols = new LinkedHashMap<>();
    }


    public boolean declare(Symbol symbol) {
        if (symbols.containsKey(symbol.name)) {
            return false;
        }
        symbols.put(symbol.name, symbol);
        return true;
    }

    // البحث محلياً بهاد الـ scope فقط، بدون صعود للـ parent
    public Symbol resolveLocal(String name) {
        return symbols.get(name);
    }


    public Symbol resolve(String name) {
        Symbol found = symbols.get(name);
        if (found != null) {
            return found;
        }
        if (parent != null) {
            return parent.resolve(name);
        }
        return null;
    }


    public boolean isGlobal() {
        return parent == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Scope(").append(scopeName).append(")");
        if (parent != null) {
            sb.append(" -> parent: ").append(parent.scopeName);
        }
        sb.append(" {\n");
        for (Symbol s : symbols.values()) {
            sb.append("    ").append(s.toString()).append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
