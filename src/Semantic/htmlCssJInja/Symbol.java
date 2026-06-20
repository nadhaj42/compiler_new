package Semantic.htmlCssJInja;

import java.util.ArrayList;
import java.util.List;

public class Symbol {

    public String name;
    public SymbolKind kind;
    public DataType dataType;
    public Scope scope;
    public int line;
    public Object value;
    public List<Integer> usages;

    public Symbol(String name, SymbolKind kind, DataType dataType, Scope scope, int line, Object value) {
        this.name = name;
        this.kind = kind;
        this.dataType = dataType;
        this.scope = scope;
        this.line = line;
        this.value = value;
        this.usages = new ArrayList<>();
    }

    // Constructor مختصر لحالة عدم معرفة القيمة وقت التصريح
    public Symbol(String name, SymbolKind kind, DataType dataType, Scope scope, int line) {
        this(name, kind, dataType, scope, line, null);
    }

    // تسجيل سطر استخدام جديد للرمز (بدون تكرار نفس السطر مرتين)
    public void addUsage(int usageLine) {
        if (usageLine != this.line && !usages.contains(usageLine)) {
            usages.add(usageLine);
        }
    }

    public String toString() {
        String scopeName = (scope != null) ? scope.scopeName : "null";
        return "Symbol{name='" + name + "'"
                + ", kind=" + kind
                + ", dataType=" + dataType
                + ", scope='" + scopeName + "'"
                + ", line=" + line
                + ", value=" + (value != null ? value : "null")
                + ", usages=" + usages
                + "}";
    }
}
