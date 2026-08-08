package Visitor.html_css_jinja;

import AST.html_css_jinja.*;
import AST.html_css_jinja.html.*;
import AST.html_css_jinja.jinja.*;
import AST.html_css_jinja.css.*;
import AST.html_css_jinja.Expression.*;

import antlr2.jinjaParser;
import antlr2.jinjaParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class visitor extends jinjaParserBaseVisitor<Node> {

    // 1. PROGRAM

    @Override
    public Node visitProgram(jinjaParser.ProgramContext ctx) {
        List<Node> flat = new ArrayList<>();
        for (jinjaParser.ContentContext contentCtx : ctx.content()) {
            Node node = visit(contentCtx);
            if (node != null) flat.add(node);
        }
        int line = ctx.getStart().getLine();
        List<Node> structured = buildStructuredList(flat);
        return new Program(line, structured);
    }

    private List<Node> buildStructuredList(List<Node> flat) {
        List<Node> result = new ArrayList<>();
        int i = 0;
        while (i < flat.size()) {
            Node node = flat.get(i);

            if (node instanceof ifStatement) {
                ifStatement ifNode = (ifStatement) node;
                i++;

                List<Node> thenBody = new ArrayList<>();
                while (i < flat.size()
                        && !(flat.get(i) instanceof ElifBranch)
                        && !(flat.get(i) instanceof ElseBranch)
                        && !(flat.get(i) instanceof EndifMarker)) {
                    thenBody.add(flat.get(i++));  // ← بدون cast
                }

                List<ElifBranch> elifs = new ArrayList<>();
                while (i < flat.size() && flat.get(i) instanceof ElifBranch) {
                    ElifBranch elif = (ElifBranch) flat.get(i++);
                    List<Node> elifFlat = new ArrayList<>();
                    while (i < flat.size()
                            && !(flat.get(i) instanceof ElifBranch)
                            && !(flat.get(i) instanceof ElseBranch)
                            && !(flat.get(i) instanceof EndifMarker)) {
                        elifFlat.add(flat.get(i++));
                    }
                    elif.statements = toContentList(buildStructuredList(elifFlat));
                    elifs.add(elif);
                }

                ElseBranch elseBranch = null;
                if (i < flat.size() && flat.get(i) instanceof ElseBranch) {
                    ElseBranch elseNode = (ElseBranch) flat.get(i++);
                    List<Node> elseFlat = new ArrayList<>();
                    while (i < flat.size() && !(flat.get(i) instanceof EndifMarker)) {
                        elseFlat.add(flat.get(i++));
                    }
                    elseNode.statements = toContentList(buildStructuredList(elseFlat));
                    elseBranch = elseNode;
                }

                if (i < flat.size() && flat.get(i) instanceof EndifMarker) i++;

                result.add(new ifStatement(
                        ifNode.line,
                        ifNode.condition,
                        toContentList(buildStructuredList(thenBody)),
                        elifs.isEmpty() ? null : elifs,
                        elseBranch
                ));

            } else if (node instanceof ForStatement) {
                ForStatement forNode = (ForStatement) node;
                i++;

                // ← غيّر من List<ContentNode> إلى List<Node>
                List<Node> bodyFlat = new ArrayList<>();
                while (i < flat.size() && !(flat.get(i) instanceof EndforMarker)) {
                    bodyFlat.add(flat.get(i++));  // ← بدون cast
                }
                if (i < flat.size()) i++;

                result.add(new ForStatement(
                        forNode.line,
                        toContentList(buildStructuredList(bodyFlat)),
                        forNode.control
                ));

            } else {
                result.add(node);
                i++;
            }
        }
        return result;
    }

    private List<ContentNode> toContentList(List<Node> nodes) {
        List<ContentNode> result = new ArrayList<>();
        for (Node n : nodes) {
            if (n instanceof ContentNode) {
                result.add((ContentNode) n);
            }
        }
        return result;
    }


    // 2. CONTENT

    @Override
    public Node visitHtmlElementContent(jinjaParser.HtmlElementContentContext ctx) {
        return visit(ctx.htmlElement());
    }

    @Override
    public Node visitJinjaStatementContent(jinjaParser.JinjaStatementContentContext ctx) {
        return visit(ctx.jinjaStatement());
    }

    @Override
    public Node visitJinjaExpressionContent(jinjaParser.JinjaExpressionContentContext ctx) {
        return visit(ctx.jinjaExpression());
    }

    @Override
    public Node visitStyleBlockContent(jinjaParser.StyleBlockContentContext ctx) {
        return visit(ctx.styleBlock());
    }

    @Override
    public Node visitTextContent(jinjaParser.TextContentContext ctx) {
        return visit(ctx.htmlText());
    }

    @Override
    public Node visitHtmlTextContent(jinjaParser.HtmlTextContentContext ctx) {
        String text = ctx.HTML_TEXT().getText();
        int line = ctx.getStart().getLine();
        return new HtmlTextNode(text, line);
    }


    // 3. JINJA EXPRESSIONS

    @Override
    public Node visitJinjaExpressionWrapper(jinjaParser.JinjaExpressionWrapperContext ctx) {
        ExpressionNode inner = (ExpressionNode) visit(ctx.expr());
        int line = ctx.getStart().getLine();
        return new JinjaExpression(inner, line);
    }

    //expr rules
    @Override
    public Node visitPrimaryExpression(jinjaParser.PrimaryExpressionContext ctx) {
        return visit(ctx.primaryExpr());
    }


    @Override
    public Node visitFunctionCallExpression(jinjaParser.FunctionCallExpressionContext ctx) {
        ExpressionNode function = (ExpressionNode) visit(ctx.expr(0));
        List<ExpressionNode> args = new ArrayList<>();

        List<jinjaParser.ExprContext> exprList = ctx.expr();
        for (int i = 1; i < exprList.size(); i++) {
            args.add((ExpressionNode) visit(exprList.get(i)));
        }
        int line = ctx.getStart().getLine();
        return new FunctionCall(function, args, line);
    }

    @Override
    public Node visitMemberAccessExpression(jinjaParser.MemberAccessExpressionContext ctx) {
        ExpressionNode object = (ExpressionNode) visit(ctx.expr());
        String memberName;
        if (ctx.primaryExpr() != null) {
            memberName = ctx.primaryExpr().getText();
        } else {
            memberName = ctx.JINJA_IDENT().getText();
        }
        int line = ctx.getStart().getLine();
        return new Member(object, memberName, line);
    }

    @Override
    public Node visitIndexAccessExpression(jinjaParser.IndexAccessExpressionContext ctx) {
        ExpressionNode target = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode index  = (ExpressionNode) visit(ctx.expr(1));
        int line = ctx.getStart().getLine();
        return new IndexAccess(target, index, line);
    }

    @Override
    public Node visitFilterExpression(jinjaParser.FilterExpressionContext ctx) {
        ExpressionNode input = (ExpressionNode) visit(ctx.expr(0));
        String filterName = ctx.JINJA_IDENT().getText();
        List<ExpressionNode> args = new ArrayList<>();
        // الـ args تبدأ من index 1
        List<jinjaParser.ExprContext> exprList = ctx.expr();
        for (int i = 1; i < exprList.size(); i++) {
            args.add((ExpressionNode) visit(exprList.get(i)));
        }
        int line = ctx.getStart().getLine();
        return new Filter(input, filterName, args, line);
    }


    @Override
    public Node visitBinaryOpExpression(jinjaParser.BinaryOpExpressionContext ctx) {
        ExpressionNode left  = (ExpressionNode) visit(ctx.expr(0));
        String op            = ctx.JINJA_OP().getText();
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));
        int line = ctx.getStart().getLine();
        return new BinaryNode(left, op, right, line);
    }


    @Override
    public Node visitTernaryExpression(jinjaParser.TernaryExpressionContext ctx) {
        ExpressionNode trueExp   = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode condition = (ExpressionNode) visit(ctx.condition);
        ExpressionNode falseExp  = (ExpressionNode) visit(ctx.elseExpr);
        int line = ctx.getStart().getLine();
        return new Ternary(trueExp, condition, falseExp, line);
    }

    //primaryExpr rules
    @Override
    public Node visitIdentifierPrimary(jinjaParser.IdentifierPrimaryContext ctx) {
        return new Identifier(ctx.JINJA_IDENT().getText(), ctx.getStart().getLine());
    }

    @Override
    public Node visitNumberPrimary(jinjaParser.NumberPrimaryContext ctx) {
        double value = Double.parseDouble(ctx.JINJA_NUMBER().getText());
        return new NumberLiteral(value, ctx.getStart().getLine());
    }

    @Override
    public Node visitStringPrimary(jinjaParser.StringPrimaryContext ctx) {
        String raw = ctx.JINJA_STRING().getText();
        String text = raw.substring(1, raw.length() - 1);
        return new StringNode(text, ctx.getStart().getLine());
    }

    @Override
    public Node visitIfKeywordPrimary(jinjaParser.IfKeywordPrimaryContext ctx) {
        return new Identifier(ctx.JINJA_KW_IF().getText(), ctx.getStart().getLine());
    }

    @Override
    public Node visitElseKeywordPrimary(jinjaParser.ElseKeywordPrimaryContext ctx) {
        return new Identifier(ctx.JINJA_KW_ELSE().getText(), ctx.getStart().getLine());
    }

    // 4. JINJA STATEMENTS

    @Override
    public Node visitIfStatementContent(jinjaParser.IfStatementContentContext ctx) {
        return visit(ctx.ifStatement());
    }

    @Override
    public Node visitForStatementContent(jinjaParser.ForStatementContentContext ctx) {
        return visit(ctx.forStatement());
    }

    @Override
    public Node visitElifStatementContent(jinjaParser.ElifStatementContentContext ctx) {
        return visit(ctx.elifStatement());
    }

    @Override
    public Node visitElseStatementContent(jinjaParser.ElseStatementContentContext ctx) {
        return visit(ctx.elseStatement());
    }

    @Override
    public Node visitEndifStatementContent(jinjaParser.EndifStatementContentContext ctx) {
        return visit(ctx.endifStatement());
    }

    @Override
    public Node visitEndforStatementContent(jinjaParser.EndforStatementContentContext ctx) {
        return visit(ctx.endforStatement());
    }

    @Override
    public Node visitIfStatementWrapper(jinjaParser.IfStatementWrapperContext ctx) {
        ExpressionNode condition = (ExpressionNode) visit(ctx.expr());
        int line = ctx.getStart().getLine();
        return new ifStatement(line, condition, null, null, null);
    }

    @Override
    public Node visitElifStatementWrapper(jinjaParser.ElifStatementWrapperContext ctx) {
        ExpressionNode condition = (ExpressionNode) visit(ctx.expr());
        int line = ctx.getStart().getLine();
        return new ElifBranch(condition, null, line);
    }

    @Override
    public Node visitElseStatementWrapper(jinjaParser.ElseStatementWrapperContext ctx) {
        int line = ctx.getStart().getLine();
        return new ElseBranch(line, null);
    }
    @Override
    public Node visitEndifStatementWrapper(jinjaParser.EndifStatementWrapperContext ctx) {
        return new EndifMarker(ctx.getStart().getLine());
    }

    @Override
    public Node visitEndforStatementWrapper(jinjaParser.EndforStatementWrapperContext ctx) {
        return new EndforMarker(ctx.getStart().getLine());
    }

    @Override
    public Node visitForStatementWrapper(jinjaParser.ForStatementWrapperContext ctx) {
        ForControl control = (ForControl) visit(ctx.forControl());
        int line = ctx.getStart().getLine();
        return new ForStatement(line, null, control);
    }


    @Override
    public Node visitForControlContent(jinjaParser.ForControlContentContext ctx) {
        List<ExpressionNode> iterVars = new ArrayList<>();
        for (jinjaParser.ExprContext e : ctx.iterVars) {
            iterVars.add((ExpressionNode) visit(e));
        }
        ExpressionNode iterable = (ExpressionNode) visit(ctx.iterable);
        int line = ctx.getStart().getLine();
        return new ForControl(line, iterVars, iterable);
    }

    // 5. HTML ELEMENTS

    @Override
    public Node visitVoidElementSpecial(jinjaParser.VoidElementSpecialContext ctx) {
        String tagName = ctx.voidTagName().getText();
        List<HtmlAttributeNode> attrs = buildAttributes(ctx.attribute());
        int line = ctx.getStart().getLine();
        return new HtmlElementNode(tagName, attrs, null, line);
    }


    @Override
    public Node visitPairedElement(jinjaParser.PairedElementContext ctx) {
        String tagName = ctx.open.getText();
        List<HtmlAttributeNode> attrs = buildAttributes(ctx.attribute());

        List<Node> flat = new ArrayList<>();
        for (jinjaParser.ContentContext contentCtx : ctx.content()) {
            Node child = visit(contentCtx);
            if (child != null) flat.add(child);
        }

        List<ContentNode> children = toContentList(buildStructuredList(flat));

        int line = ctx.getStart().getLine();
        return new HtmlElementNode(tagName, attrs, children, line);
    }


    @Override
    public Node visitSelfClosingElement(jinjaParser.SelfClosingElementContext ctx) {
        String tagName = ctx.tagName().getText();
        List<HtmlAttributeNode> attrs = buildAttributes(ctx.attribute());
        int line = ctx.getStart().getLine();
        return new HtmlElementNode(tagName, attrs, null, line);
    }


    @Override public Node visitTagBr(jinjaParser.TagBrContext ctx)           { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagHr(jinjaParser.TagHrContext ctx)           { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagImg(jinjaParser.TagImgContext ctx)         { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagInput(jinjaParser.TagInputContext ctx)     { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagMeta(jinjaParser.TagMetaContext ctx)       { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagLink(jinjaParser.TagLinkContext ctx)       { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagHtml(jinjaParser.TagHtmlContext ctx)       { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagHead(jinjaParser.TagHeadContext ctx)       { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagBody(jinjaParser.TagBodyContext ctx)       { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagDiv(jinjaParser.TagDivContext ctx)         { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagSpan(jinjaParser.TagSpanContext ctx)       { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagP(jinjaParser.TagPContext ctx)             { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagA(jinjaParser.TagAContext ctx)             { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagH(jinjaParser.TagHContext ctx)             { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagUl(jinjaParser.TagUlContext ctx)           { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagOl(jinjaParser.TagOlContext ctx)           { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagLi(jinjaParser.TagLiContext ctx)           { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagTable(jinjaParser.TagTableContext ctx)     { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagTr(jinjaParser.TagTrContext ctx)           { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagTd(jinjaParser.TagTdContext ctx)           { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagForm(jinjaParser.TagFormContext ctx)       { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagButton(jinjaParser.TagButtonContext ctx)   { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagScript(jinjaParser.TagScriptContext ctx)   { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagHeader(jinjaParser.TagHeaderContext ctx)   { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagFooter(jinjaParser.TagFooterContext ctx)   { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitTagSection(jinjaParser.TagSectionContext ctx) { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitGenericTag(jinjaParser.GenericTagContext ctx) { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }

    @Override public Node visitCloseTagLiteral(jinjaParser.CloseTagLiteralContext ctx)   { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }
    @Override public Node visitCloseTagFromOpen(jinjaParser.CloseTagFromOpenContext ctx) { return new Identifier(ctx.getText(), ctx.getStart().getLine()); }

    // --- Attributes ---


    @Override
    public Node visitRegularAttribute(jinjaParser.RegularAttributeContext ctx) {
        String attrName = ctx.getChild(0).getText();
        int line = ctx.getStart().getLine();

        if (ctx.attrValue() != null) {
            AttributeValueNode valueNode = (AttributeValueNode) visit(ctx.attrValue());
            return new HtmlAttributeNode(attrName, valueNode, line);
        } else {
            return new HtmlAttributeNode(attrName, new StringAttribute("", line), line);
        }
    }


    @Override
    public Node visitDynamicAttribute(jinjaParser.DynamicAttributeContext ctx) {
        JinjaExpression jinjaExpr = (JinjaExpression) visit(ctx.jinjaExpression());
        int line = ctx.getStart().getLine();
        ExpressionAttribute exprAttr = new ExpressionAttribute(jinjaExpr.expression, line);
        return new HtmlAttributeNode("", exprAttr, line);
    }


    @Override
    public Node visitDoubleQuotedValue(jinjaParser.DoubleQuotedValueContext ctx) {
        return buildAttrValue(ctx.ATTR_VALUE_TEXT_DOUBLE(), ctx.jinjaExpression(), ctx.getStart().getLine());
    }


    @Override
    public Node visitSingleQuotedValue(jinjaParser.SingleQuotedValueContext ctx) {
        return buildAttrValue(ctx.ATTR_VALUE_TEXT_SINGLE(), ctx.jinjaExpression(), ctx.getStart().getLine());
    }


    @Override
    public Node visitUnquotedValue(jinjaParser.UnquotedValueContext ctx) {
        return new StringAttribute(ctx.HTML_ATTRIBUTE_VALUE_UNQUOTED().getText(), ctx.getStart().getLine());
    }



    @Override
    public Node visitStyleBlockWrapper(jinjaParser.StyleBlockWrapperContext ctx) {
        List<CssRule> rules = new ArrayList<>();
        for (jinjaParser.CssContentContext cssCtx : ctx.cssContent()) {
            Node node = visit(cssCtx);
            if (node instanceof CssRule) {
                rules.add((CssRule) node);
            }
            // الـ jinja nodes داخل CSS بتتجاهل حالياً — مقبول إذا ما بدك تعالجها
        }
        int line = ctx.getStart().getLine();
        return new StyleBlock(rules, line);
    }

    //cssContent dispatcher

    @Override
    public Node visitCssRuleContent(jinjaParser.CssRuleContentContext ctx) {
        return visit(ctx.cssRule());
    }

    @Override
    public Node visitCssJinjaStatementContent(jinjaParser.CssJinjaStatementContentContext ctx) {
        return visit(ctx.jinjaStatement());
    }

    @Override
    public Node visitCssJinjaExpressionContent(jinjaParser.CssJinjaExpressionContentContext ctx) {
        return visit(ctx.jinjaExpression());
    }

    @Override
    public Node visitCssSemicolon(jinjaParser.CssSemicolonContext ctx) {
        return null;
    }

    @Override
    public Node visitStandardCssRule(jinjaParser.StandardCssRuleContext ctx) {
        String selector = buildTextWithSpacing(ctx.cssSelectorList());
        List<CssDeclaration> declarations = new ArrayList<>();

        if (ctx.cssDeclarationList() != null) {
            jinjaParser.CssDeclarationListRuleContext listCtx =
                    (jinjaParser.CssDeclarationListRuleContext) ctx.cssDeclarationList();

            for (jinjaParser.DeclarationContext declCtx :
                    listCtx.getRuleContexts(jinjaParser.DeclarationContext.class)) {
                Node node = visit(declCtx);
                if (node instanceof CssDeclaration) {
                    declarations.add((CssDeclaration) node);
                }
            }
        }

        int line = ctx.getStart().getLine();
        return new CssRule(selector, declarations, line);
    }

    @Override
    public Node visitCssSelectorListRule(jinjaParser.CssSelectorListRuleContext ctx) {
        return new Identifier(ctx.getText(), ctx.getStart().getLine());
    }


    @Override
    public Node visitCssSelectorWrapper(jinjaParser.CssSelectorWrapperContext ctx) {
        StringBuilder sb = new StringBuilder();
        int prevStopIndex = -1;

        for (org.antlr.v4.runtime.tree.ParseTree child : ctx.children) {
            if (child instanceof org.antlr.v4.runtime.tree.TerminalNode) {
                org.antlr.v4.runtime.tree.TerminalNode t =
                        (org.antlr.v4.runtime.tree.TerminalNode) child;
                int start = t.getSymbol().getStartIndex();

                if (prevStopIndex != -1 && start > prevStopIndex + 1) {
                    sb.append(" ");
                }
                sb.append(t.getText());
                prevStopIndex = t.getSymbol().getStopIndex();
            }
        }

        return new Identifier(sb.toString(), ctx.getStart().getLine());
    }
    @Override
    public Node visitCssDeclarationListRule(jinjaParser.CssDeclarationListRuleContext ctx) {
        return null;
    }

    @Override
    public Node visitCssDeclaration(jinjaParser.CssDeclarationContext ctx) {
        String property = ctx.getChild(0).getText();
        List<CssValueNode> values = new ArrayList<>();

        if (ctx.cssValueList() != null) {
            values = buildCssValues(ctx.cssValueList());
        }

        int line = ctx.getStart().getLine();
        return new CssDeclaration(property, values, line);
    }

    //cssValue nodes

    @Override
    public Node visitCssValueLiteral(jinjaParser.CssValueLiteralContext ctx) {
        return new CssLiteral(ctx.CSS_VALUE().getText(), ctx.getStart().getLine());
    }

    @Override
    public Node visitCssValueProperty(jinjaParser.CssValuePropertyContext ctx) {
        return new CssLiteral(ctx.CSS_PROPERTY().getText(), ctx.getStart().getLine());
    }

    @Override
    public Node visitCssValueTypeSelector(jinjaParser.CssValueTypeSelectorContext ctx) {
        return new CssLiteral(ctx.CSS_TYPE_SELECTOR().getText(), ctx.getStart().getLine());
    }

    @Override
    public Node visitCssValueIdSelector(jinjaParser.CssValueIdSelectorContext ctx) {
        return new CssLiteral(ctx.CSS_ID_SELECTOR().getText(), ctx.getStart().getLine());
    }


    @Override
    public Node visitCssValuePseudoClass(jinjaParser.CssValuePseudoClassContext ctx) {
        String raw = ctx.CSS_PSEUDO_CLASS().getText(); // مثلاً ":flex"
        String cleaned = raw.startsWith(":") ? raw.substring(1) : raw;
        return new CssLiteral(cleaned, ctx.getStart().getLine());
    }

    @Override
    public Node visitCssValueJinjaExpression(jinjaParser.CssValueJinjaExpressionContext ctx) {
        JinjaExpression jinjaExpr = (JinjaExpression) visit(ctx.jinjaExpression());
        int line = ctx.getStart().getLine();
        return new CssExpression(jinjaExpr.expression, line);
    }

    @Override
    public Node visitCssValueListRule(jinjaParser.CssValueListRuleContext ctx) {
        return null;
    }



    private List<HtmlAttributeNode> buildAttributes(List<jinjaParser.AttributeContext> attrCtxs) {
        List<HtmlAttributeNode> attrs = new ArrayList<>();
        for (jinjaParser.AttributeContext attrCtx : attrCtxs) {
            Node node = visit(attrCtx);
            if (node instanceof HtmlAttributeNode) {
                attrs.add((HtmlAttributeNode) node);
            }
        }
        return attrs;
    }

    private AttributeValueNode buildAttrValue(
            List<? extends org.antlr.v4.runtime.tree.TerminalNode> textTokens,
            List<jinjaParser.JinjaExpressionContext> exprCtxs,
            int line) {

        if (exprCtxs.size() == 1 && textTokens.isEmpty()) {
            JinjaExpression jinjaExpr = (JinjaExpression) visit(exprCtxs.get(0));
            return new ExpressionAttribute(jinjaExpr.expression, line);
        }

        if (exprCtxs.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (org.antlr.v4.runtime.tree.TerminalNode t : textTokens) {
                sb.append(t.getText());
            }
            return new StringAttribute(sb.toString(), line);
        }

        StringBuilder sb = new StringBuilder();
        for (org.antlr.v4.runtime.tree.TerminalNode t : textTokens) {
            sb.append(t.getText());
        }
        for (jinjaParser.JinjaExpressionContext e : exprCtxs) {
            sb.append(e.getText());
        }
        return new StringAttribute(sb.toString(), line);
    }



    private List<CssValueNode> buildCssValues(jinjaParser.CssValueListContext ctx) {
        List<CssValueNode> values = new ArrayList<>();
        if (ctx == null || ctx.children == null) return values;

        boolean commaSeen = false;

        for (org.antlr.v4.runtime.tree.ParseTree child : ctx.children) {

            // فاصلة CSS_COMMA -> علّمي إنو القيمة الجاية مسبوقة بفاصلة
            if (child instanceof org.antlr.v4.runtime.tree.TerminalNode) {
                org.antlr.v4.runtime.tree.TerminalNode t =
                        (org.antlr.v4.runtime.tree.TerminalNode) child;
                if (t.getSymbol().getType() == jinjaParser.CSS_COMMA) {
                    commaSeen = true;
                }
                continue;
            }

            // خلاف هيك، هاد لازم يكون cssValue context
            Node node = visit(child);
            if (node instanceof CssValueNode) {
                CssValueNode valueNode = (CssValueNode) node;
                valueNode.precededByComma = commaSeen;
                values.add(valueNode);
                commaSeen = false; // reset بعد كل قيمة
            }
        }

        return values;
    }


    private void collectTokens(org.antlr.v4.runtime.tree.ParseTree tree,
                               List<org.antlr.v4.runtime.Token> tokens) {
        if (tree instanceof org.antlr.v4.runtime.tree.TerminalNode) {
            tokens.add(((org.antlr.v4.runtime.tree.TerminalNode) tree).getSymbol());
        } else {
            for (int i = 0; i < tree.getChildCount(); i++) {
                collectTokens(tree.getChild(i), tokens);
            }
        }
    }

    private String buildTextWithSpacing(org.antlr.v4.runtime.tree.ParseTree tree) {
        List<org.antlr.v4.runtime.Token> tokens = new ArrayList<>();
        collectTokens(tree, tokens);

        StringBuilder sb = new StringBuilder();
        int prevStopIndex = -1;
        for (org.antlr.v4.runtime.Token t : tokens) {
            if (prevStopIndex != -1 && t.getStartIndex() > prevStopIndex + 1) {
                sb.append(" ");
            }
            sb.append(t.getText());
            prevStopIndex = t.getStopIndex();
        }
        return sb.toString();
    }
}