package Visitor.Python;//package Visitor.Python;
//
//import AST.Python.Parmeter;
//
//import java.util.List;
//import java.util.ArrayList;
//
//import AST.Python.Statement.Block;
//
//import antlr.pythonParser;
//import AST.Python.PythonNode;
//import AST.Python.Expr.*;
//import AST.Python.Statement.*;
//import antlr.pythonParserBaseVisitor;
//import AST.Python.Program;
//
//
//public class PythonVisitor extends pythonParserBaseVisitor<PythonNode> {
//    @Override
//    public PythonNode visitProg(pythonParser.ProgContext ctx) {
//
//        List<PythonNode> statements = new ArrayList<>();
//
//        for (pythonParser.StatementContext stmtCtx : ctx.statement()) {
//            PythonNode stmt = visit(stmtCtx);
//            if (stmt != null) {
//                statements.add(stmt);
//            }
//        }
//
//        int line = ctx.start.getLine();
//        return new Program(line, statements);
//    }
//
//    @Override
//    public PythonNode visitExpressionStatement(
//            pythonParser.ExpressionStatementContext ctx) {
//        return visit(ctx.expr_stmt().expr());
//    }
//
//
//    @Override
//    public PythonNode visitUnaryExpr(pythonParser.UnaryExprContext ctx) {
//
//        Expr expr = (Expr) visit(ctx.primary());
//        String op = ctx.getChild(0).getText();
//
//        if (op.equals("-"))
//            return new Negate(ctx.start.getLine(), expr);
//
//        return expr; // unary +
//    }
//
//
//    @Override
//    public PythonNode visitArithmeticExpr(
//            pythonParser.ArithmeticExprContext ctx) {
//
//        Expr left = (Expr) visit(ctx.primary(0));
//
//        for (int i = 1; i < ctx.primary().size(); i++) {
//
//            String op = ctx.getChild(2 * i - 1).getText();
//            Expr right = (Expr) visit(ctx.primary(i));
//
//            switch (op) {
//                case "+":
//                case "-":
//                    left = new AddSub(ctx.start.getLine(), left, op, right);
//                    break;
//
//                case "*":
//                case "/":
//                    left = new MulDiv(ctx.start.getLine(), left, op, right);
//                    break;
//
//                default:
//                    left = new Comparison(ctx.start.getLine(), left, op, right);
//            }
//        }
//
//        return left;
//    }
//
////    @Override
////    public PythonNode visitAtomExpr(pythonParser.AtomExprContext ctx) {
////        return visit(ctx.atom());
////    }
//
//
//    @Override
//    public PythonNode visitAtom(pythonParser.AtomContext ctx) {
//        int line = ctx.start.getLine();
//
//        if (ctx.VARIABLE() != null)
//            return new Variable(line, ctx.VARIABLE().getText());
//
//        if (ctx.NUMBER() != null)
//            return new NumberLiteral(line, Double.parseDouble(ctx.NUMBER().getText()));
//
//        if (ctx.STRING() != null)
//            return new StringLiteral(line, ctx.STRING().getText());
//
//        if (ctx.TRUE() != null)
//            return new BooleanLiteral(line, true);
//
//        if (ctx.FALSE() != null)
//            return new BooleanLiteral(line, false);
//
//        if (ctx.list_literal() != null)
//            return visit(ctx.list_literal());
//
//        if (ctx.dict_literal() != null)
//            return visit(ctx.dict_literal());
//
//        if (ctx.expr() != null) {
//            return visit(ctx.expr());
//        }
//
//        return null;
//    }
//
//
//    @Override
//    public PythonNode visitAtomExprPrimary(pythonParser.AtomExprPrimaryContext ctx) {
//        return visit(ctx.atom());
//    }
//
//    @Override
//    public PythonNode visitAttributeAccess(pythonParser.AttributeAccessContext ctx) {
//
//        int line = ctx.start.getLine();
//        Expr object = (Expr) visit(ctx.primary());
//        String attr = ctx.VARIABLE().getText();
//
//        return new AttributeAccess(line, object, attr);
//    }
//
//    @Override
//    public PythonNode visitFunctionCall(pythonParser.FunctionCallContext ctx) {
//        int line = ctx.start.getLine();
//        Expr target = (Expr) visit(ctx.primary());
//
//        List<Expr> args = new ArrayList<>();
//        if (ctx.arg_list() != null) {
//            for (pythonParser.ArgumentContext argCtx : ctx.arg_list().argument()) {
//                args.add((Expr) visit(argCtx.expr()));
//            }
//        }
//        return new FunctionCall(line, target, args);
//    }
//
//    @Override
//    public PythonNode visitListIndex(pythonParser.ListIndexContext ctx) {
//
//        int line = ctx.start.getLine();
//        Expr object = (Expr) visit(ctx.primary());
//        Expr index = (Expr) visit(ctx.expr());
//
//        return new Subscript(line, object, index);
//    }
//
//
//    @Override
//    public PythonNode visitList_literal(pythonParser.List_literalContext ctx) {
//
//        int line = ctx.start.getLine();
//        List<Expr> elements = new ArrayList<>();
//
//        for (pythonParser.ExprContext ectx : ctx.expr()) {
//            elements.add((Expr) visit(ectx));
//        }
//
//        return new ListExpr(line, elements);
//    }
//
//    @Override
//    public PythonNode visitDict_literal(pythonParser.Dict_literalContext ctx) {
//
//        int line = ctx.start.getLine();
//        List<Expr> keys = new ArrayList<>();
//        List<Expr> values = new ArrayList<>();
//
//        for (pythonParser.Kv_pairContext kv : ctx.kv_pair()) {
//            keys.add((Expr) visit(kv.expr(0)));
//            values.add((Expr) visit(kv.expr(1)));
//        }
//
//        return new DictLiteral(line, keys, values);
//    }
//
//
//    @Override
//    public PythonNode visitAssignStatement(pythonParser.AssignStatementContext ctx) {
//
//        int line = ctx.start.getLine();
//
//        Expr target = (Expr) visit(ctx.assign_stmt().primary());
//
//        String op = ctx.assign_stmt().ASSIGN().getText();
//
//        Expr value = (Expr) visit(ctx.assign_stmt().expr());
//
//        return new Assignment(line, target, op, value);
//    }
//
//    @Override
//    public PythonNode visitReturnStatement(pythonParser.ReturnStatementContext ctx) {
//
//        int line = ctx.start.getLine();
//        Expr value = null;
//
//        if (ctx.return_stmt().expr() != null) {
//            value = (Expr) visit(ctx.return_stmt().expr());
//        }
//
//        return new ReturnStmt(line, value);
//    }
//
//    @Override
//    public PythonNode visitPrintStatement(pythonParser.PrintStatementContext ctx) {
//
//        int line = ctx.start.getLine();
//        List<Expr> args = new ArrayList<>();
//
//        if (ctx.print_stmt().arg_list() != null) {
//            for (pythonParser.ArgumentContext argCtx :
//                    ctx.print_stmt().arg_list().argument()) {
//                args.add((Expr) visit(argCtx.expr()));
//            }
//        }
//
//        return new PrintStmt(line, args);
//    }
//
//    @Override
//    public PythonNode visitImportStatement(pythonParser.ImportStatementContext ctx) {
//
//        int line = ctx.start.getLine();
//        List<String> modules = new ArrayList<>();
//
//        pythonParser.Import_stmtContext ictx = ctx.import_stmt();
//
//        modules.add(ictx.path(ictx.path().size() - 1).getText());
//
//        return new Import(line, modules);
//    }
//
//    @Override
//    public PythonNode visitSuite(pythonParser.SuiteContext ctx) {
//        int line = ctx.start.getLine();
//        List<PythonNode> body = new ArrayList<>();
//
//        for (pythonParser.StatementContext stmtCtx : ctx.statement()) {
//            PythonNode stmt = visit(stmtCtx);
//            if (stmt != null)
//                body.add(stmt);
//        }
//
//        return new Block(line, body);
//    }
//
//
//    @Override
//    public PythonNode visitIfStatement(pythonParser.IfStatementContext ctx) {
//
//        pythonParser.If_stmtContext ifCtx = ctx.if_stmt();
//        int line = ifCtx.start.getLine();
//
//        Expr condition = (Expr) visit(ifCtx.expr());
//
//        Block thenBlock = (Block) visit(ifCtx.suite());
//        List<PythonNode> thenBody = thenBlock.body;
//
//        List<PythonNode> elifNodes = new ArrayList<>();
//        for (pythonParser.Elif_clauseContext elifCtx : ifCtx.elif_clause()) {
//
//            Expr elifCond = (Expr) visit(elifCtx.expr());
//            Block elifBlock = (Block) visit(elifCtx.suite());
//            IfStmt elifStmt = new IfStmt(
//                    elifCtx.start.getLine(),
//                    elifCond,
//                    elifBlock.body,
//                    null,
//                    null
//            );
//
//            elifNodes.add(elifStmt);
//        }
//
//        List<PythonNode> elseBody = null;
//        if (ifCtx.else_clause() != null) {
//            Block elseBlock = (Block) visit(ifCtx.else_clause().suite());
//            elseBody = elseBlock.body;
//        }
//
//        return new IfStmt(line, condition, thenBody, elifNodes, elseBody);
//    }
//
//
//    @Override
//    public PythonNode visitWhileStatement(pythonParser.WhileStatementContext ctx) {
//
//        pythonParser.While_stmtContext wctx = ctx.while_stmt();
//        int line = wctx.start.getLine();
//
//        Expr condition = (Expr) visit(wctx.expr());
//
//        Block block = (Block) visit(wctx.suite());
//        List<PythonNode> body = block.body;
//
//        return new WhileStmt(line, condition, body);
//    }
//
//    @Override
//    public PythonNode visitForStatement(pythonParser.ForStatementContext ctx) {
//
//        pythonParser.For_stmtContext fctx = ctx.for_stmt();
//        int line = fctx.start.getLine();
//
//        String iterator = fctx.VARIABLE().getText();
//        Expr iterable = (Expr) visit(fctx.expr());
//        Block block = (Block) visit(fctx.suite());
//        List<PythonNode> body = block.body;
//
//        return new ForStmt(line, iterator, iterable, body);
//    }
//
//
//    @Override
//    public PythonNode visitFunctionDefinition(
//            pythonParser.FunctionDefinitionContext ctx) {
//
//        pythonParser.Func_defContext fctx = ctx.func_def();
//        int line = fctx.start.getLine();
//
//        String name = fctx.VARIABLE().getText();
//
//        List<Parmeter> parameters = new ArrayList<>();
//        if (fctx.param_list() != null) {
//            for (var param : fctx.param_list().VARIABLE()) {
//                parameters.add(
//                        new Parmeter(
//                                param.getSymbol().getLine(),
//                                param.getText()
//                        )
//                );
//            }
//        }
//
//        Block block = (Block) visit(fctx.suite());
//        List<PythonNode> body = block.body;
//
//        return new FunctionDef(line, name, parameters, body);
//    }
//
//
//    @Override
//    public PythonNode visitWithStatement(pythonParser.WithStatementContext ctx) {
//
//        pythonParser.With_stmtContext wctx = ctx.with_stmt();
//        int line = wctx.start.getLine();
//
//        Expr expr = (Expr) visit(wctx.expr());
//
//        String var = null;
//        if (wctx.VARIABLE() != null) {
//            var = wctx.VARIABLE().getText();
//        }
//
//        Block block = (Block) visit(wctx.suite());
//        List<PythonNode> body = block.body;
//
//        return new WithNode(line, expr, var, body);
//    }
//
//
//}