package Semantic.htmlCssJInja;

import AST.html_css_jinja.*;
import AST.html_css_jinja.html.*;
import AST.html_css_jinja.jinja.*;
import AST.html_css_jinja.css.*;
import AST.html_css_jinja.Expression.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Walks the ready AST tree (after the base Visitor has built it)
 * and builds the Symbol Table: variables, for-loop variables, functions (FunctionCall), filters (Filter).
 * Respects scoping: every ForStatement opens a new scope for its loop variables,
 * and closes that scope when exiting the loop body.
 * Also performs semantic checks and reports errors via ErrorReporter.
 */
public class SymbolTableBuilder {

    public SymbolTable table;
    public List<Scope> allScopes; // tracks all branched scopes in creation order (useful for full printing)
    private int forCounter = 0;   // counter to generate clear names for each for-scope (For#1, For#2 ...)

    public ErrorReporter reporter = new ErrorReporter();

    // names of for-loop variables whose loop has already closed (for Undefined Variable check)
    private Set<String> closedLoopVarNames = new HashSet<>();

    // names of for-loop variables currently open (stack) - for Scope Error (shadowing) check
    private Deque<String> activeForVarNames = new ArrayDeque<>();

    public SymbolTableBuilder() {
        this.table = new SymbolTable();
        this.allScopes = new ArrayList<>();
        this.allScopes.add(table.globalScope);
    }

    // main entry point: call with the root of the tree (Program)
    public void build(Program program) {
        if (program.statements == null) return;
        for (Node node : program.statements) {
            visit(node);
        }
    }

    // general dispatch by node type (manual polymorphism since the AST has no built-in accept/visitor pattern)
    private void visit(Node node) {
        if (node == null) return;

        if (node instanceof ifStatement) {
            visitIfStatement((ifStatement) node);
        } else if (node instanceof ForStatement) {
            visitForStatement((ForStatement) node);
        } else if (node instanceof HtmlElementNode) {
            visitHtmlElementNode((HtmlElementNode) node);
        } else if (node instanceof HtmlAttributeNode) {
            visitHtmlAttributeNode((HtmlAttributeNode) node);
        } else if (node instanceof JinjaExpression) {
            visitExpression(((JinjaExpression) node).expression);
        } else if (node instanceof StyleBlock) {
            visitStyleBlock((StyleBlock) node);
        } else if (node instanceof ExpressionNode) {
            visitExpression((ExpressionNode) node);
        }
    }

    private void visitIfStatement(ifStatement node) {
        // the condition itself uses variables (resolve), does not create a new scope
        visitExpression(node.condition);

        if (node.thenBranch != null) {
            for (ContentNode n : node.thenBranch) visit(n);
        }
        if (node.elifBranch != null) {
            for (ElifBranch elif : node.elifBranch) {
                visitExpression(elif.expr);
                if (elif.statements != null) {
                    for (ContentNode n : elif.statements) visit(n);
                }
            }
        }
        if (node.elseBranch != null && node.elseBranch.statements != null) {
            for (ContentNode n : node.elseBranch.statements) visit(n);
        }
    }

