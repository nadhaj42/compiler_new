// Generated from E:/compiler_new/src/antlr/pythonParser.g4 by ANTLR 4.13.2
package antlr;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link pythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface pythonParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ProgramRule}
	 * labeled alternative in {@link pythonParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramRule(pythonParser.ProgramRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecoratorStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorStatementRule(pythonParser.DecoratorStatementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatementRule(pythonParser.ImportStatementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatementRule(pythonParser.AssignStatementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDefinitionRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinitionRule(pythonParser.FunctionDefinitionRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementRule(pythonParser.IfStatementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WithStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatementRule(pythonParser.WithStatementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementRule(pythonParser.ForStatementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementRule(pythonParser.WhileStatementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatementRule(pythonParser.PrintStatementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatementRule(pythonParser.ReturnStatementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatementRule(pythonParser.ExpressionStatementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SuiteBlockRule}
	 * labeled alternative in {@link pythonParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuiteBlockRule(pythonParser.SuiteBlockRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecoratorStmtRule}
	 * labeled alternative in {@link pythonParser#decorator_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorStmtRule(pythonParser.DecoratorStmtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDefRule}
	 * labeled alternative in {@link pythonParser#func_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefRule(pythonParser.FunctionDefRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmtRule}
	 * labeled alternative in {@link pythonParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmtRule(pythonParser.IfStmtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElifClauseRule}
	 * labeled alternative in {@link pythonParser#elif_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifClauseRule(pythonParser.ElifClauseRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseClauseRule}
	 * labeled alternative in {@link pythonParser#else_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseClauseRule(pythonParser.ElseClauseRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStmtRule}
	 * labeled alternative in {@link pythonParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmtRule(pythonParser.ForStmtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmtRule}
	 * labeled alternative in {@link pythonParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmtRule(pythonParser.WhileStmtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStmtRule}
	 * labeled alternative in {@link pythonParser#print_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmtRule(pythonParser.PrintStmtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WithStmtRule}
	 * labeled alternative in {@link pythonParser#with_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStmtRule(pythonParser.WithStmtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportStmtRule}
	 * labeled alternative in {@link pythonParser#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStmtRule(pythonParser.ImportStmtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PathRule}
	 * labeled alternative in {@link pythonParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathRule(pythonParser.PathRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStmtRule}
	 * labeled alternative in {@link pythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmtRule(pythonParser.AssignStmtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmtRule}
	 * labeled alternative in {@link pythonParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmtRule(pythonParser.ReturnStmtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStmtRule}
	 * labeled alternative in {@link pythonParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmtRule(pythonParser.ExprStmtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalExprRule}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExprRule(pythonParser.LogicalExprRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListComprehensionRule}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComprehensionRule(pythonParser.ListComprehensionRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrTestRule}
	 * labeled alternative in {@link pythonParser#or_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrTestRule(pythonParser.OrTestRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndTestRule}
	 * labeled alternative in {@link pythonParser#and_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndTestRule(pythonParser.AndTestRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExprRule}
	 * labeled alternative in {@link pythonParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExprRule(pythonParser.NotExprRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExprRule}
	 * labeled alternative in {@link pythonParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExprRule(pythonParser.ComparisonExprRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonRule}
	 * labeled alternative in {@link pythonParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonRule(pythonParser.ComparisonRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticRule}
	 * labeled alternative in {@link pythonParser#arithmeticExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticRule(pythonParser.ArithmeticRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TermRule}
	 * labeled alternative in {@link pythonParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermRule(pythonParser.TermRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExprRule}
	 * labeled alternative in {@link pythonParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExprRule(pythonParser.UnaryExprRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorToTestRule}
	 * labeled alternative in {@link pythonParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorToTestRule(pythonParser.FactorToTestRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(pythonParser.TestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAtomRule(pythonParser.VariableAtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtomRule(pythonParser.NumberAtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FLOATAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFLOATAtomRule(pythonParser.FLOATAtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtomRule(pythonParser.StringAtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoneAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneAtomRule(pythonParser.NoneAtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueAtomRule(pythonParser.TrueAtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseAtomRule(pythonParser.FalseAtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DictAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictAtomRule(pythonParser.DictAtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAtomRule(pythonParser.ListAtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenAtomRule(pythonParser.ParenAtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgListRule}
	 * labeled alternative in {@link pythonParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgListRule(pythonParser.ArgListRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentRule}
	 * labeled alternative in {@link pythonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentRule(pythonParser.ArgumentRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DictLiteralRule}
	 * labeled alternative in {@link pythonParser#dict_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictLiteralRule(pythonParser.DictLiteralRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KvPairRule}
	 * labeled alternative in {@link pythonParser#kv_pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKvPairRule(pythonParser.KvPairRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonParser#list_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_literal(pythonParser.List_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamListRule}
	 * labeled alternative in {@link pythonParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamListRule(pythonParser.ParamListRuleContext ctx);
}