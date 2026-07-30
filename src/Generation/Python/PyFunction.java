package Generation.Python;
import AST.Python.Statement.FuntctionDef;
public class PyFunction {
    public final FuntctionDef definition;
    public final Environment closure;

    public PyFunction(FuntctionDef definition, Environment closure) {
        this.definition = definition;
        this.closure = closure;
    }
    @Override
    public String toString() {
        String name = (definition.variable != null) ? definition.variable.name : "anonymous";
        return "<function " + name + ">";
    }
}
