package Generation.Python;
import AST.Python.PythonNode;
import AST.Python.Program;
import AST.Python.Statement.*;
import AST.Python.Statement.Expr.Expr;
import AST.Python.Statement.Expr.ListComprehension;
import AST.Python.Statement.Expr.LogicalExpr.*;
import AST.Python.Statement.test.*;
import AST.Python.Statement.test.Atom1.DistLiteral;
import AST.Python.Statement.test.Atom1.FloatLiteral;
import AST.Python.Statement.test.Atom1.KeyValuePair;
import AST.Python.Statement.test.Atom1.ListLiteral;
import AST.Python.Statement.test.Atom1.None;
import AST.Python.Statement.test.Atom1.SetLiteral;
import AST.Python.Statement.test.Atom1.StringLiteral;
import AST.Python.Statement.test.Atom1.Variable;

import java.util.*;
public class PythonGenerator {
    private static final Set<String> BUILTIN_FUNCS = Set.of("len", "range", "str", "int", "float", "abs", "print");
    private final StringBuilder capturedOutput = new StringBuilder();
    public Environment execute(Program program) {
        Environment global = new Environment(null);
        if (program != null && program.statements != null) {
            for (Statement stmt : program.statements) {
                execStatement(stmt, global);
            }
        }
        return global;
    }
    public String getCapturedOutput() {
        return capturedOutput.toString();
    }
    private void execStatement(Statement stmt, Environment env) {
        if (stmt == null) return;
        if (stmt instanceof Suite) {
            Suite s = (Suite) stmt;
            if (s.statements != null) for (Statement st : s.statements) execStatement(st, env);
        } else if (stmt instanceof Assignment) {
            execAssignment((Assignment) stmt, env);
        } else if (stmt instanceof FuntctionDef) {
            FuntctionDef def = (FuntctionDef) stmt;
            if (def.variable != null) {
                env.define(def.variable.name, new PyFunction(def, env));
            }
        } else if (stmt instanceof If) {
            execIf((If) stmt, env);
        } else if (stmt instanceof For) {
            execFor((For) stmt, env);
        } else if (stmt instanceof While) {
            execWhile((While) stmt, env);
        } else if (stmt instanceof Return) {
            Return r = (Return) stmt;
            Object value = (r.expr != null) ? eval(r.expr, env) : null;
            throw new ReturnSignal(value);
        } else if (stmt instanceof Print) {
            execPrint((Print) stmt, env);
        } else if (stmt instanceof Import) {
        } else if (stmt instanceof With) {
            execStatement(((With) stmt).statement, env);
        } else if (stmt instanceof Decortator) {
            execStatement(((Decortator) stmt).statement, env);
        } else if (stmt instanceof Expr) {
            eval((Expr) stmt, env);
        }
    }
    private void execAssignment(Assignment assign, Environment env) {
        Object value = eval(assign.expr, env);
        Primary target = assign.test;
        if (target == null || target.atom == null) return;
        boolean simpleVariable = target.atom instanceof Variable
                && (target.operations == null || target.operations.isEmpty());
        if (simpleVariable) {
            env.define(((Variable) target.atom).name, value);
        } else {
            assignComplexTarget(target, value, env);
        }
    }
    @SuppressWarnings("unchecked")
    private void assignComplexTarget(Primary target, Object value, Environment env) {
        List<Operation> ops = target.operations;
        if (ops == null || ops.isEmpty()) return;
        Object base = evalAtom(target.atom, env);
        for (int i = 0; i < ops.size() - 1; i++) {
            base = applyOperation(base, ops.get(i), env);
        }
        Operation last = ops.get(ops.size() - 1);
        if (last instanceof AttributeAccess) {
            String name = ((AttributeAccess) last).var.name;
            if (base instanceof Map) ((Map<Object, Object>) base).put(name, value);
        } else if (last instanceof ListIndex) {
            Object idx = eval(((ListIndex) last).expr, env);
            if (base instanceof List) {
                int i = toInt(idx);
                List<Object> list = (List<Object>) base;
                while (list.size() <= i) list.add(null);
                list.set(i, value);
            } else if (base instanceof Map) {
                ((Map<Object, Object>) base).put(idx, value);
            }
        }
    }
    private void execIf(If ifs, Environment env) {
        if (truthy(eval(ifs.condition, env))) {
            execStatement(ifs.thenBranch, env);
            return;
        }
        if (ifs.elifBranch != null) {
            for (ElseIf elif : ifs.elifBranch) {
                if (truthy(eval(elif.expr, env))) {
                    execStatement(elif.statements, env);
                    return;
                }
            }
        }
        if (ifs.elseBranch != null && ifs.elseBranch.statements != null) {
            for (Suite s : ifs.elseBranch.statements) execStatement(s, env);
        }
    }

