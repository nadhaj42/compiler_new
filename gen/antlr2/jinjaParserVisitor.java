// Generated from C:/Users/NADA_/IdeaProjects/compiler5555/src/antlr2/jinjaParser.g4 by ANTLR 4.13.2
package antlr2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link jinjaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface jinjaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link jinjaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(jinjaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlElementContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElementContent(jinjaParser.HtmlElementContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaStatementContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaStatementContent(jinjaParser.JinjaStatementContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaExpressionContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpressionContent(jinjaParser.JinjaExpressionContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StyleBlockContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleBlockContent(jinjaParser.StyleBlockContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextContent}
	 * labeled alternative in {@link jinjaParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextContent(jinjaParser.TextContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlTextContent}
	 * labeled alternative in {@link jinjaParser#htmlText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlTextContent(jinjaParser.HtmlTextContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaExpressionWrapper}
	 * labeled alternative in {@link jinjaParser#jinjaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpressionWrapper(jinjaParser.JinjaExpressionWrapperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(jinjaParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAccessExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccessExpression(jinjaParser.MemberAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOpExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOpExpression(jinjaParser.BinaryOpExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(jinjaParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexAccessExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAccessExpression(jinjaParser.IndexAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterExpression(jinjaParser.FilterExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpression}
	 * labeled alternative in {@link jinjaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(jinjaParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierPrimary(jinjaParser.IdentifierPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberPrimary(jinjaParser.NumberPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringPrimary(jinjaParser.StringPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfKeywordPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfKeywordPrimary(jinjaParser.IfKeywordPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseKeywordPrimary}
	 * labeled alternative in {@link jinjaParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseKeywordPrimary(jinjaParser.ElseKeywordPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementContent(jinjaParser.IfStatementContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementContent(jinjaParser.ForStatementContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElifStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifStatementContent(jinjaParser.ElifStatementContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatementContent(jinjaParser.ElseStatementContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndifStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndifStatementContent(jinjaParser.EndifStatementContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndforStatementContent}
	 * labeled alternative in {@link jinjaParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndforStatementContent(jinjaParser.EndforStatementContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatementWrapper}
	 * labeled alternative in {@link jinjaParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementWrapper(jinjaParser.IfStatementWrapperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElifStatementWrapper}
	 * labeled alternative in {@link jinjaParser#elifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifStatementWrapper(jinjaParser.ElifStatementWrapperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseStatementWrapper}
	 * labeled alternative in {@link jinjaParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatementWrapper(jinjaParser.ElseStatementWrapperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndifStatementWrapper}
	 * labeled alternative in {@link jinjaParser#endifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndifStatementWrapper(jinjaParser.EndifStatementWrapperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatementWrapper}
	 * labeled alternative in {@link jinjaParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementWrapper(jinjaParser.ForStatementWrapperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndforStatementWrapper}
	 * labeled alternative in {@link jinjaParser#endforStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndforStatementWrapper(jinjaParser.EndforStatementWrapperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForControlContent}
	 * labeled alternative in {@link jinjaParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControlContent(jinjaParser.ForControlContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidElementSpecial}
	 * labeled alternative in {@link jinjaParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidElementSpecial(jinjaParser.VoidElementSpecialContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PairedElement}
	 * labeled alternative in {@link jinjaParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairedElement(jinjaParser.PairedElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelfClosingElement}
	 * labeled alternative in {@link jinjaParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingElement(jinjaParser.SelfClosingElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagBr}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagBr(jinjaParser.TagBrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagHr}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagHr(jinjaParser.TagHrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagImg}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagImg(jinjaParser.TagImgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagInput}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagInput(jinjaParser.TagInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagMeta}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagMeta(jinjaParser.TagMetaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagLink}
	 * labeled alternative in {@link jinjaParser#voidTagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagLink(jinjaParser.TagLinkContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagHtml}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagHtml(jinjaParser.TagHtmlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagHead}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagHead(jinjaParser.TagHeadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagBody}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagBody(jinjaParser.TagBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagDiv}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagDiv(jinjaParser.TagDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagSpan}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagSpan(jinjaParser.TagSpanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagP}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagP(jinjaParser.TagPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagA}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagA(jinjaParser.TagAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagH}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagH(jinjaParser.TagHContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagUl}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagUl(jinjaParser.TagUlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagOl}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagOl(jinjaParser.TagOlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagLi}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagLi(jinjaParser.TagLiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagTable}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagTable(jinjaParser.TagTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagTr}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagTr(jinjaParser.TagTrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagTd}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagTd(jinjaParser.TagTdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagForm}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagForm(jinjaParser.TagFormContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagButton}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagButton(jinjaParser.TagButtonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagScript}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagScript(jinjaParser.TagScriptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagHeader}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagHeader(jinjaParser.TagHeaderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagFooter}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagFooter(jinjaParser.TagFooterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagSection}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagSection(jinjaParser.TagSectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GenericTag}
	 * labeled alternative in {@link jinjaParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericTag(jinjaParser.GenericTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CloseTagLiteral}
	 * labeled alternative in {@link jinjaParser#closeTagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseTagLiteral(jinjaParser.CloseTagLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CloseTagFromOpen}
	 * labeled alternative in {@link jinjaParser#closeTagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseTagFromOpen(jinjaParser.CloseTagFromOpenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RegularAttribute}
	 * labeled alternative in {@link jinjaParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularAttribute(jinjaParser.RegularAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DynamicAttribute}
	 * labeled alternative in {@link jinjaParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicAttribute(jinjaParser.DynamicAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleQuotedValue}
	 * labeled alternative in {@link jinjaParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuotedValue(jinjaParser.DoubleQuotedValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleQuotedValue}
	 * labeled alternative in {@link jinjaParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleQuotedValue(jinjaParser.SingleQuotedValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnquotedValue}
	 * labeled alternative in {@link jinjaParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnquotedValue(jinjaParser.UnquotedValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StyleBlockWrapper}
	 * labeled alternative in {@link jinjaParser#styleBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleBlockWrapper(jinjaParser.StyleBlockWrapperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssRuleContent}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRuleContent(jinjaParser.CssRuleContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssJinjaStatementContent}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssJinjaStatementContent(jinjaParser.CssJinjaStatementContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssJinjaExpressionContent}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssJinjaExpressionContent(jinjaParser.CssJinjaExpressionContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssSemicolon}
	 * labeled alternative in {@link jinjaParser#cssContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSemicolon(jinjaParser.CssSemicolonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StandardCssRule}
	 * labeled alternative in {@link jinjaParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandardCssRule(jinjaParser.StandardCssRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssSelectorListRule}
	 * labeled alternative in {@link jinjaParser#cssSelectorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSelectorListRule(jinjaParser.CssSelectorListRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssSelectorWrapper}
	 * labeled alternative in {@link jinjaParser#cssSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSelectorWrapper(jinjaParser.CssSelectorWrapperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssDeclarationListRule}
	 * labeled alternative in {@link jinjaParser#cssDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclarationListRule(jinjaParser.CssDeclarationListRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssDeclaration}
	 * labeled alternative in {@link jinjaParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclaration(jinjaParser.CssDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssValueLiteral}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueLiteral(jinjaParser.CssValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssValueProperty}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueProperty(jinjaParser.CssValuePropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssValueTypeSelector}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueTypeSelector(jinjaParser.CssValueTypeSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssValueIdSelector}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueIdSelector(jinjaParser.CssValueIdSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssValuePseudoClass}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValuePseudoClass(jinjaParser.CssValuePseudoClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssValueJinjaExpression}
	 * labeled alternative in {@link jinjaParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueJinjaExpression(jinjaParser.CssValueJinjaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssValueListRule}
	 * labeled alternative in {@link jinjaParser#cssValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueListRule(jinjaParser.CssValueListRuleContext ctx);
}