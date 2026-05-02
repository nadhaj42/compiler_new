package Visitor.html_css_jinja;//package Visitor.html_css_jinja;
//
//
//
//import AST.html_css_jinja.*;
//import AST.html_css_jinja.html.*;
//import AST.html_css_jinja.jinja.*;
//import AST.html_css_jinja.css.*;
//import antlr2.antlr2.*;
//import java.util.*;
//
//public class visitor extends jinjaParserBaseVisitor<Node> {
//
//
//    @Override
//    public Node visitProg(jinjaParser.ProgContext ctx) {
//        List<Node> nodes = new ArrayList<>();
//
//        for (var c : ctx.content()) {
//            Node n = visit(c);
//            if (n != null) nodes.add(n);
//        }
//
//        return new Program(ctx.getStart().getLine(), nodes);
//    }
//
//    @Override
//    public Node visitHtmlElementContent(jinjaParser.HtmlElementContentContext ctx) {
//        return visit(ctx.htmlElement());
//    }
//
//    @Override
//    public Node visitJinjaStatementContent(jinjaParser.JinjaStatementContentContext ctx) {
//        return visit(ctx.jinjaStatement());
//    }
//
//    @Override
//    public Node visitJinjaExpressionContent(jinjaParser.JinjaExpressionContentContext ctx) {
//        return visit(ctx.jinjaExpression());
//    }
//
//    @Override
//    public Node visitStyleBlockContent(jinjaParser.StyleBlockContentContext ctx) {
//        return visit(ctx.styleBlock());
//    }
//
//    @Override
//    public Node visitTextContent(jinjaParser.TextContentContext ctx) {
//        return visit(ctx.htmlText());
//    }
//
//
//    @Override
//    public Node visitHtmlTextContent(jinjaParser.HtmlTextContentContext ctx) {
//        return new TextContent(ctx.getStart().getLine(), ctx.getText());
//    }
//
//    @Override
//    public Node visitRegularAttribute(jinjaParser.RegularAttributeContext ctx) {
//        // 1. تحويل النص إلى عقدة TextContent بدلاً من String خام
//        String nameText = ctx.getChild(0).getText();
//        Node nameNode = new TextContent(ctx.getStart().getLine(), nameText);
//
//        List<Node> values = null;
//        if (ctx.attrValue() != null) {
//            values = new ArrayList<>();
//            for (int i = 0; i < ctx.attrValue().getChildCount(); i++) {
//                var child = ctx.attrValue().getChild(i);
//
//                if (child instanceof jinjaParser.JinjaExpressionContext) {
//                    values.add(visit(child));
//                } else {
//                    String t = child.getText();
//                    if (!t.equals("\"") && !t.equals("'")) {
//                        values.add(new TextContent(ctx.getStart().getLine(), t));
//                    }
//                }
//            }
//        }
//
//        return new Attribute(ctx.getStart().getLine(), nameNode, values);
//    }
//
//
//    @Override
//    public Node visitDynamicAttribute(jinjaParser.DynamicAttributeContext ctx) {
//        return visit(ctx.jinjaExpression());
//    }
//
//    @Override
//    public Node visitPairedElement(jinjaParser.PairedElementContext ctx) {
//        String tag = ctx.open.getText();
//
//        List<Attribute> attributes = new ArrayList<>();
//        for (var attr : ctx.attribute())
//            attributes.add((Attribute) visit(attr));
//
//        List<Node> children = new ArrayList<>();
//        for (var c : ctx.content()) {
//            Node n = visit(c);
//            if (n != null) children.add(n);
//        }
//
//        return new PairedElement(ctx.getStart().getLine(), tag, attributes, children);
//    }
//
//    @Override
//    public Node visitSelfClosingElement(jinjaParser.SelfClosingElementContext ctx) {
//        String tag = ctx.HTML_TAG_NAME().getText();
//
//        List<Attribute> attributes = new ArrayList<>();
//        for (var attr : ctx.attribute())
//            attributes.add((Attribute) visit(attr));
//
//        return new SelfClosingElement(ctx.getStart().getLine(), tag, attributes);
//    }
//
//    @Override
//    public Node visitVoidElement(jinjaParser.VoidElementContext ctx) {
//        String tag = ctx.HTML_TAG_NAME().getText();
//
//        List<Attribute> attributes = new ArrayList<>();
//        for (var attr : ctx.attribute())
//            attributes.add((Attribute) visit(attr));
//
//        return new SelfClosingElement(ctx.getStart().getLine(), tag, attributes);
//    }
//
//
//    @Override
//    public Node visitJinjaExpressionWrapper(jinjaParser.JinjaExpressionWrapperContext ctx) {
//        Node expressionNode = visit(ctx.expr());
//
//        return new JinjaExpression(ctx.getStart().getLine(), expressionNode);
//    }
//
//
//
//    @Override
//    public Node visitPrimaryExpression(jinjaParser.PrimaryExpressionContext ctx) {
//        return new JinjaRawStatement(ctx.getStart().getLine(), ctx.getText());
//    }
//
//
//
//    @Override
//    public Node visitBinaryOpExpression(jinjaParser.BinaryOpExpressionContext ctx) {
//        return new JinjaRawStatement(ctx.getStart().getLine(), ctx.getText());
//    }
//
//    @Override
//    public Node visitFunctionCallExpression(jinjaParser.FunctionCallExpressionContext ctx) {
//        return new JinjaRawStatement(ctx.getStart().getLine(), ctx.getText());
//    }
//
//    @Override
//    public Node visitMemberAccessExpression(jinjaParser.MemberAccessExpressionContext ctx) {
//        return new JinjaRawStatement(ctx.getStart().getLine(), ctx.getText());
//    }
//
//    @Override
//    public Node visitIndexAccessExpression(jinjaParser.IndexAccessExpressionContext ctx) {
//        return new JinjaRawStatement(ctx.getStart().getLine(), ctx.getText());
//    }
//
//    @Override
//    public Node visitFilterExpression(jinjaParser.FilterExpressionContext ctx) {
//        return new JinjaRawStatement(ctx.getStart().getLine(), ctx.getText());
//    }
//
//    @Override
//    public Node visitTernaryExpression(jinjaParser.TernaryExpressionContext ctx) {
//        return new JinjaRawStatement(ctx.getStart().getLine(), ctx.getText());
//    }
//
//
//    @Override
//    public Node visitIfStatementWrapper(jinjaParser.IfStatementWrapperContext ctx) {
//        String conditionText = ctx.expr().getText();
//
//        List<Node> thenBody = new ArrayList<>();
//        List<Node> elseBody = new ArrayList<>();
//        List<Node> elifBranches = new ArrayList<>();
//
//        return new JinjaIfStmt(
//                ctx.getStart().getLine(),
//                conditionText,
//                thenBody,
//                elseBody,
//                elifBranches
//        );
//    }
//
//    @Override
//    public Node visitForStatementWrapper(jinjaParser.ForStatementWrapperContext ctx) {
//        jinjaParser.ForControlContentContext fc = (jinjaParser.ForControlContentContext) ctx.forControl();
//
//        List<Node> varNodes = new ArrayList<>();
//        for (var v : fc.iterVars) {
//            varNodes.add(new JinjaRawStatement(v.getStart().getLine(), v.getText()));
//        }
//
//        Node iterableNode = visit(fc.iterable);
//
//        List<Node> body = new ArrayList<>();
//
//        return new JinjaForStmt(
//                ctx.getStart().getLine(),
//                varNodes,
//                iterableNode,
//                body
//        );
//    }
//
//
//    @Override
//    public Node visitElseStatementWrapper(jinjaParser.ElseStatementWrapperContext ctx) {
//        return new JinjaRawStatement(ctx.getStart().getLine(), ctx.getText());
//    }
//
//    @Override
//    public Node visitEndifStatementWrapper(jinjaParser.EndifStatementWrapperContext ctx) {
//        return new JinjaRawStatement(ctx.getStart().getLine(), ctx.getText());
//    }
//
//    @Override
//    public Node visitEndforStatementWrapper(jinjaParser.EndforStatementWrapperContext ctx) {
//        return new JinjaRawStatement(ctx.getStart().getLine(), ctx.getText());
//    }
//
//
//    @Override
//    public Node visitStyleBlockWrapper(jinjaParser.StyleBlockWrapperContext ctx) {
//        List<Node> statements = new ArrayList<>();
//
//        for (var c : ctx.cssContent()) {
//            Node n = visit(c);
//            if (n != null) {
//                statements.add(n);
//            }
//        }
//
//        return new CssStyle(ctx.getStart().getLine(), statements);
//    }
//
//    @Override
//    public Node visitStandardCssRule(jinjaParser.StandardCssRuleContext ctx) {
//        List<Node> selectors = new ArrayList<>();
//        String selectorText = ctx.cssSelectorList().getText();
//        selectors.add(new CssRawText(ctx.cssSelectorList().getStart().getLine(), selectorText));
//
//        List<Node> body = new ArrayList<>();
//        for (var d : ctx.declaration()) {
//            Node declarationNode = visit(d);
//            if (declarationNode != null) {
//                body.add(declarationNode);
//            }
//        }
//
//        return new CssQualifiedRule(ctx.getStart().getLine(), selectors, body);
//    }
//
//    @Override
//    public Node visitCssAtRuleWrapper(jinjaParser.CssAtRuleWrapperContext ctx) {
//        return new CssAtRule(ctx.getStart().getLine(), ctx.CSS_AT_RULE().getText(), null, null);
//    }
//
//@Override
//public Node visitCssDeclaration(jinjaParser.CssDeclarationContext ctx) {
//    Node propertyNameNode = new CssRawText(ctx.getStart().getLine(), ctx.getChild(0).getText());
//
//    List<Node> valuesList = new ArrayList<>();
//
//    Node valueNode = visit(ctx.cssValueList());
//    if (valueNode != null) {
//        valuesList.add(valueNode);
//    }
//
//    return new CssDeclaration(ctx.getStart().getLine(), propertyNameNode, valuesList);
//}
//
//    @Override
//    public Node visitCssValueLiteral(jinjaParser.CssValueLiteralContext ctx) {
//        return new CssValue(ctx.getStart().getLine(), ctx.getText());
//    }
//    @Override
//    public Node visitCssValueTypeSelector(jinjaParser.CssValueTypeSelectorContext ctx) {
//        return new CssValue(ctx.getStart().getLine(), ctx.getText());
//    }
//
//}