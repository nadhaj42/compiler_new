package Semantic.htmlCssJInja;


import java.util.ArrayList;
import java.util.List;

public class SymbolTable {

    public Scope globalScope;
    private Scope currentScope;
    // الـ scope الحالي وقت بناء الجدول (يتغير وقت الدخول/الخروج من for)

    public SymbolTable() {
        this.globalScope = new Scope("Global", null);
        this.currentScope = globalScope;
    }

    // فتح scope جديد (مثلاً عند دخول for loop) ويصير هو الـ current
    public Scope enterScope(String scopeName) {
        Scope newScope = new Scope(scopeName, currentScope);
        currentScope = newScope;
        return newScope;
    }

    // الخروج من الـ scope الحالي والرجوع لـ scope الأب
    public void exitScope() {
        if (currentScope.parent != null) {
            currentScope = currentScope.parent;
        }
        // لو هو الـ Global ما منعمل شي (مفيش أب نرجع له)
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    // تصريح رمز بالـ scope الحالي
    public boolean declare(Symbol symbol) {
        symbol.scope = currentScope;
        return currentScope.declare(symbol);
    }

    // البحث عن رمز بدءاً من الـ scope الحالي وصعوداً
    public Symbol resolve(String name) {
        return currentScope.resolve(name);
    }

    // تجميع كل الرموز الموجودة بكل الـ scopes (للطباعة الشاملة)
    public List<Symbol> getAllSymbols() {
        List<Symbol> all = new ArrayList<>();
        collectSymbols(globalScope, all);
        return all;
    }

    private void collectSymbols(Scope scope, List<Symbol> acc) {
        acc.addAll(scope.symbols.values());

    }


    public String printTable(List<Scope> allScopes) {
        StringBuilder sb = new StringBuilder();
        sb.append("==== Symbol Table (Jinja/HTML/CSS) ====\n");
        for (Scope scope : allScopes) {
            sb.append(scope.toString());
        }
        sb.append("=========================================\n");
        return sb.toString();
    }
}
