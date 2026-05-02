// Generated from C:/Users/NADA_/IdeaProjects/compiler5555/src/antlr/pythonParser.g4 by ANTLR 4.13.2
package antlr;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pythonParser}.
 */
public interface pythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ProgramRule}
	 * labeled alternative in {@link pythonParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgramRule(pythonParser.ProgramRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgramRule}
	 * labeled alternative in {@link pythonParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgramRule(pythonParser.ProgramRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecoratorStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDecoratorStatementRule(pythonParser.DecoratorStatementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecoratorStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDecoratorStatementRule(pythonParser.DecoratorStatementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatementRule(pythonParser.ImportStatementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatementRule(pythonParser.ImportStatementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatementRule(pythonParser.AssignStatementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatementRule(pythonParser.AssignStatementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDefinitionRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinitionRule(pythonParser.FunctionDefinitionRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDefinitionRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinitionRule(pythonParser.FunctionDefinitionRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatementRule(pythonParser.IfStatementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatementRule(pythonParser.IfStatementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WithStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatementRule(pythonParser.WithStatementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WithStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatementRule(pythonParser.WithStatementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatementRule(pythonParser.ForStatementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatementRule(pythonParser.ForStatementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatementRule(pythonParser.WhileStatementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatementRule(pythonParser.WhileStatementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatementRule(pythonParser.PrintStatementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatementRule(pythonParser.PrintStatementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatementRule(pythonParser.ReturnStatementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatementRule(pythonParser.ReturnStatementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatementRule(pythonParser.ExpressionStatementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStatementRule}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatementRule(pythonParser.ExpressionStatementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SuiteBlockRule}
	 * labeled alternative in {@link pythonParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuiteBlockRule(pythonParser.SuiteBlockRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SuiteBlockRule}
	 * labeled alternative in {@link pythonParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuiteBlockRule(pythonParser.SuiteBlockRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecoratorStmtRule}
	 * labeled alternative in {@link pythonParser#decorator_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDecoratorStmtRule(pythonParser.DecoratorStmtRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecoratorStmtRule}
	 * labeled alternative in {@link pythonParser#decorator_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDecoratorStmtRule(pythonParser.DecoratorStmtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDefRule}
	 * labeled alternative in {@link pythonParser#func_def}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefRule(pythonParser.FunctionDefRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDefRule}
	 * labeled alternative in {@link pythonParser#func_def}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefRule(pythonParser.FunctionDefRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmtRule}
	 * labeled alternative in {@link pythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmtRule(pythonParser.IfStmtRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmtRule}
	 * labeled alternative in {@link pythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmtRule(pythonParser.IfStmtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElifClauseRule}
	 * labeled alternative in {@link pythonParser#elif_clause}.
	 * @param ctx the parse tree
	 */
	void enterElifClauseRule(pythonParser.ElifClauseRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElifClauseRule}
	 * labeled alternative in {@link pythonParser#elif_clause}.
	 * @param ctx the parse tree
	 */
	void exitElifClauseRule(pythonParser.ElifClauseRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseClauseRule}
	 * labeled alternative in {@link pythonParser#else_clause}.
	 * @param ctx the parse tree
	 */
	void enterElseClauseRule(pythonParser.ElseClauseRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseClauseRule}
	 * labeled alternative in {@link pythonParser#else_clause}.
	 * @param ctx the parse tree
	 */
	void exitElseClauseRule(pythonParser.ElseClauseRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStmtRule}
	 * labeled alternative in {@link pythonParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmtRule(pythonParser.ForStmtRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStmtRule}
	 * labeled alternative in {@link pythonParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmtRule(pythonParser.ForStmtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmtRule}
	 * labeled alternative in {@link pythonParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmtRule(pythonParser.WhileStmtRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmtRule}
	 * labeled alternative in {@link pythonParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmtRule(pythonParser.WhileStmtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStmtRule}
	 * labeled alternative in {@link pythonParser#print_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmtRule(pythonParser.PrintStmtRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStmtRule}
	 * labeled alternative in {@link pythonParser#print_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmtRule(pythonParser.PrintStmtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WithStmtRule}
	 * labeled alternative in {@link pythonParser#with_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWithStmtRule(pythonParser.WithStmtRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WithStmtRule}
	 * labeled alternative in {@link pythonParser#with_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWithStmtRule(pythonParser.WithStmtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportStmtRule}
	 * labeled alternative in {@link pythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImportStmtRule(pythonParser.ImportStmtRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportStmtRule}
	 * labeled alternative in {@link pythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImportStmtRule(pythonParser.ImportStmtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PathRule}
	 * labeled alternative in {@link pythonParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPathRule(pythonParser.PathRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PathRule}
	 * labeled alternative in {@link pythonParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPathRule(pythonParser.PathRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStmtRule}
	 * labeled alternative in {@link pythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmtRule(pythonParser.AssignStmtRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStmtRule}
	 * labeled alternative in {@link pythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmtRule(pythonParser.AssignStmtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmtRule}
	 * labeled alternative in {@link pythonParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmtRule(pythonParser.ReturnStmtRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmtRule}
	 * labeled alternative in {@link pythonParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmtRule(pythonParser.ReturnStmtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStmtRule}
	 * labeled alternative in {@link pythonParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmtRule(pythonParser.ExprStmtRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStmtRule}
	 * labeled alternative in {@link pythonParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmtRule(pythonParser.ExprStmtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExprRule}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExprRule(pythonParser.LogicalExprRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExprRule}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExprRule(pythonParser.LogicalExprRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListComprehensionRule}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterListComprehensionRule(pythonParser.ListComprehensionRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListComprehensionRule}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitListComprehensionRule(pythonParser.ListComprehensionRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrTestRule}
	 * labeled alternative in {@link pythonParser#or_test}.
	 * @param ctx the parse tree
	 */
	void enterOrTestRule(pythonParser.OrTestRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrTestRule}
	 * labeled alternative in {@link pythonParser#or_test}.
	 * @param ctx the parse tree
	 */
	void exitOrTestRule(pythonParser.OrTestRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndTestRule}
	 * labeled alternative in {@link pythonParser#and_test}.
	 * @param ctx the parse tree
	 */
	void enterAndTestRule(pythonParser.AndTestRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndTestRule}
	 * labeled alternative in {@link pythonParser#and_test}.
	 * @param ctx the parse tree
	 */
	void exitAndTestRule(pythonParser.AndTestRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExprRule}
	 * labeled alternative in {@link pythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterNotExprRule(pythonParser.NotExprRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExprRule}
	 * labeled alternative in {@link pythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitNotExprRule(pythonParser.NotExprRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExprRule}
	 * labeled alternative in {@link pythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExprRule(pythonParser.ComparisonExprRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExprRule}
	 * labeled alternative in {@link pythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExprRule(pythonParser.ComparisonExprRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonRule}
	 * labeled alternative in {@link pythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparisonRule(pythonParser.ComparisonRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonRule}
	 * labeled alternative in {@link pythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparisonRule(pythonParser.ComparisonRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticRule}
	 * labeled alternative in {@link pythonParser#arithmeticExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticRule(pythonParser.ArithmeticRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticRule}
	 * labeled alternative in {@link pythonParser#arithmeticExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticRule(pythonParser.ArithmeticRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TermRule}
	 * labeled alternative in {@link pythonParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermRule(pythonParser.TermRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TermRule}
	 * labeled alternative in {@link pythonParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermRule(pythonParser.TermRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExprRule}
	 * labeled alternative in {@link pythonParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExprRule(pythonParser.UnaryExprRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExprRule}
	 * labeled alternative in {@link pythonParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExprRule(pythonParser.UnaryExprRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorToTestRule}
	 * labeled alternative in {@link pythonParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorToTestRule(pythonParser.FactorToTestRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorToTestRule}
	 * labeled alternative in {@link pythonParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorToTestRule(pythonParser.FactorToTestRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link pythonParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(pythonParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(pythonParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterVariableAtomRule(pythonParser.VariableAtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitVariableAtomRule(pythonParser.VariableAtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtomRule(pythonParser.NumberAtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtomRule(pythonParser.NumberAtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FLOATAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFLOATAtomRule(pythonParser.FLOATAtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FLOATAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFLOATAtomRule(pythonParser.FLOATAtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtomRule(pythonParser.StringAtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtomRule(pythonParser.StringAtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoneAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNoneAtomRule(pythonParser.NoneAtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoneAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNoneAtomRule(pythonParser.NoneAtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterTrueAtomRule(pythonParser.TrueAtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitTrueAtomRule(pythonParser.TrueAtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFalseAtomRule(pythonParser.FalseAtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFalseAtomRule(pythonParser.FalseAtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DictAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDictAtomRule(pythonParser.DictAtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DictAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDictAtomRule(pythonParser.DictAtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterListAtomRule(pythonParser.ListAtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitListAtomRule(pythonParser.ListAtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParenAtomRule(pythonParser.ParenAtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenAtomRule}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParenAtomRule(pythonParser.ParenAtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgListRule}
	 * labeled alternative in {@link pythonParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArgListRule(pythonParser.ArgListRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgListRule}
	 * labeled alternative in {@link pythonParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArgListRule(pythonParser.ArgListRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentRule}
	 * labeled alternative in {@link pythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgumentRule(pythonParser.ArgumentRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentRule}
	 * labeled alternative in {@link pythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgumentRule(pythonParser.ArgumentRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DictLiteralRule}
	 * labeled alternative in {@link pythonParser#dict_literal}.
	 * @param ctx the parse tree
	 */
	void enterDictLiteralRule(pythonParser.DictLiteralRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DictLiteralRule}
	 * labeled alternative in {@link pythonParser#dict_literal}.
	 * @param ctx the parse tree
	 */
	void exitDictLiteralRule(pythonParser.DictLiteralRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KvPairRule}
	 * labeled alternative in {@link pythonParser#kv_pair}.
	 * @param ctx the parse tree
	 */
	void enterKvPairRule(pythonParser.KvPairRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KvPairRule}
	 * labeled alternative in {@link pythonParser#kv_pair}.
	 * @param ctx the parse tree
	 */
	void exitKvPairRule(pythonParser.KvPairRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link pythonParser#list_literal}.
	 * @param ctx the parse tree
	 */
	void enterList_literal(pythonParser.List_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonParser#list_literal}.
	 * @param ctx the parse tree
	 */
	void exitList_literal(pythonParser.List_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamListRule}
	 * labeled alternative in {@link pythonParser#param_list}.
	 * @param ctx the parse tree
	 */
	void enterParamListRule(pythonParser.ParamListRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamListRule}
	 * labeled alternative in {@link pythonParser#param_list}.
	 * @param ctx the parse tree
	 */
	void exitParamListRule(pythonParser.ParamListRuleContext ctx);
}