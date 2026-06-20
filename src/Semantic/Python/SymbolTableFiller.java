package Semantic.Python;

import AST.Python.*;
import AST.Python.Statement.*;
import AST.Python.Statement.Expr.*;
import AST.Python.Statement.Expr.LogicalExpr.*;
import AST.Python.Statement.test.*;
import AST.Python.Statement.test.Atom1.*;


import java.util.ArrayList;
import java.util.List;

public class SymbolTableFiller {
    private SymbolTable currentScope;
    private List<SymbolTable> allScopes;

    public SymbolTableFiller() {
        allScopes = new ArrayList<>();
        currentScope = new SymbolTable("Global Scope", null);
        allScopes.add(currentScope);
    }

    public void fillAndPrint(Program program) {
        if (program == null) return;
        walk(program);
        System.out.println("\n#########################################################");
        System.out.println("           GENERATED PYTHON SYMBOL TABLES               ");
        System.out.println("#########################################################\n");
        for (SymbolTable st : allScopes) {
            st.printTable();
        }
    }

    private PythonNode unwrap(PythonNode expr) {
        if (expr instanceof Test) {
            Test t = (Test) expr;

            if (t.operations == null || t.operations.isEmpty()) {
                return unwrap(t.atom);
            }
            return expr;
        }
        if (expr instanceof Primary) {
            Primary p = (Primary) expr;
            if (p.operations == null || p.operations.isEmpty()) {
                return unwrap(p.atom);
            }
            return expr;
        }
        return expr;
    }

    private String inferType(PythonNode expr) {
        PythonNode unwrapped = unwrap(expr);

        if (unwrapped instanceof AST.Python.Statement.test.Atom1.Number) return "Integer";
        if (unwrapped instanceof AST.Python.Statement.test.Atom1.StringLiteral) return "String";
        if (unwrapped instanceof AST.Python.Statement.test.Atom1.FloatLiteral) return "Float";
        if (unwrapped instanceof AST.Python.Statement.test.Atom1.Boolean) return "Boolean";
        if (unwrapped instanceof AST.Python.Statement.test.Atom1.None) return "None";
        if (unwrapped instanceof AST.Python.Statement.test.Atom1.ListLiteral) return "List";
        if (unwrapped instanceof AST.Python.Statement.test.Atom1.DistLiteral) return "Dict";
        if (unwrapped instanceof AST.Python.Statement.test.Atom1.SetLiteral) return "Set";


        if (unwrapped instanceof PlusMinus) {
            PlusMinus pm = (PlusMinus) unwrapped;
            return inferBinaryNumericType(pm.left, pm.right);
        }
        if (unwrapped instanceof MulDiv) {
            MulDiv md = (MulDiv) unwrapped;
            return inferBinaryNumericType(md.left, md.right);
        }


        if (unwrapped instanceof Comparison || unwrapped instanceof And
                || unwrapped instanceof Or || unwrapped instanceof Not) {
            return "Boolean";
        }

        if (unwrapped instanceof Variable) {
            Symbol sym = currentScope.lookup(((Variable) unwrapped).name);
            if (sym == null) return "Unknown";
            if (sym.type.equals("Parameter") || sym.type.equals("Variable (For Loop)")
                    || sym.type.equals("Local Var") || sym.type.equals("Function")) {
                return "Unknown";
            }
            return sym.type;
        }

        if (unwrapped instanceof FunctionCall) {
            return "Unknown";
        }

        return "Unknown";
    }

    //
    private String inferBinaryNumericType(PythonNode left, PythonNode right) {
        String leftType = inferType(left);
        String rightType = inferType(right);

        if (leftType.equals("Unknown") || rightType.equals("Unknown")) return "Unknown";
        if (leftType.equals("Float") || rightType.equals("Float")) return "Float";
        return "Integer";
    }

    private void walk(PythonNode node) {
        if (node == null) return;

        if (node instanceof Program) {
            Program p = (Program) node;
            if (p.statements != null) for (Statement stmt : p.statements) walk(stmt);
        }
        else if (node instanceof Suite) {
            Suite s = (Suite) node;
            if (s.statements != null) for (Statement stmt : s.statements) walk(stmt);
        }
        else if (node instanceof Assignment) {
            Assignment assign = (Assignment) node;

            if (assign.expr != null) walk(assign.expr);

            String dataType = inferType(assign.expr);

            if (assign.test != null && assign.test.atom instanceof Variable) {
                Variable var = (Variable) assign.test.atom;
                currentScope.define(new Symbol(var.name, dataType, var.line));
            } else {
                walk(assign.test);
            }
        }
        else if (node instanceof FuntctionDef) {
            FuntctionDef func = (FuntctionDef) node;
            if (func.variable != null) {
                currentScope.define(new Symbol(func.variable.name, "Function", func.line));
            }

            String childName = "Function '" + (func.variable != null ? func.variable.name : "unknown") + "'";
            SymbolTable childScope = new SymbolTable(childName, currentScope);
            allScopes.add(childScope);

            SymbolTable parentScope = currentScope;
            currentScope = childScope;

            if (func.parameters != null && func.parameters.parameters != null) {
                for (Parameter param : func.parameters.parameters) {
                    if (param.variable != null) {
                        currentScope.define(new Symbol(param.variable.name, "Parameter", param.line));
                    }
                }
            }
            walk(func.statement);
            currentScope = parentScope;
        }
        else if (node instanceof For) {

            For forStmt = (For) node;
            walk(forStmt.expr);
            if (forStmt.variable != null) {
                currentScope.define(new Symbol(forStmt.variable.name, "Variable (For Loop)", forStmt.line));
            }
            walk(forStmt.statement);
        }
        else if (node instanceof If) {

            If ifStmt = (If) node;
            walk(ifStmt.condition);
            walk(ifStmt.thenBranch);
            if (ifStmt.elifBranch != null) {
                for (ElseIf elif : ifStmt.elifBranch) {
                    walk(elif.expr);
                    walk(elif.statements);
                }
            }
            if (ifStmt.elseBranch != null && ifStmt.elseBranch.statements != null) {
                for (Suite s : ifStmt.elseBranch.statements) walk(s);
            }
        }
        else if (node instanceof While) {
            While whileStmt = (While) node;
            walk(whileStmt.expr);
            walk(whileStmt.statement);
        }
        else if (node instanceof ListComprehension) {
            ListComprehension lc = (ListComprehension) node;
            SymbolTable lcScope = new SymbolTable("List Comprehension", currentScope);
            allScopes.add(lcScope);
            SymbolTable parentScope = currentScope;
            currentScope = lcScope;
            if (lc.variable != null) {
                currentScope.define(new Symbol(lc.variable.name, "Local Var", lc.variable.line));
            }
            walk(lc.iterable);

            walk(lc.element);
            if (lc.condition != null) walk(lc.condition);
            currentScope = parentScope;
        }
    }
}