    private void visitForStatement(ForStatement node) {
        forCounter++;
        String scopeName = "For#" + forCounter + " (line " + node.line + ")";

        // 1. resolve the iterable from the current scope (it's defined before the loop, not inside it)
        //    + Type Error check
        if (node.control != null) {
            visitExpression(node.control.iterable);
            checkIterableTypeError(node.control.iterable);
            inferIterableType(node.control.iterable);
        }

        // 2. open a new scope for the for-loop variables
        Scope forScope = table.enterScope(scopeName);
        allScopes.add(forScope);

        List<String> namesDeclaredHere = new ArrayList<>();

        // 3. declare loop variables as FOR_LOOP_VAR in this new scope
        //    + Duplicate Definition and Scope Error checks
        if (node.control != null && node.control.iterables != null) {
            for (ExpressionNode var : node.control.iterables) {
                if (var instanceof Identifier) {
                    String varName = ((Identifier) var).text;

                    if (forScope.resolveLocal(varName) != null) {
                        // Duplicate Definition: same name repeated in the same for-loop
                        reporter.report(SemanticErrorType.DUPLICATE_DEFINITION,
                                "Loop variable '" + varName + "' is defined more than once in the same for-loop",
                                node.line);
                    } else {
                        // Scope Error: shadowing an outer for-loop variable that is still open
                        if (activeForVarNames.contains(varName)) {
                            reporter.report(SemanticErrorType.SCOPE_ERROR,
                                    "Loop variable '" + varName + "' shadows an outer for-loop variable with the same name",
                                    node.line);
                        }

                        Symbol sym = new Symbol(varName, SymbolKind.FOR_LOOP_VAR,
                                DataType.UNKNOWN, forScope, node.line);
                        table.declare(sym);
                        namesDeclaredHere.add(varName);
                        activeForVarNames.push(varName);
                    }
                }
            }
        }

        // 4. visit the loop body while still inside the new scope
        if (node.body != null) {
            for (ContentNode n : node.body) visit(n);
        }

        // 5. mark this scope's loop variable names as "closed" (for later Undefined Variable checks)
        for (Symbol s : forScope.symbols.values()) {
            if (s.kind == SymbolKind.FOR_LOOP_VAR) {
                closedLoopVarNames.add(s.name);
            }
        }

        // 6. remove the names opened by this for-loop from the active stack
        for (String n : namesDeclaredHere) {
            activeForVarNames.remove(n);
        }

        // 7. exit the scope (return to the parent scope)
        table.exitScope();
    }

    // ===================== HTML =====================

    private void visitHtmlElementNode(HtmlElementNode node) {
        if (node.attributes != null) {
            for (HtmlAttributeNode attr : node.attributes) visitHtmlAttributeNode(attr);
        }
        if (node.children != null) {
            for (ContentNode child : node.children) visit(child);
        }
    }

    private void visitHtmlAttributeNode(HtmlAttributeNode node) {
        if (node.value instanceof ExpressionAttribute) {
            visitExpression(((ExpressionAttribute) node.value).expression);
        }
        // StringAttribute: fixed text, no variables
    }

    // ===================== CSS =====================

    private void visitStyleBlock(StyleBlock node) {
        if (node.rules == null) return;
        for (CssRule rule : node.rules) {
            if (rule.declarations == null) continue;
            for (CssDeclaration decl : rule.declarations) {
                if (decl.values == null) continue;
                for (CssValueNode val : decl.values) {
                    if (val instanceof CssExpression) {
                        visitExpression(((CssExpression) val).expression);
                    }
                }
            }
        }
    }

    // ===================== Expressions =====================

    private void visitExpression(ExpressionNode expr) {
        if (expr == null) return;

        if (expr instanceof Identifier) {
            visitIdentifier((Identifier) expr);

        } else if (expr instanceof BinaryNode) {
            BinaryNode b = (BinaryNode) expr;
            visitExpression(b.left);
            visitExpression(b.right);
            checkBinaryOp(b);

        } else if (expr instanceof Ternary) {
            Ternary t = (Ternary) expr;
            visitExpression(t.condition);
            visitExpression(t.trueExp);
            visitExpression(t.falseExp);

        } else if (expr instanceof Member) {
            Member m = (Member) expr;
            visitExpression(m.object);
            checkMemberTypeError(m.object);
            // type inference: any variable used in member access (e.g. product.name) is likely DICT
            inferMemberObjectType(m.object);
            // m.member is a property name, not an independent variable, so we don't declare it in the table

        } else if (expr instanceof IndexAccess) {
            IndexAccess ia = (IndexAccess) expr;
            visitExpression(ia.target);
            visitExpression(ia.index);
            checkIndexTypeError(ia.target);

        } else if (expr instanceof FunctionCall) {
            visitFunctionCall((FunctionCall) expr);

        } else if (expr instanceof Filter) {
            visitFilter((Filter) expr);

        }
        // NumberLiteral, StringNode: constant literals with 100% known type (NUMBER/STRING respectively),
        // but they aren't registered as symbols in the table since they're not reusable variables,
        // so no type inference is needed here.
    }