    private void execFor(For forStmt, Environment env) {
        Object iterableVal = eval(forStmt.expr, env);
        for (Object item : toIterable(iterableVal)) {
            if (forStmt.variable != null) env.define(forStmt.variable.name, item);
            execStatement(forStmt.statement, env);
        }
    }

    private void execWhile(While whileStmt, Environment env) {
        int guard = 0;
        while (truthy(eval(whileStmt.expr, env)) && guard < 100_000) {
            execStatement(whileStmt.statement, env);
            guard++;
        }
    }
    private void execPrint(Print print, Environment env) {
        List<ArgValue> args = evalArguments(print.variables, env);
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < args.size(); i++) {
            if (i > 0) line.append(" ");
            line.append(toDisplayString(args.get(i).value));
        }
        capturedOutput.append(line).append("\n");
    }
    private Object eval(PythonNode node, Environment env) {
        if (node == null) return null;
        if (node instanceof Primary) {
            Primary p = (Primary) node;
            return evalAtomOps(p.atom, p.operations, env);
        } else if (node instanceof Test) {
            Test t = (Test) node;
            return evalAtomOps(t.atom, t.operations, env);
        } else if (node instanceof And) {
            And a = (And) node;
            return truthy(eval(a.left, env)) && truthy(eval(a.right, env));
        } else if (node instanceof Or) {
            Or o = (Or) node;
            return truthy(eval(o.left, env)) || truthy(eval(o.right, env));
        } else if (node instanceof Not) {
            Not n = (Not) node;
            return !truthy(eval(n.operand, env));
        } else if (node instanceof Comparison) {
            Comparison c = (Comparison) node;
            return evalComparison(eval(c.left, env), c.op, eval(c.right, env));
        } else if (node instanceof PlusMinus) {
            PlusMinus pm = (PlusMinus) node;
            return evalPlusMinus(eval(pm.left, env), pm.op, eval(pm.right, env));
        } else if (node instanceof MulDiv) {
            MulDiv md = (MulDiv) node;
            return evalMulDiv(eval(md.left, env), md.op, eval(md.right, env), md.line);
        } else if (node instanceof Factor) {
            Factor f = (Factor) node;
            return evalUnary(f.op, eval(f.index, env));
        } else if (node instanceof ListComprehension) {
            return evalListComprehension((ListComprehension) node, env);
        } else if (node instanceof Atom) {
            return evalAtomOps((Atom) node, null, env);
        }
        return null;
    }
    private Object evalAtomOps(Atom atom, List<Operation> operations, Environment env) {
        Object base = evalAtom(atom, env);
        if (operations != null) {
            for (Operation op : operations) {
                base = applyOperation(base, op, env);
            }
        }
        return base;
    }
    private Object evalAtom(Atom atom, Environment env) {
        if (atom == null) return null;
        if (atom instanceof AST.Python.Statement.test.Atom1.Number) {
            return ((AST.Python.Statement.test.Atom1.Number) atom).value; // int
        } else if (atom instanceof FloatLiteral) {
            return Double.parseDouble(Float.toString(((FloatLiteral) atom).value));
        } else if (atom instanceof StringLiteral) {
            return stripPythonStringQuotes(((StringLiteral) atom).value);
        } else if (atom instanceof AST.Python.Statement.test.Atom1.Boolean) {
            return ((AST.Python.Statement.test.Atom1.Boolean) atom).value;
        } else if (atom instanceof None) {
            return null;
        } else if (atom instanceof Variable) {
            String name = ((Variable) atom).name;
            if (env.isDefined(name)) return env.get(name);
            if (BUILTIN_FUNCS.contains(name)) return new Builtin(name);
            throw new RuntimeException("Runtime Error: Undefined variable '" + name + "' at line " + atom.line);
        } else if (atom instanceof ListLiteral) {
            List<Object> list = new ArrayList<>();
            List<PythonNode> elements = ((ListLiteral) atom).elements;
            if (elements != null) for (PythonNode el : elements) list.add(eval(el, env));
            return list;
        } else if (atom instanceof DistLiteral) {
            Map<Object, Object> map = new LinkedHashMap<>();
            List<KeyValuePair> elements = ((DistLiteral) atom).elements;
            if (elements != null) {
                for (KeyValuePair kv : elements) map.put(eval(kv.key, env), eval(kv.value, env));
            }
            return map;
        } else if (atom instanceof SetLiteral) {
            Set<Object> set = new LinkedHashSet<>();
            List<Expr> elements = ((SetLiteral) atom).elements;
            if (elements != null) for (Expr el : elements) set.add(eval(el, env));
            return set;
        }
        return null;
    }
    private Object applyOperation(Object base, Operation op, Environment env) {
        if (op instanceof FunctionCall) {
            FunctionCall fc = (FunctionCall) op;
            List<ArgValue> args = evalArguments(fc.argumentList, env);
            return callFunction(base, args, fc.line);
        } else if (op instanceof AttributeAccess) {
            AttributeAccess aa = (AttributeAccess) op;
            return getAttribute(base, aa.var.name);
        } else if (op instanceof ListIndex) {
            ListIndex li = (ListIndex) op;
            Object idx = eval(li.expr, env);
            return getIndex(base, idx);
        }
        return base;
    }
    private Object evalListComprehension(ListComprehension lc, Environment env) {
        List<Object> result = new ArrayList<>();
        Object iterableVal = eval(lc.iterable, env);
        Environment lcEnv = new Environment(env);
        for (Object item : toIterable(iterableVal)) {
            if (lc.variable != null) lcEnv.define(lc.variable.name, item);
            if (lc.condition == null || truthy(eval(lc.condition, lcEnv))) {
                result.add(eval(lc.element, lcEnv));
            }
        }
        return result;
    }
    private static class Builtin {
        final String name;
        Builtin(String name) { this.name = name; }
    }
    private static class BoundMethod {
        final Object receiver;
        final String method;
        BoundMethod(Object receiver, String method) { this.receiver = receiver; this.method = method; }
    }
    private static final Set<String> LIST_METHODS = Set.of(
            "append", "remove", "pop", "insert", "index", "count", "sort", "reverse", "clear", "extend");
    private static final Set<String> DICT_METHODS = Set.of("get", "keys", "values", "items");
    private static final Set<String> STRING_METHODS = Set.of(
            "upper", "lower", "strip", "split", "replace", "startswith", "endswith", "join");
    private static class ArgValue {
        final String name;
        final Object value;
        ArgValue(String name, Object value) { this.name = name; this.value = value; }
    }
    private List<ArgValue> evalArguments(ArgumentList al, Environment env) {
        List<ArgValue> result = new ArrayList<>();
        if (al == null) return result;
        List<Argument> args = new ArrayList<>();
        if (al.elements != null && !al.elements.isEmpty()) args.addAll(al.elements);
        else if (al.argument != null) args.add(al.argument);
        for (Argument a : args) {
            String name = (a.var != null) ? a.var.name : null;
            result.add(new ArgValue(name, eval(a.expr, env)));
        }
        return result;
    }
    private Object callFunction(Object callee, List<ArgValue> args, int line) {
        if (callee instanceof PyFunction) {
            PyFunction fn = (PyFunction) callee;
            Environment callEnv = new Environment(fn.closure);
            bindParameters(fn.definition.parameters, args, callEnv);
            try {
                execStatement(fn.definition.statement, callEnv);
            } catch (ReturnSignal rs) {
                return rs.value;
            }
            return null;
        } else if (callee instanceof Builtin) {
            return callBuiltin(((Builtin) callee).name, args);
        } else if (callee instanceof BoundMethod) {
            return callBoundMethod((BoundMethod) callee, args);
        }
        throw new RuntimeException("Runtime Error: '" + callee + "' is not callable at line " + line);
    }
    private void bindParameters(ParameterList params, List<ArgValue> argValues, Environment callEnv) {
        List<Parameter> plist = (params != null && params.parameters != null)
                ? params.parameters : Collections.emptyList();
        Set<String> boundNames = new HashSet<>();
        for (ArgValue av : argValues) {
            if (av.name != null) {
                callEnv.define(av.name, av.value);
                boundNames.add(av.name);
            }
        }
        int posIndex = 0;
        for (ArgValue av : argValues) {
            if (av.name == null) {
                while (posIndex < plist.size() && boundNames.contains(plist.get(posIndex).variable.name)) posIndex++;
                if (posIndex < plist.size()) {
                    Parameter p = plist.get(posIndex);
                    callEnv.define(p.variable.name, av.value);
                    boundNames.add(p.variable.name);
                    posIndex++;
                }
            }
        }
        for (Parameter p : plist) {
            if (!boundNames.contains(p.variable.name)) {
                Object defVal = (p.expr != null) ? eval(p.expr, callEnv) : null;
                callEnv.define(p.variable.name, defVal);
            }
        }
    }
    private Object callBuiltin(String name, List<ArgValue> args) {
        List<Object> vals = new ArrayList<>();
        for (ArgValue a : args) vals.add(a.value);
        switch (name) {
            case "len":
                return sizeOf(vals.isEmpty() ? null : vals.get(0));
            case "range": {
                int start = 0, stop = 0, step = 1;
                if (vals.size() == 1) { stop = toInt(vals.get(0)); }
                else if (vals.size() == 2) { start = toInt(vals.get(0)); stop = toInt(vals.get(1)); }
                else if (vals.size() >= 3) { start = toInt(vals.get(0)); stop = toInt(vals.get(1)); step = toInt(vals.get(2)); }
                List<Object> range = new ArrayList<>();
                if (step > 0) for (int i = start; i < stop; i += step) range.add(i);
                else if (step < 0) for (int i = start; i > stop; i += step) range.add(i);
                return range;
            }
            case "str":
                return vals.isEmpty() ? "" : toDisplayString(vals.get(0));
            case "int":
                return vals.isEmpty() ? 0 : toInt(vals.get(0));
            case "float":
                return vals.isEmpty() ? 0.0 : toDouble(vals.get(0));
            case "abs":
                return vals.isEmpty() ? 0 : Math.abs(toDouble(vals.get(0)));
            case "print": {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < vals.size(); i++) {
                    if (i > 0) line.append(" ");
                    line.append(toDisplayString(vals.get(i)));
                }
                capturedOutput.append(line).append("\n");
                return null;
            }
            default:
                return null;
        }
    }
    @SuppressWarnings("unchecked")
    private Object getAttribute(Object base, String name) {
        if (base instanceof Map) {
            Map<Object, Object> map = (Map<Object, Object>) base;
            if (map.containsKey(name)) return map.get(name); // حقل بيانات فعلي (زي product.name)
            if (DICT_METHODS.contains(name)) return new BoundMethod(base, name);
            return null;
        }
        if (base instanceof List && LIST_METHODS.contains(name)) return new BoundMethod(base, name);
        if (base instanceof String && STRING_METHODS.contains(name)) return new BoundMethod(base, name);
        return null;
    }
    @SuppressWarnings("unchecked")
    private Object callBoundMethod(BoundMethod bm, List<ArgValue> args) {
        List<Object> vals = new ArrayList<>();
        for (ArgValue a : args) vals.add(a.value);
        Object recv = bm.receiver;
        if (recv instanceof List) {
            List<Object> list = (List<Object>) recv;
            switch (bm.method) {
                case "append": list.add(vals.isEmpty() ? null : vals.get(0)); return null;
                case "extend": for (Object o : toIterable(vals.isEmpty() ? null : vals.get(0))) list.add(o); return null;
                case "remove": if (!vals.isEmpty()) list.remove(vals.get(0)); return null;
                case "pop": return list.isEmpty() ? null : list.remove(vals.isEmpty() ? list.size() - 1 : toInt(vals.get(0)));
                case "insert": if (vals.size() >= 2) list.add(toInt(vals.get(0)), vals.get(1)); return null;
                case "index": return vals.isEmpty() ? -1 : list.indexOf(vals.get(0));
                case "count": { int c = 0; for (Object o : list) if (Objects.equals(o, vals.isEmpty() ? null : vals.get(0))) c++; return c; }
                case "sort": list.sort((a, b) -> Double.compare(toDouble(a), toDouble(b))); return null;
                case "reverse": Collections.reverse(list); return null;
                case "clear": list.clear(); return null;
            }
        } else if (recv instanceof Map) {
            Map<Object, Object> map = (Map<Object, Object>) recv;
            switch (bm.method) {
                case "get": return (!vals.isEmpty() && map.containsKey(vals.get(0))) ? map.get(vals.get(0))
                        : (vals.size() > 1 ? vals.get(1) : null);
                case "keys": return new ArrayList<>(map.keySet());
                case "values": return new ArrayList<>(map.values());
                case "items": { List<Object> items = new ArrayList<>(map.entrySet()); return items; }
            }
        } else if (recv instanceof String) {
            String s = (String) recv;
            switch (bm.method) {
                case "upper": return s.toUpperCase();
                case "lower": return s.toLowerCase();
                case "strip": return s.trim();
                case "split": return Arrays.asList(s.split(vals.isEmpty() ? " " : toDisplayString(vals.get(0))));
                case "replace": return (vals.size() >= 2) ? s.replace(toDisplayString(vals.get(0)), toDisplayString(vals.get(1))) : s;
                case "startswith": return !vals.isEmpty() && s.startsWith(toDisplayString(vals.get(0)));
                case "endswith": return !vals.isEmpty() && s.endsWith(toDisplayString(vals.get(0)));
                case "join": {
                    StringBuilder sb = new StringBuilder();
                    boolean first = true;
                    for (Object o : toIterable(vals.isEmpty() ? null : vals.get(0))) {
                        if (!first) sb.append(s);
                        first = false;
                        sb.append(toDisplayString(o));
                    }
                    return sb.toString();
                }
            }
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    private Object getIndex(Object base, Object idx) {
        if (base instanceof List) {
            List<Object> list = (List<Object>) base;
            int i = toInt(idx);
            if (i < 0) i += list.size();
            return (i >= 0 && i < list.size()) ? list.get(i) : null;
        } else if (base instanceof Map) {
            return ((Map<Object, Object>) base).get(idx);
        } else if (base instanceof String) {
            String s = (String) base;
            int i = toInt(idx);
            if (i < 0) i += s.length();
            return (i >= 0 && i < s.length()) ? String.valueOf(s.charAt(i)) : null;
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    private Iterable<Object> toIterable(Object val) {
        if (val instanceof List) return (List<Object>) val;
        if (val instanceof Set) return (Set<Object>) val;
        if (val instanceof Map) return new ArrayList<>(((Map<Object, Object>) val).keySet());
        if (val instanceof String) {
            List<Object> chars = new ArrayList<>();
            for (char c : ((String) val).toCharArray()) chars.add(String.valueOf(c));
            return chars;
        }
        return Collections.emptyList();
    }
    private Object evalPlusMinus(Object left, String op, Object right) {
        if ("+".equals(op) && (left instanceof String || right instanceof String)) {
            return toDisplayString(left) + toDisplayString(right);
        }
        if ("+".equals(op) && left instanceof List && right instanceof List) {
            List<Object> result = new ArrayList<>((List<Object>) left);
            result.addAll((List<Object>) right);
            return result;
        }
        double l = toDouble(left), r = toDouble(right);
        double result = "+".equals(op) ? l + r : l - r;
        return normalizeNumber(left, right, result);
    }
    private Object evalMulDiv(Object left, String op, Object right, int line) {
        double l = toDouble(left), r = toDouble(right);
        switch (op) {
            case "*":
                if (left instanceof String) return ((String) left).repeat(Math.max(0, (int) r));
                return normalizeNumber(left, right, l * r);
            case "/":
                if (r == 0) throw new RuntimeException("Runtime Error: Division by zero at line " + line);
                return l / r;
            case "%":
                if (r == 0) throw new RuntimeException("Runtime Error: Modulo by zero at line " + line);
                return normalizeNumber(left, right, l % r);
            default:
                return null;
        }
    }
    private Object evalUnary(String op, Object value) {
        if ("-".equals(op)) {
            double d = toDouble(value);
            return (value instanceof Integer) ? (Object) (int) (-d) : (Object) (-d);
        } else if ("+".equals(op)) {
            return value;
        } else if ("not".equalsIgnoreCase(op)) {
            return !truthy(value);
        }
        return value;
    }
    @SuppressWarnings("unchecked")
    private boolean evalComparison(Object left, String op, Object right) {
        switch (op) {
            case "==": return Objects.equals(left, right);
            case "!=": return !Objects.equals(left, right);
            case "in":
                if (right instanceof Collection) return ((Collection<Object>) right).contains(left);
                if (right instanceof Map) return ((Map<Object, Object>) right).containsKey(left);
                if (right instanceof String) return ((String) right).contains(toDisplayString(left));
                return false;
            default:
                double l = toDouble(left), r = toDouble(right);
                switch (op) {
                    case ">": return l > r;
                    case "<": return l < r;
                    case ">=": return l >= r;
                    case "<=": return l <= r;
                    default: return false;
                }
        }
    }

    private Object normalizeNumber(Object left, Object right, double result) {
        boolean bothInts = (left instanceof Integer || left == null) && (right instanceof Integer || right == null);
        if (left instanceof Integer && right instanceof Integer) {
            return (int) result;
        }
        return result;
    }
    private boolean truthy(Object v) {
        if (v == null) return false;
        if (v instanceof Boolean) return (Boolean) v;
        if (v instanceof Integer) return (Integer) v != 0;
        if (v instanceof Double) return (Double) v != 0.0;
        if (v instanceof String) return !((String) v).isEmpty();
        if (v instanceof Collection) return !((Collection<?>) v).isEmpty();
        if (v instanceof Map) return !((Map<?, ?>) v).isEmpty();
        return true;
    }
    private int toInt(Object v) {
        if (v instanceof Integer) return (Integer) v;
        if (v instanceof Number) return ((Number) v).intValue();
        if (v instanceof String) return Integer.parseInt(((String) v).trim());
        return 0;
    }
    private String stripPythonStringQuotes(String raw) {
        if (raw == null) return null;
        String s = raw;
        while (s.length() >= 2
                && ((s.charAt(0) == '"' && s.charAt(s.length() - 1) == '"')
                || (s.charAt(0) == '\'' && s.charAt(s.length() - 1) == '\''))) {
            s = s.substring(1, s.length() - 1);
        }
        return s.replace("\\n", "\n").replace("\\t", "\t")
                .replace("\\\"", "\"").replace("\\'", "'").replace("\\\\", "\\");
    }
    private double toDouble(Object v) {
        if (v instanceof Number) return ((Number) v).doubleValue();
        if (v instanceof String) return Double.parseDouble(((String) v).trim());
        if (v instanceof Boolean) return ((Boolean) v) ? 1.0 : 0.0;
        return 0.0;
    }
    private int sizeOf(Object v) {
        if (v instanceof Collection) return ((Collection<?>) v).size();
        if (v instanceof Map) return ((Map<?, ?>) v).size();
        if (v instanceof String) return ((String) v).length();
        return 0;
    }
    private String toDisplayString(Object v) {
        if (v == null) return "None";
        if (v instanceof Boolean) return ((Boolean) v) ? "True" : "False";
        if (v instanceof Double) {
            double d = (Double) v;
            if (d == Math.floor(d) && !Double.isInfinite(d)) return String.valueOf((long) d) + ".0";
            return String.valueOf(d);
        }
        return v.toString();
    }
    public String printGeneratedData(Environment global) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ===== Generated Python Data (Code Generation Output) =====\n");
        for (Map.Entry<String, Object> e : global.getValues().entrySet()) {
            if (e.getValue() instanceof PyFunction) continue; // ما منطبع تعريف الدوال بمرحلة البيانات
            sb.append(e.getKey()).append(" = ").append(toPyLiteral(e.getValue())).append("\n");
        }
        if (capturedOutput.length() > 0) {
            sb.append("\n# ---- Captured print() output ----\n");
            sb.append(capturedOutput);
        }
        return sb.toString();
    }
    @SuppressWarnings("unchecked")
    private String toPyLiteral(Object v) {
        if (v == null) return "None";
        if (v instanceof String) return "\"" + ((String) v).replace("\"", "\\\"") + "\"";
        if (v instanceof Boolean) return ((Boolean) v) ? "True" : "False";
        if (v instanceof Double) return toDisplayString(v);
        if (v instanceof List) {
            StringBuilder sb = new StringBuilder("[");
            List<Object> list = (List<Object>) v;
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(toPyLiteral(list.get(i)));
            }
            return sb.append("]").toString();
        }
        if (v instanceof Map) {
            StringBuilder sb = new StringBuilder("{");
            boolean first = true;
            for (Map.Entry<Object, Object> e : ((Map<Object, Object>) v).entrySet()) {
                if (!first) sb.append(", ");
                first = false;
                sb.append(toPyLiteral(e.getKey())).append(": ").append(toPyLiteral(e.getValue()));
            }
            return sb.append("}").toString();
        }
        if (v instanceof Set) {
            StringBuilder sb = new StringBuilder("{");
            boolean first = true;
            for (Object el : (Set<Object>) v) {
                if (!first) sb.append(", ");
                first = false;
                sb.append(toPyLiteral(el));
            }
            return sb.append("}").toString();
        }
        return v.toString();
    }
}
