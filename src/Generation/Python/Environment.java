package Generation.Python;
import java.util.LinkedHashMap;
import java.util.Map;
public class Environment {
    private final Map<String, Object> values = new LinkedHashMap<>();
    private final Environment parent;
    public Environment(Environment parent) {
        this.parent = parent;
    }
    public void define(String name, Object value) {
        values.put(name, value);
    }
    public Object get(String name) {
        Environment env = resolveEnv(name);
        return env != null ? env.values.get(name) : null;
    }
    public boolean isDefined(String name) {
        return resolveEnv(name) != null;
    }
    private Environment resolveEnv(String name) {
        if (values.containsKey(name)) return this;
        if (parent != null) return parent.resolveEnv(name);
        return null;
    }
    public Map<String, Object> getValues() {
        return values;
    }
    public Environment getParent() {
        return parent;
    }
}
