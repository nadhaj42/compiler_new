package Visitor.html_css_jinja;

import AST.html_css_jinja.Node;
import AST.html_css_jinja.Program;
import AST.html_css_jinja.css.CssDeclaration;
import AST.html_css_jinja.css.CssQualifiedRule;
import AST.html_css_jinja.css.CssStyle;
import AST.html_css_jinja.html.Attribute;
import AST.html_css_jinja.html.Element;
import AST.html_css_jinja.html.PairedElement;
import AST.html_css_jinja.jinja.JinjaExpression;
import AST.html_css_jinja.jinja.JinjaIfStmt;
import SymbolTable.htmlCssJInja.SymbolTable;

public class SymbolTableVisitor {
    private final SymbolTable table = new SymbolTable();

    public SymbolTable build(Program program) {
        visit(program);
        return table;
    }

    private void visit(Node node) {
        if (node == null) return;

        if (node instanceof CssStyle style) {
            table.enterScope("css_block_" + getLineFromNode(style));
            if (style.statements != null) {
                for (Node stmt : style.statements) visit(stmt);
            }
            table.exitScope();
        }
        else if (node instanceof CssQualifiedRule cssRule) {
            if (cssRule.selectors != null) {
                for (Node sel : cssRule.selectors) {
                    table.define(clean(sel), "CSS_SELECTOR", getLineFromNode(cssRule));
                }
            }
            table.enterScope("css_body_" + getLineFromNode(cssRule));
            if (cssRule.body != null) {
                for (Node decl : cssRule.body) visit(decl);
            }
            table.exitScope();
        }
        else if (node instanceof CssDeclaration decl) {
            table.define(clean(decl.property), "CSS_PROPERTY", getLineFromNode(decl));
        }

        else if (node instanceof JinjaExpression je) {
            table.define(clean(je.expression), "JINJA_VAR", getLineFromNode(je));
        }
        else if (node instanceof JinjaIfStmt ifStmt) {
            table.define("if (" + ifStmt.condition + ")", "JINJA_IF", getLineFromNode(ifStmt));
            table.enterScope("jinja_if_line_" + getLineFromNode(ifStmt));

            if (ifStmt.thenBranch != null) for (Node n : ifStmt.thenBranch) visit(n);
            if (ifStmt.elifBranches != null) for (Node n : ifStmt.elifBranches) visit(n);
            if (ifStmt.elseBranch != null) for (Node n : ifStmt.elseBranch) visit(n);

            table.exitScope();
        }

        else if (node instanceof Element e) {
            String tagName = clean(e.tag);
            table.define(tagName, "HTML_TAG", getLineFromNode(e));

            // معالجة الـ Attributes (class, id, etc.)
            if (e.attributes != null) {
                for (Attribute attr : e.attributes) {
                    table.define(clean(attr.name), "HTML_ATTR", getLineFromNode(attr));
                }
            }

            if (node instanceof PairedElement pe && pe.chidren != null) {
                table.enterScope("html_" + tagName + "_" + getLineFromNode(e));
                for (Node child : pe.chidren) visit(child);
                table.exitScope();
            }
        }

        // --- 4. جذر البرنامج ---
        else if (node instanceof Program p) {
            if (p.statements != null) {
                for (Node n : p.statements) visit(n);
            }
        }
    }

    private String clean(Object obj) {
        if (obj == null) return "unknown";
        String s = obj.toString();
        if (s.contains("{")) s = s.substring(0, s.indexOf("{")).trim();
        return s.replaceAll("\\(\\d+\\)", "")
                .replace("CssRawText", "")
                .replace("TextContent", "")
                .replace("JinjaExpression", "")
                .trim();
    }

    private int getLineFromNode(Node node) {
        if (node == null) return 0;
        String str = node.toString();
        if (str.contains("(") && str.contains(")")) {
            try {
                return Integer.parseInt(str.substring(str.indexOf("(") + 1, str.indexOf(")")));
            } catch (Exception ex) { return 0; }
        }
        return 0;
    }
}