package Visitor.Python;

import java.util.List;
import java.util.ArrayList;

import AST.Python.PythonNode;
import AST.Python.Program;
import AST.Python.Statement.Expr.LogicalExpr.*;
import AST.Python.Statement.test.Atom1.Boolean;
import AST.Python.Statement.test.Atom1.*;
import AST.Python.Statement.test.Atom1.Number;
import AST.Python.Statement.*;
import AST.Python.Statement.Expr.*;
import AST.Python.Statement.test.*;

import antlr.pythonParser;
import antlr.pythonParserBaseVisitor;

//import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
//import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;


public class PythonVisitor extends pythonParserBaseVisitor<PythonNode> {


    @Override
    public PythonNode visitProgramRule(pythonParser.ProgramRuleContext ctx) {
        List<Statement> statements = new ArrayList<>();
        for (pythonParser.StatementContext stmtCtx : ctx.statement()) {
            Statement stmt = (Statement) visit(stmtCtx);
            if (stmt != null) statements.add(stmt);
        }
        return new Program(ctx.getStart().getLine(), statements);
    }

    @Override
    public PythonNode visitSuiteBlockRule(pythonParser.SuiteBlockRuleContext ctx) {

        List<Statement> statements = new ArrayList<>();

        for (pythonParser.StatementContext stmtCtx : ctx.statement()) {

            Statement stmt = (Statement) visit(stmtCtx);

            if (stmt != null) {
                statements.add(stmt);
            }
        }

        return new Suite(
                ctx.getStart().getLine(),
                statements
        );
    }


    @Override
    public PythonNode visitAssignStmtRule(pythonParser.AssignStmtRuleContext ctx) {

        Primary leftSide = (Primary) visit(ctx.test());

        Expr rightSide = (Expr) visit(ctx.expr());

        return new Assignment(
                rightSide,
                leftSide,
                ctx.getStart().getLine()
        );
    }