    private void visitIdentifier(Identifier id) {
        // if already registered (in this scope or a parent), don't redeclare it, this is just a usage
        Symbol existing = table.resolve(id.text);
        if (existing == null) {
            if (closedLoopVarNames.contains(id.text)) {
                // Undefined Variable: this was a for-loop variable whose loop has already closed
                reporter.report(SemanticErrorType.UNDEFINED_VARIABLE,
                        "Variable '" + id.text + "' is used outside the scope of the for-loop it was defined in",
                        id.line);
            }
            // unknown variable => most likely coming from Flask (external context) => UNKNOWN
            Symbol sym = new Symbol(id.text, SymbolKind.VARIABLE, DataType.UNKNOWN,
                    table.getCurrentScope(), id.line);
            table.declare(sym);
        } else {
            // symbol already exists => this is a new usage of it (not a definition), record the line
            existing.addUsage(id.line);
        }
    }

    private void visitFunctionCall(FunctionCall call) {
        // the function's own name
        if (call.function instanceof Identifier) {
            String funcName = ((Identifier) call.function).text;
            Symbol existing = table.resolve(funcName);
            if (existing == null) {
                Symbol sym = new Symbol(funcName, SymbolKind.FUNCTION, DataType.UNKNOWN,
                        table.getCurrentScope(), call.line);
                table.declare(sym);
            } else {
                existing.addUsage(call.line);
            }
        } else {
            visitExpression(call.function);
        }
        // variables used as call arguments
        if (call.arguments != null) {
            for (ExpressionNode arg : call.arguments) visitExpression(arg);
        }
    }

    private void visitFilter(Filter filter) {
        // the filter's input variable (before |)
        visitExpression(filter.input);

        // type inference: if the filter is a known numeric filter, the input is likely NUMBER
        inferFilterInputType(filter.input, filter.filterName);

        // the filter's own name
        Symbol existing = table.resolve(filter.filterName);
        if (existing == null) {
            Symbol sym = new Symbol(filter.filterName, SymbolKind.FILTER, DataType.UNKNOWN,
                    table.getCurrentScope(), filter.line);
            table.declare(sym);
        } else {
            existing.addUsage(filter.line);
        }

        // filter argument variables (e.g. |round(2))
        if (filter.arguments != null) {
            for (ExpressionNode arg : filter.arguments) visitExpression(arg);
        }
    }

    private static final List<String> NUMERIC_FILTERS = List.of("round", "abs", "int", "float");

    // if a variable is used as an iterable in a for-loop, infer it's a LIST (unless its type is already known precisely)
    private void inferIterableType(ExpressionNode iterable) {
        if (iterable instanceof Identifier) {
            Symbol sym = table.resolve(((Identifier) iterable).text);
            if (sym != null && sym.dataType == DataType.UNKNOWN) {
                sym.dataType = DataType.LIST;
            }
        }
    }

    // if a variable is used as an object in member access (product.name), infer it's a DICT
    private void inferMemberObjectType(ExpressionNode object) {
        if (object instanceof Identifier) {
            Symbol sym = table.resolve(((Identifier) object).text);
            if (sym != null && sym.dataType == DataType.UNKNOWN) {
                sym.dataType = DataType.DICT;
            }
        }
    }

    // if a variable is passed to a known numeric filter (round, abs...), infer it's a NUMBER
    private void inferFilterInputType(ExpressionNode input, String filterName) {
        if (input instanceof Identifier && NUMERIC_FILTERS.contains(filterName)) {
            Symbol sym = table.resolve(((Identifier) input).text);
            if (sym != null && sym.dataType == DataType.UNKNOWN) {
                sym.dataType = DataType.NUMBER;
            }
        }
    }

    // ===================== Semantic Checks: Type Mismatch / Division By Zero =====================

    private static final List<String> ARITHMETIC_OPS = List.of("+", "-", "*", "/", "%");
    private static final List<String> COMPARISON_OPS = List.of(">", "<", ">=", "<=");
    private static final List<String> EQUALITY_OPS   = List.of("==", "!=");

    private DataType getExpressionType(ExpressionNode expr) {
        if (expr instanceof NumberLiteral) return DataType.NUMBER;
        if (expr instanceof StringNode) return DataType.STRING;
        if (expr instanceof Identifier) {
            Symbol sym = table.resolve(((Identifier) expr).text);
            return sym != null ? sym.dataType : DataType.UNKNOWN;
        }
        if (expr instanceof BinaryNode) {
            String op = ((BinaryNode) expr).op;
            if (COMPARISON_OPS.contains(op) || EQUALITY_OPS.contains(op)) return DataType.BOOLEAN;
            if (ARITHMETIC_OPS.contains(op)) return DataType.NUMBER;
        }
        return DataType.UNKNOWN; // Member, IndexAccess, FunctionCall, Filter, Ternary
    }

