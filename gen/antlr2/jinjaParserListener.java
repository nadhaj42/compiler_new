// Generated from C:/Users/NADA_/IdeaProjects/compiler5555/src/antlr2/jinjaParser.g4 by ANTLR 4.13.2
package antlr2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link jinjaParser}.
 */
public interface jinjaParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link jinjaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(jinjaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link jinjaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(jinjaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlElementContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElementContent(jinjaParser.HtmlElementContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlElementContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElementContent(jinjaParser.HtmlElementContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaStatementContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 */
	void enterJinjaStatementContent(jinjaParser.JinjaStatementContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaStatementContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 */
	void exitJinjaStatementContent(jinjaParser.JinjaStatementContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaExpressionContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpressionContent(jinjaParser.JinjaExpressionContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaExpressionContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpressionContent(jinjaParser.JinjaExpressionContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StyleBlockContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 */
	void enterStyleBlockContent(jinjaParser.StyleBlockContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StyleBlockContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 */
	void exitStyleBlockContent(jinjaParser.StyleBlockContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 */
	void enterTextContent(jinjaParser.TextContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 */
	void exitTextContent(jinjaParser.TextContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlTextContent}
	 * labeled alternative in {@link jinjaParser#htmlText}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTextContent(jinjaParser.HtmlTextContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlTextContent}
	 * labeled alternative in {@link jinjaParser#htmlText}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTextContent(jinjaParser.HtmlTextContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaExpressionWrapper}
	 * labeled alternative in {@link jinjaParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpressionWrapper(jinjaParser.JinjaExpressionWrapperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaExpressionWrapper}
	 * labeled alternative in {@link jinjaParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpressionWrapper(jinjaParser.JinjaExpressionWrapperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(jinjaParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(jinjaParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberAccessExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessExpression(jinjaParser.MemberAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberAccessExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessExpression(jinjaParser.MemberAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOpExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOpExpression(jinjaParser.BinaryOpExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOpExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOpExpression(jinjaParser.BinaryOpExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(jinjaParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(jinjaParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexAccessExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexAccessExpression(jinjaParser.IndexAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexAccessExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexAccessExpression(jinjaParser.IndexAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFilterExpression(jinjaParser.FilterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFilterExpression(jinjaParser.FilterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(jinjaParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(jinjaParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierPrimary(jinjaParser.IdentifierPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierPrimary(jinjaParser.IdentifierPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterNumberPrimary(jinjaParser.NumberPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitNumberPrimary(jinjaParser.NumberPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterStringPrimary(jinjaParser.StringPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitStringPrimary(jinjaParser.StringPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfKeywordPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterIfKeywordPrimary(jinjaParser.IfKeywordPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfKeywordPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitIfKeywordPrimary(jinjaParser.IfKeywordPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseKeywordPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterElseKeywordPrimary(jinjaParser.ElseKeywordPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseKeywordPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitElseKeywordPrimary(jinjaParser.ElseKeywordPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatementContent(jinjaParser.IfStatementContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatementContent(jinjaParser.IfStatementContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatementContent(jinjaParser.ForStatementContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatementContent(jinjaParser.ForStatementContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElifStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterElifStatementContent(jinjaParser.ElifStatementContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElifStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitElifStatementContent(jinjaParser.ElifStatementContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatementContent(jinjaParser.ElseStatementContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatementContent(jinjaParser.ElseStatementContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndifStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterEndifStatementContent(jinjaParser.EndifStatementContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndifStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitEndifStatementContent(jinjaParser.EndifStatementContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndforStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterEndforStatementContent(jinjaParser.EndforStatementContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndforStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitEndforStatementContent(jinjaParser.EndforStatementContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatementWrapper}
	 * labeled alternative in {@link jinjaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatementWrapper(jinjaParser.IfStatementWrapperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatementWrapper}
	 * labeled alternative in {@link jinjaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatementWrapper(jinjaParser.IfStatementWrapperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElifStatementWrapper}
	 * labeled alternative in {@link jinjaParser#elifStatement}.
	 * @param ctx the parse tree
	 */
	void enterElifStatementWrapper(jinjaParser.ElifStatementWrapperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElifStatementWrapper}
	 * labeled alternative in {@link jinjaParser#elifStatement}.
	 * @param ctx the parse tree
	 */
	void exitElifStatementWrapper(jinjaParser.ElifStatementWrapperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseStatementWrapper}
	 * labeled alternative in {@link jinjaParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatementWrapper(jinjaParser.ElseStatementWrapperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseStatementWrapper}
	 * labeled alternative in {@link jinjaParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatementWrapper(jinjaParser.ElseStatementWrapperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndifStatementWrapper}
	 * labeled alternative in {@link jinjaParser#endifStatement}.
	 * @param ctx the parse tree
	 */
	void enterEndifStatementWrapper(jinjaParser.EndifStatementWrapperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndifStatementWrapper}
	 * labeled alternative in {@link jinjaParser#endifStatement}.
	 * @param ctx the parse tree
	 */
	void exitEndifStatementWrapper(jinjaParser.EndifStatementWrapperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatementWrapper}
	 * labeled alternative in {@link jinjaParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatementWrapper(jinjaParser.ForStatementWrapperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatementWrapper}
	 * labeled alternative in {@link jinjaParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatementWrapper(jinjaParser.ForStatementWrapperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndforStatementWrapper}
	 * labeled alternative in {@link jinjaParser#endforStatement}.
	 * @param ctx the parse tree
	 */
	void enterEndforStatementWrapper(jinjaParser.EndforStatementWrapperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndforStatementWrapper}
	 * labeled alternative in {@link jinjaParser#endforStatement}.
	 * @param ctx the parse tree
	 */
	void exitEndforStatementWrapper(jinjaParser.EndforStatementWrapperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForControlContent}
	 * labeled alternative in {@link jinjaParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControlContent(jinjaParser.ForControlContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForControlContent}
	 * labeled alternative in {@link jinjaParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControlContent(jinjaParser.ForControlContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidElementSpecial}
	 * labeled alternative in {@link jinjaParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterVoidElementSpecial(jinjaParser.VoidElementSpecialContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidElementSpecial}
	 * labeled alternative in {@link jinjaParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitVoidElementSpecial(jinjaParser.VoidElementSpecialContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PairedElement}
	 * labeled alternative in {@link jinjaParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterPairedElement(jinjaParser.PairedElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PairedElement}
	 * labeled alternative in {@link jinjaParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitPairedElement(jinjaParser.PairedElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelfClosingElement}
	 * labeled alternative in {@link jinjaParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingElement(jinjaParser.SelfClosingElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelfClosingElement}
	 * labeled alternative in {@link jinjaParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingElement(jinjaParser.SelfClosingElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagBr}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void enterTagBr(jinjaParser.TagBrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagBr}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void exitTagBr(jinjaParser.TagBrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagHr}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void enterTagHr(jinjaParser.TagHrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagHr}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void exitTagHr(jinjaParser.TagHrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagImg}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void enterTagImg(jinjaParser.TagImgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagImg}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void exitTagImg(jinjaParser.TagImgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagInput}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void enterTagInput(jinjaParser.TagInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagInput}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void exitTagInput(jinjaParser.TagInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagMeta}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void enterTagMeta(jinjaParser.TagMetaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagMeta}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void exitTagMeta(jinjaParser.TagMetaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagLink}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void enterTagLink(jinjaParser.TagLinkContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagLink}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 */
	void exitTagLink(jinjaParser.TagLinkContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagHtml}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagHtml(jinjaParser.TagHtmlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagHtml}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagHtml(jinjaParser.TagHtmlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagHead}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagHead(jinjaParser.TagHeadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagHead}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagHead(jinjaParser.TagHeadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagBody}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagBody(jinjaParser.TagBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagBody}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagBody(jinjaParser.TagBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagDiv}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagDiv(jinjaParser.TagDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagDiv}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagDiv(jinjaParser.TagDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagSpan}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagSpan(jinjaParser.TagSpanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagSpan}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagSpan(jinjaParser.TagSpanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagP}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagP(jinjaParser.TagPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagP}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagP(jinjaParser.TagPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagA}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagA(jinjaParser.TagAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagA}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagA(jinjaParser.TagAContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagH}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagH(jinjaParser.TagHContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagH}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagH(jinjaParser.TagHContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagUl}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagUl(jinjaParser.TagUlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagUl}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagUl(jinjaParser.TagUlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagOl}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagOl(jinjaParser.TagOlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagOl}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagOl(jinjaParser.TagOlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagLi}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagLi(jinjaParser.TagLiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagLi}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagLi(jinjaParser.TagLiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagTable}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagTable(jinjaParser.TagTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagTable}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagTable(jinjaParser.TagTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagTr}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagTr(jinjaParser.TagTrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagTr}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagTr(jinjaParser.TagTrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagTd}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagTd(jinjaParser.TagTdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagTd}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagTd(jinjaParser.TagTdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagForm}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagForm(jinjaParser.TagFormContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagForm}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagForm(jinjaParser.TagFormContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagButton}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagButton(jinjaParser.TagButtonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagButton}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagButton(jinjaParser.TagButtonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagScript}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagScript(jinjaParser.TagScriptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagScript}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagScript(jinjaParser.TagScriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagHeader}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagHeader(jinjaParser.TagHeaderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagHeader}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagHeader(jinjaParser.TagHeaderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagFooter}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagFooter(jinjaParser.TagFooterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagFooter}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagFooter(jinjaParser.TagFooterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagSection}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagSection(jinjaParser.TagSectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagSection}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagSection(jinjaParser.TagSectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GenericTag}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterGenericTag(jinjaParser.GenericTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GenericTag}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitGenericTag(jinjaParser.GenericTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CloseTagLiteral}
	 * labeled alternative in {@link jinjaParser#closeTagName}.
	 * @param ctx the parse tree
	 */
	void enterCloseTagLiteral(jinjaParser.CloseTagLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CloseTagLiteral}
	 * labeled alternative in {@link jinjaParser#closeTagName}.
	 * @param ctx the parse tree
	 */
	void exitCloseTagLiteral(jinjaParser.CloseTagLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CloseTagFromOpen}
	 * labeled alternative in {@link jinjaParser#closeTagName}.
	 * @param ctx the parse tree
	 */
	void enterCloseTagFromOpen(jinjaParser.CloseTagFromOpenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CloseTagFromOpen}
	 * labeled alternative in {@link jinjaParser#closeTagName}.
	 * @param ctx the parse tree
	 */
	void exitCloseTagFromOpen(jinjaParser.CloseTagFromOpenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RegularAttribute}
	 * labeled alternative in {@link jinjaParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterRegularAttribute(jinjaParser.RegularAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RegularAttribute}
	 * labeled alternative in {@link jinjaParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitRegularAttribute(jinjaParser.RegularAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DynamicAttribute}
	 * labeled alternative in {@link jinjaParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterDynamicAttribute(jinjaParser.DynamicAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DynamicAttribute}
	 * labeled alternative in {@link jinjaParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitDynamicAttribute(jinjaParser.DynamicAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleQuotedValue}
	 * labeled alternative in {@link jinjaParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterDoubleQuotedValue(jinjaParser.DoubleQuotedValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleQuotedValue}
	 * labeled alternative in {@link jinjaParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitDoubleQuotedValue(jinjaParser.DoubleQuotedValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleQuotedValue}
	 * labeled alternative in {@link jinjaParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterSingleQuotedValue(jinjaParser.SingleQuotedValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleQuotedValue}
	 * labeled alternative in {@link jinjaParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitSingleQuotedValue(jinjaParser.SingleQuotedValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnquotedValue}
	 * labeled alternative in {@link jinjaParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterUnquotedValue(jinjaParser.UnquotedValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnquotedValue}
	 * labeled alternative in {@link jinjaParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitUnquotedValue(jinjaParser.UnquotedValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StyleBlockWrapper}
	 * labeled alternative in {@link jinjaParser#styleBlock}.
	 * @param ctx the parse tree
	 */
	void enterStyleBlockWrapper(jinjaParser.StyleBlockWrapperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StyleBlockWrapper}
	 * labeled alternative in {@link jinjaParser#styleBlock}.
	 * @param ctx the parse tree
	 */
	void exitStyleBlockWrapper(jinjaParser.StyleBlockWrapperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssRuleContent}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void enterCssRuleContent(jinjaParser.CssRuleContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssRuleContent}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void exitCssRuleContent(jinjaParser.CssRuleContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssJinjaStatementContent}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void enterCssJinjaStatementContent(jinjaParser.CssJinjaStatementContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssJinjaStatementContent}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void exitCssJinjaStatementContent(jinjaParser.CssJinjaStatementContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssJinjaExpressionContent}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void enterCssJinjaExpressionContent(jinjaParser.CssJinjaExpressionContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssJinjaExpressionContent}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void exitCssJinjaExpressionContent(jinjaParser.CssJinjaExpressionContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssSemicolon}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void enterCssSemicolon(jinjaParser.CssSemicolonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssSemicolon}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void exitCssSemicolon(jinjaParser.CssSemicolonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StandardCssRule}
	 * labeled alternative in {@link jinjaParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterStandardCssRule(jinjaParser.StandardCssRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StandardCssRule}
	 * labeled alternative in {@link jinjaParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitStandardCssRule(jinjaParser.StandardCssRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssSelectorListRule}
	 * labeled alternative in {@link jinjaParser#cssSelectorList}.
	 * @param ctx the parse tree
	 */
	void enterCssSelectorListRule(jinjaParser.CssSelectorListRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssSelectorListRule}
	 * labeled alternative in {@link jinjaParser#cssSelectorList}.
	 * @param ctx the parse tree
	 */
	void exitCssSelectorListRule(jinjaParser.CssSelectorListRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssSelectorWrapper}
	 * labeled alternative in {@link jinjaParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void enterCssSelectorWrapper(jinjaParser.CssSelectorWrapperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssSelectorWrapper}
	 * labeled alternative in {@link jinjaParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void exitCssSelectorWrapper(jinjaParser.CssSelectorWrapperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssDeclarationListRule}
	 * labeled alternative in {@link jinjaParser#cssDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclarationListRule(jinjaParser.CssDeclarationListRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssDeclarationListRule}
	 * labeled alternative in {@link jinjaParser#cssDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclarationListRule(jinjaParser.CssDeclarationListRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssDeclaration}
	 * labeled alternative in {@link jinjaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclaration(jinjaParser.CssDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssDeclaration}
	 * labeled alternative in {@link jinjaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclaration(jinjaParser.CssDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssValueLiteral}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValueLiteral(jinjaParser.CssValueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssValueLiteral}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValueLiteral(jinjaParser.CssValueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssValueProperty}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValueProperty(jinjaParser.CssValuePropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssValueProperty}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValueProperty(jinjaParser.CssValuePropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssValueTypeSelector}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValueTypeSelector(jinjaParser.CssValueTypeSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssValueTypeSelector}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValueTypeSelector(jinjaParser.CssValueTypeSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssValueIdSelector}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValueIdSelector(jinjaParser.CssValueIdSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssValueIdSelector}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValueIdSelector(jinjaParser.CssValueIdSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssValuePseudoClass}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValuePseudoClass(jinjaParser.CssValuePseudoClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssValuePseudoClass}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValuePseudoClass(jinjaParser.CssValuePseudoClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssValueJinjaExpression}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValueJinjaExpression(jinjaParser.CssValueJinjaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssValueJinjaExpression}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValueJinjaExpression(jinjaParser.CssValueJinjaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssValueListRule}
	 * labeled alternative in {@link jinjaParser#cssValueList}.
	 * @param ctx the parse tree
	 */
	void enterCssValueListRule(jinjaParser.CssValueListRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssValueListRule}
	 * labeled alternative in {@link jinjaParser#cssValueList}.
	 * @param ctx the parse tree
	 */
	void exitCssValueListRule(jinjaParser.CssValueListRuleContext ctx);
}