    @Override
    public PythonNode visitReturnStmtRule(pythonParser.ReturnStmtRuleContext ctx) {

        Expr expr = null;

        if (ctx.expr() != null) {
            expr = (Expr) visit(ctx.expr());
        }

        return new Return(
                expr,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitExprStmtRule(pythonParser.ExprStmtRuleContext ctx) {

        return visit(ctx.expr());
    }

    @Override
    public PythonNode visitPrintStmtRule(pythonParser.PrintStmtRuleContext ctx) {

        ArgumentList args = null;

        if (ctx.arg_list() != null) {
            args = (ArgumentList) visit(ctx.arg_list());
        }

        return new Print(
                args,
                ctx.getStart().getLine()
        );
    }

    @Override
    public PythonNode visitWhileStmtRule(pythonParser.WhileStmtRuleContext ctx) {

        Expr condition = (Expr) visit(ctx.expr());

        Suite body = (Suite) visit(ctx.suite());

        return new While(
                condition,
                body,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitForStmtRule(pythonParser.ForStmtRuleContext ctx) {

        Variable variable = new Variable(
                ctx.VARIABLE().getText(),
                ctx.getStart().getLine()
        );

        Expr iterable = (Expr) visit(ctx.expr());

        Suite body = (Suite) visit(ctx.suite());

        return new For(
                iterable,
                variable,
                body,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitWithStmtRule(pythonParser.WithStmtRuleContext ctx) {

        Expr expr = (Expr) visit(ctx.expr());

        Variable variable = null;

        if (ctx.VARIABLE() != null) {
            variable = new Variable(
                    ctx.VARIABLE().getText(),
                    ctx.getStart().getLine()
            );
        }

        Suite suite = (Suite) visit(ctx.suite());

        return new With(
                expr,
                variable,
                suite,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitImportStmtRule(pythonParser.ImportStmtRuleContext ctx) {

        Path fromPath = null;

        List<Path> imports = new ArrayList<>();

        if (ctx.path().size() > 0) {

            int startIndex = 0;

            if (ctx.FROM() != null) {
                fromPath = (Path) visit(ctx.path(0));
                startIndex = 1;
            }

            for (int i = startIndex; i < ctx.path().size(); i++) {
                imports.add((Path) visit(ctx.path(i)));
            }
        }

        return new Import(
                fromPath,
                imports,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitArgListRule(pythonParser.ArgListRuleContext ctx) {

        List<Argument> arguments = new ArrayList<>();

        for (pythonParser.ArgumentContext argCtx : ctx.argument()) {

            arguments.add((Argument) visit(argCtx));
        }

        Argument firstArgument = null;

        if (!arguments.isEmpty()) {
            firstArgument = arguments.get(0);
            arguments.remove(0);
        }

        return new ArgumentList(
                ctx.getStart().getLine(),
                arguments,
                firstArgument
        );
    }


    @Override
    public PythonNode visitArgumentRule(pythonParser.ArgumentRuleContext ctx) {

        Variable variable = null;

        if (ctx.VARIABLE() != null) {

            variable = new Variable(
                    ctx.VARIABLE().getText(),
                    ctx.getStart().getLine()
            );
        }

        Expr expr = (Expr) visit(ctx.expr());

        return new Argument(
                expr,
                variable,
                ctx.getStart().getLine()
        );
    }

    @Override
    public PythonNode visitVariableAtomRule(
            pythonParser.VariableAtomRuleContext ctx) {

        return new Variable(
                ctx.VARIABLE().getText(),
                ctx.getStart().getLine()
        );
    }

    @Override
    public PythonNode visitNumberAtomRule(
            pythonParser.NumberAtomRuleContext ctx) {

        return new Number(
                Integer.parseInt(ctx.NUMBER().getText()),
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitFLOATAtomRule(
            pythonParser.FLOATAtomRuleContext ctx) {

        return new FloatLiteral(
                Float.parseFloat(ctx.FLOAT().getText()),
                ctx.getStart().getLine()
        );
    }

    @Override
    public PythonNode visitStringAtomRule(
            pythonParser.StringAtomRuleContext ctx) {

        String text = ctx.STRING().getText();

        return new StringLiteral(
                text,
                ctx.getStart().getLine()
        );
    }

    @Override
    public PythonNode visitNoneAtomRule(
            pythonParser.NoneAtomRuleContext ctx) {

        return new None(
                ctx.getStart().getLine()
        );
    }

    @Override
    public PythonNode visitTrueAtomRule(
            pythonParser.TrueAtomRuleContext ctx) {

        return new Boolean(
                true,
                ctx.getStart().getLine()
        );
    }

    @Override
    public PythonNode visitFalseAtomRule(
            pythonParser.FalseAtomRuleContext ctx) {

        return new Boolean(
                false,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitArithmeticRule(
            pythonParser.ArithmeticRuleContext ctx) {

        // أول term
        Logical left = (Logical) visit(ctx.term(0));

        // منلف على باقي العمليات
        for (int i = 1; i < ctx.term().size(); i++) {

            // operator الحالي (+ أو -)
            String op = ctx.getChild(2 * i - 1).getText();

            // الطرف اليمين
            Logical right = (Logical) visit(ctx.term(i));

            // نبني node جديدة
            left = new PlusMinus(
                    left,
                    op,
                    right,
                    ctx.getStart().getLine()
            );
        }

        return left;
    }

    @Override
    public PythonNode visitTermRule(
            pythonParser.TermRuleContext ctx) {

        // أول factor
        Logical left = (Logical) visit(ctx.factor(0));

        // نلف على باقي العمليات
        for (int i = 1; i < ctx.factor().size(); i++) {

            // operator الحالي (* أو /)
            String op = ctx.getChild(2 * i - 1).getText();

            // الطرف اليمين
            Logical right = (Logical) visit(ctx.factor(i));

            // نبني AST Node
            left = new MulDiv(
                    left,
                    op,
                    right,
                    ctx.getStart().getLine()
            );
        }

        return left;
    }


    @Override
    public PythonNode visitComparisonRule(
            pythonParser.ComparisonRuleContext ctx) {

        // أول arithmetic expression
        Logical left = (Logical) visit(ctx.arithmeticExpr(0));

        // إذا ما في comparison operator
        // مثل:
        // a + b
        if (ctx.arithmeticExpr().size() == 1) {
            return left;
        }

        // نبني comparisons
        for (int i = 1; i < ctx.arithmeticExpr().size(); i++) {

            // operator الحالي
            String op = ctx.getChild(2 * i - 1).getText();

            // الطرف اليمين
            Logical right =
                    (Logical) visit(ctx.arithmeticExpr(i));

            // بناء comparison node
            left = new Comparison(
                    left,
                    op,
                    right,
                    ctx.getStart().getLine()
            );
        }

        return left;
    }

    @Override
    public PythonNode visitAndTestRule(
            pythonParser.AndTestRuleContext ctx) {

        // أول not_test
        Logical left = (Logical) visit(ctx.not_test(0));

        // إذا ما في AND
        if (ctx.not_test().size() == 1) {
            return left;
        }

        // نبني سلسلة AND
        for (int i = 1; i < ctx.not_test().size(); i++) {

            // الطرف اليمين
            Logical right =
                    (Logical) visit(ctx.not_test(i));

            // نبني And node
            left = new And(
                    left,
                    right,
                    ctx.getStart().getLine()
            );
        }

        return left;
    }

    @Override
    public PythonNode visitOrTestRule(
            pythonParser.OrTestRuleContext ctx) {

        // أول and_test
        Logical left = (Logical) visit(ctx.and_test(0));

        // إذا ما في OR
        if (ctx.and_test().size() == 1) {
            return left;
        }

        // نبني سلسلة OR
        for (int i = 1; i < ctx.and_test().size(); i++) {

            // الطرف اليمين
            Logical right =
                    (Logical) visit(ctx.and_test(i));

            // بناء OR node
            left = new Or(
                    left,
                    right,
                    ctx.getStart().getLine()
            );
        }

        return left;
    }


    @Override
    public PythonNode visitNotExprRule(
            pythonParser.NotExprRuleContext ctx) {

        Logical operand = (Logical) visit(ctx.not_test());

        return new Not(
                operand,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitUnaryExprRule(
            pythonParser.UnaryExprRuleContext ctx) {

        // operator الحالي (+ أو -)
        String op = ctx.getChild(0).getText();

        // نزور العامل الداخلي recursively
        PythonNode operand = visit(ctx.factor());

        // بناء unary factor node
        return new Factor(
                operand,
                op,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitTest(pythonParser.TestContext ctx) {

        PythonNode atomResult = visit(ctx.atom());


        if (atomResult instanceof Logical && ctx.getChildCount() == 1) {
            return atomResult;
        }

        // إذا رجع Logical مثل PlusMinus من ParenAtom — ارجعه مباشرة
        if (atomResult instanceof Logical) {
            // بس إذا ما في operations بعده
            if (ctx.getChildCount() == 1) {
                return atomResult;
            }
            // إذا في operations — لازم نحطه داخل Primary
            // بس هاد ما ممكن لأن Primary بياخذ Atom
            // إذن نرجعه مباشرة
            return atomResult;
        }

        // الحالة العادية
        Atom atom = (Atom) atomResult;

        List<Operation> operations = new ArrayList<>();

        int variableIndex = 0;
        int argIndex = 0;
        int exprIndex = 0;

        for (int i = 1; i < ctx.getChildCount(); ) {

            ParseTree child = ctx.getChild(i);
            String text = child.getText();

            if (text.equals(".")) {
                Variable var = new Variable(
                        ctx.VARIABLE(variableIndex).getText(),
                        ctx.getStart().getLine()
                );
                operations.add(new AttributeAccess(
                        null, var, ctx.getStart().getLine()
                ));
                variableIndex++;
                i += 2;

            } else if (text.equals("(")) {
                ArgumentList args = null;
                if (argIndex < ctx.arg_list().size()) {
                    args = (ArgumentList) visit(ctx.arg_list(argIndex));
                }
                operations.add(new FunctionCall(
                        null, args, ctx.getStart().getLine()
                ));
                argIndex++;
                while (!ctx.getChild(i).getText().equals(")")) i++;
                i++;

            } else if (text.equals("[")) {
                Expr expr = (Expr) visit(ctx.expr(exprIndex));
                operations.add(new ListIndex(
                        null, expr, ctx.getStart().getLine()
                ));
                exprIndex++;
                while (!ctx.getChild(i).getText().equals("]")) i++;
                i++;

            } else {
                i++;
            }
        }

        return new Primary(atom, operations, ctx.getStart().getLine());
    }
    @Override
    public PythonNode visitParamListRule(pythonParser.ParamListRuleContext ctx) {

        List<Parameter> parameters = new ArrayList<>();
        List<TerminalNode> vars = ctx.VARIABLE();

        // نبني كل child بالترتيب
        // كل VARIABLE ممكن يكون بعده ASSIGN + expr أو لا
        int exprIndex = 0;

        for (int i = 0; i < ctx.getChildCount(); i++) {
            String text = ctx.getChild(i).getText();

            // تجاهل COMMA
            if (text.equals(",")) continue;

            // إذا وصلنا لـ VARIABLE
            if (ctx.getChild(i) instanceof TerminalNode) {
                TerminalNode varToken = (TerminalNode) ctx.getChild(i);

                // تحقق إذا الـ token هو VARIABLE فعلاً
                if (varToken.getSymbol().getType() != pythonParser.VARIABLE) continue;

                Variable variable = new Variable(
                        varToken.getText(),
                        varToken.getSymbol().getLine()
                );

                Expr defaultValue = null;

                // شوف إذا الـ child التالي هو ASSIGN
                if (i + 1 < ctx.getChildCount()
                        && ctx.getChild(i + 1).getText().equals("=")) {

                    // الـ expr بعد الـ =
                    defaultValue = (Expr) visit(ctx.expr(exprIndex));
                    exprIndex++;
                    i += 2; // تجاوز = والـ expr
                }

                parameters.add(new Parameter(
                        defaultValue,
                        variable,
                        variable.line
                ));
            }
        }

        return new ParameterList(ctx.getStart().getLine(), parameters);
    }

    @Override
    public PythonNode visitFunctionDefRule(
            pythonParser.FunctionDefRuleContext ctx) {

        Variable functionName = new Variable(
                ctx.VARIABLE().getText(),
                ctx.getStart().getLine()
        );

        ParameterList parameters = null;

        if (ctx.param_list() != null) {

            parameters =
                    (ParameterList) visit(ctx.param_list());
        }

        Suite body =
                (Suite) visit(ctx.suite());

        return new FuntctionDef(
                functionName,
                parameters,
                body,
                ctx.getStart().getLine()
        );
    }

    @Override
    public PythonNode visitElseClauseRule(
            pythonParser.ElseClauseRuleContext ctx) {

        List<Suite> suites = new ArrayList<>();

        suites.add(
                (Suite) visit(ctx.suite())
        );

        return new Else(
                ctx.getStart().getLine(),
                suites
        );
    }

    @Override
    public PythonNode visitElifClauseRule(
            pythonParser.ElifClauseRuleContext ctx) {

        Expr condition =
                (Expr) visit(ctx.expr());

        Suite body =
                (Suite) visit(ctx.suite());

        return new ElseIf(
                condition,
                body,
                null,
                ctx.getStart().getLine()
        );
    }

    @Override
    public PythonNode visitIfStmtRule(
            pythonParser.IfStmtRuleContext ctx) {

        // الشرط الأساسي
        Expr condition =
                (Expr) visit(ctx.expr());

        // then branch
        Suite thenBranch =
                (Suite) visit(ctx.suite());

        // elif branches
        List<ElseIf> elifBranches =
                new ArrayList<>();

        for (pythonParser.Elif_clauseContext elifCtx
                : ctx.elif_clause()) {

            elifBranches.add(
                    (ElseIf) visit(elifCtx)
            );
        }

        // else branch
        Else elseBranch = null;

        if (ctx.else_clause() != null) {

            elseBranch =
                    (Else) visit(ctx.else_clause());
        }

        return new If(
                ctx.getStart().getLine(),
                condition,
                thenBranch,
                elifBranches,
                elseBranch
        );
    }

    @Override
    public PythonNode visitKvPairRule(
            pythonParser.KvPairRuleContext ctx) {

        Expr key =
                (Expr) visit(ctx.expr(0));

        Expr value =
                (Expr) visit(ctx.expr(1));

        return new KeyValuePair(
                key,
                value,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitDictLiteralRule(
            pythonParser.DictLiteralRuleContext ctx) {

        List<KeyValuePair> elements =
                new ArrayList<>();

        for (pythonParser.Kv_pairContext kvCtx
                : ctx.kv_pair()) {

            elements.add(
                    (KeyValuePair) visit(kvCtx)
            );
        }

        return new DistLiteral(
                ctx.getStart().getLine(),
                elements
        );
    }
    @Override
    public PythonNode visitListAtomRule(
            pythonParser.ListAtomRuleContext ctx) {

        PythonNode result = visit(ctx.list_literal());

        // إذا رجع ListComprehension — ارجعه مباشرة بدون Primary
        if (result instanceof ListComprehension) {
            return result;
        }

        // list عادية — ارجع الـ ListLiteral
        return result;
    }

    @Override
    public PythonNode visitDictAtomRule(
            pythonParser.DictAtomRuleContext ctx) {

        return visit(ctx.dict_literal());
    }

    @Override
    public PythonNode visitParenAtomRule(
            pythonParser.ParenAtomRuleContext ctx) {

        return visit(ctx.expr());
    }

    @Override
    public PythonNode visitList_literal(
            pythonParser.List_literalContext ctx) {

        if (ctx.FOR() != null) {

            // كان Primary — صار Expr
            Expr element = (Expr) visit(ctx.expr(0));

            Variable variable = new Variable(
                    ctx.VARIABLE().getText(),
                    ctx.getStart().getLine()
            );

            // كان Primary — صار Expr
            Expr iterable = (Expr) visit(ctx.expr(1));

            Expr condition = null;
            if (ctx.expr().size() > 2) {
                condition = (Expr) visit(ctx.expr(2));
            }

            return new ListComprehension(
                    element,
                    variable,
                    iterable,
                    condition,
                    ctx.getStart().getLine()
            );
        }

        // list عادية
        List<PythonNode> elements = new ArrayList<>();
        for (pythonParser.ExprContext exprCtx : ctx.expr()) {
            elements.add(visit(exprCtx));
        }
        return new ListLiteral(ctx.getStart().getLine(), elements);
    }


    @Override
    public PythonNode visitDecoratorStmtRule(pythonParser.DecoratorStmtRuleContext ctx) {
        Primary primary = (Primary) visit(ctx.test());
        Statement statement = (Statement) visit(ctx.statement());
        return new Decortator(
                primary,
                null,
                statement,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitLogicalExprRule(
            pythonParser.LogicalExprRuleContext ctx) {

        return visit(ctx.or_test());
    }

    @Override
    public PythonNode visitComparisonExprRule(
            pythonParser.ComparisonExprRuleContext ctx) {

        return visit(ctx.comparison());
    }

    @Override
    public PythonNode visitListComprehensionRule(
            pythonParser.ListComprehensionRuleContext ctx) {

        Expr element = (Expr) visit(ctx.test(0));  // كان Primary

        Variable variable = new Variable(
                ctx.VARIABLE().getText(),
                ctx.getStart().getLine()
        );

        Expr iterable = (Expr) visit(ctx.test(1));  // كان Primary

        Expr condition = null;
        if (ctx.expr() != null) {
            condition = (Expr) visit(ctx.expr());
        }

        return new ListComprehension(
                element,
                variable,
                iterable,
                condition,
                ctx.getStart().getLine()
        );
    }


    @Override
    public PythonNode visitFactorToTestRule(
            pythonParser.FactorToTestRuleContext ctx) {

        return visit(ctx.test());
    }

    @Override
    public PythonNode visitDecoratorStatementRule(pythonParser.DecoratorStatementRuleContext ctx) {
        return visit(ctx.decorator_stmt());
    }

    @Override
    public PythonNode visitImportStatementRule(pythonParser.ImportStatementRuleContext ctx) {
        return visit(ctx.import_stmt());
    }

    @Override
    public PythonNode visitAssignStatementRule(pythonParser.AssignStatementRuleContext ctx) {
        return visit(ctx.assign_stmt());
    }

    @Override
    public PythonNode visitFunctionDefinitionRule(pythonParser.FunctionDefinitionRuleContext ctx) {
        return visit(ctx.func_def());
    }

    @Override
    public PythonNode visitIfStatementRule(pythonParser.IfStatementRuleContext ctx) {
        return visit(ctx.if_stmt());
    }

    @Override
    public PythonNode visitWithStatementRule(pythonParser.WithStatementRuleContext ctx) {
        return visit(ctx.with_stmt());
    }

    @Override
    public PythonNode visitForStatementRule(pythonParser.ForStatementRuleContext ctx) {
        return visit(ctx.for_stmt());
    }

    @Override
    public PythonNode visitWhileStatementRule(pythonParser.WhileStatementRuleContext ctx) {
        return visit(ctx.while_stmt());
    }

    @Override
    public PythonNode visitPrintStatementRule(pythonParser.PrintStatementRuleContext ctx) {
        return visit(ctx.print_stmt());
    }

    @Override
    public PythonNode visitReturnStatementRule(pythonParser.ReturnStatementRuleContext ctx) {
        return visit(ctx.return_stmt());
    }

    @Override
    public PythonNode visitExpressionStatementRule(pythonParser.ExpressionStatementRuleContext ctx) {
        return visit(ctx.expr_stmt());
    }
    @Override
    public PythonNode visitPathRule(pythonParser.PathRuleContext ctx) {

        List<Variable> elements = new ArrayList<>();

        // نلف على كل children — VARIABLE أو DOT
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            String text = child.getText();

            // تجاهل DOT
            if (text.equals(".")) continue;

            // كل شي ثاني هو VARIABLE
            elements.add(new Variable(
                    text,
                    ctx.getStart().getLine()
            ));
        }

        return new Path(
                ctx.getStart().getLine(),
                elements
        );
    }
}