    private void checkBinaryOp(BinaryNode b) {
        // Division / Modulo by Zero
        if ((b.op.equals("/") || b.op.equals("%"))
                && b.right instanceof NumberLiteral
                && ((NumberLiteral) b.right).text == 0) {
            reporter.report(SemanticErrorType.DIVISION_BY_ZERO,
                    "Division by zero", b.line);
            return; // no need to check type mismatch as well
        }

        DataType leftType = getExpressionType(b.left);
        DataType rightType = getExpressionType(b.right);

        if (leftType == DataType.UNKNOWN || rightType == DataType.UNKNOWN) return;

        boolean mismatch = false;
        if (ARITHMETIC_OPS.contains(b.op) || COMPARISON_OPS.contains(b.op)) {
            mismatch = (leftType != DataType.NUMBER || rightType != DataType.NUMBER);
        } else if (EQUALITY_OPS.contains(b.op)) {
            mismatch = (leftType != rightType);
        }

        if (mismatch) {
            reporter.report(SemanticErrorType.TYPE_MISMATCH,
                    "Operator '" + b.op + "' is not compatible between type " + leftType + " and type " + rightType,
                    b.line);
        }
    }

    // ===================== Semantic Checks: Type Error =====================

    private void checkIterableTypeError(ExpressionNode iterable) {
        if (iterable instanceof Identifier) {
            Symbol sym = table.resolve(((Identifier) iterable).text);
            if (sym != null && sym.dataType != DataType.UNKNOWN && sym.dataType != DataType.LIST) {
                reporter.report(SemanticErrorType.TYPE_ERROR,
                        "Variable '" + sym.name + "' has type " + sym.dataType + " and cannot be used as an iterable in a for-loop",
                        iterable.line);
            }
        }
    }

    private void checkMemberTypeError(ExpressionNode object) {
        if (object instanceof Identifier) {
            Symbol sym = table.resolve(((Identifier) object).text);
            if (sym != null && sym.dataType != DataType.UNKNOWN && sym.dataType != DataType.DICT) {
                reporter.report(SemanticErrorType.TYPE_ERROR,
                        "Variable '" + sym.name + "' has type " + sym.dataType + " and its properties cannot be accessed (member access)",
                        object.line);
            }
        }
    }

    private void checkIndexTypeError(ExpressionNode target) {
        if (target instanceof Identifier) {
            Symbol sym = table.resolve(((Identifier) target).text);
            if (sym != null && sym.dataType != DataType.UNKNOWN
                    && sym.dataType != DataType.LIST && sym.dataType != DataType.DICT) {
                reporter.report(SemanticErrorType.TYPE_ERROR,
                        "Variable '" + sym.name + "' has type " + sym.dataType + " and does not support index access",
                        target.line);
            }
        }
    }

    // ===================== Semantic Checks: Missing Flask Variable =====================

    // call this after build() has fully completed
    public void checkMissingFlaskVariables() {
        for (Symbol s : table.globalScope.symbols.values()) {
            // إذا كان المتغير من نوع UNKNOWN، فهذا يعني أننا لم نحدد نوعه (أي أنه لم يُسجل عبر Flask)
            // إذا كان معروف النوع (LIST/DICT/etc)، فهذا يعني أننا نعرفه مسبقاً ولا نحتاج للتبليغ عنه
            if (s.kind == SymbolKind.VARIABLE && s.dataType == DataType.UNKNOWN) {
                reporter.report(SemanticErrorType.MISSING_FLASK_VARIABLE,
                        "Variable '" + s.name + "' is not defined inside the template; it must be passed from Flask via render_template",
                        s.line);
            }
        }
    }

    public void registerFlaskVariable(String varName, DataType type) {
        Symbol sym = new Symbol(varName, SymbolKind.VARIABLE, type, table.globalScope, 0);
        table.globalScope.symbols.put(varName, sym);
    }


    //  Printing

    public String printTable() {
        return table.printTable(allScopes);
    }
}