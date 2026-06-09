package Semantic.Python;

import AST.Python.*;
import AST.Python.Statement.*;
import AST.Python.Statement.Expr.*;
import AST.Python.Statement.test.*;
import AST.Python.Statement.test.Atom1.*;
import AST.Python.Statement.test.Atom1.Boolean;
import AST.Python.Statement.test.Atom1.ListLiteral;
import AST.Python.Statement.test.Atom1.Number;

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

    private String inferType(PythonNode expr) {
        if (expr instanceof AST.Python.Statement.test.Atom1.Number) return "Integer";
        if (expr instanceof AST.Python.Statement.test.Atom1.StringLiteral) return "String";
        if (expr instanceof AST.Python.Statement.test.Atom1.FloatLiteral) return "Float";

        if (expr instanceof Variable) {
            Symbol sym = currentScope.lookup(((Variable) expr).name);
            return (sym != null) ? sym.type : "Unknown";
        }

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
            currentScope = parentScope;
        }
    }
}