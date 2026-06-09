package Semantic.htmlCssJInja;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SymbolTable {
    private Deque<Scope> scopes = new ArrayDeque<>();
    private List<Scope> allScopesList = new ArrayList<>();

    public SymbolTable() {
        enterScope("global");
    }

    public void enterScope(String name) {
        Scope newScope = new Scope(name);
        scopes.push(newScope);
        allScopesList.add(newScope);
    }

    public void exitScope() {
        if (scopes.size() > 1) {
            scopes.pop();
        }
    }

    public Scope currentScope() {
        return scopes.peek();
    }

    public void define(String name, String kind, int line) {
        if (name == null || name.trim().isEmpty() || name.equalsIgnoreCase("anonymous")) return;
        Symbol s = new Symbol(name, kind, currentScope().name, line);
        currentScope().define(s);
    }

    public void print() {
        System.out.println("\n=========================== FINAL SYMBOL TABLE ===========================");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-18s | %-22s | %-5s |\n", "Name", "Kind", "Scope Context", "Line");
        System.out.println("---------------------------------------------------------------------------");

        for (Scope scope : allScopesList) {
            for (Symbol s : scope.getSymbols()) {
                System.out.printf("| %-20s | %-18s | %-22s | %-5d |\n",
                        s.name, s.kind, s.scope, s.line);
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}