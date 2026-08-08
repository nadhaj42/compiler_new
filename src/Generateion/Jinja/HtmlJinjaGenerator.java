package Generateion.Jinja;

import AST.html_css_jinja.*;
import AST.html_css_jinja.html.*;
import AST.html_css_jinja.jinja.*;
import AST.html_css_jinja.css.*;
import AST.html_css_jinja.Expression.*;
import Generation.Python.Environment;

import java.util.*;

public class HtmlJinjaGenerator {

    private final Environment globalEnv;
    private final StringBuilder logBuilder = new StringBuilder();

    private static final Set<String> VOID_ELEMENTS = new HashSet<>(Arrays.asList(
            "area", "base", "br", "col", "embed", "hr", "img", "input",
            "link", "meta", "param", "source", "track", "wbr"
    ));

    public HtmlJinjaGenerator(Environment globalEnv) {
        this.globalEnv = globalEnv;
    }

    public String generate(Node root) {
        logBuilder.setLength(0); // إعادة تعيين السجل
        logBuilder.append("--- [GENERATOR LOG START] ---\n");
        StringBuilder output = new StringBuilder();
        generateNode(root, globalEnv, output);
        logBuilder.append("--- [GENERATOR LOG END] ---\n");
        return output.toString();
    }

    public String getGenerationLog() {
        return logBuilder.toString();
    }

    private void generateNode(Node node, Environment env, StringBuilder sb) {
        if (node == null) return;

        // 1. Program Node
        if (node instanceof Program) {
            Program p = (Program) node;
            if (p.statements != null) {
                for (Node child : p.statements) {
                    generateNode(child, env, sb);
                }
            }
        }
        else if (node instanceof HtmlTextNode) {
            sb.append(((HtmlTextNode) node).text);
        }
        else if (node instanceof HtmlElementNode) {
            generateHtmlElement((HtmlElementNode) node, env, sb);
        }
        else if (node instanceof JinjaExpression) {
            JinjaExpression exprNode = (JinjaExpression) node;
            Object val = evalExpression(exprNode.expression, env);
            logBuilder.append("  [Jinja Expr] Evaluated '")
                    .append(exprNode.expression != null ? exprNode.expression.toString() : "expr")
                    .append("' -> '").append(val).append("'\n");
            sb.append(val != null ? val.toString() : "");
        }
        else if (node instanceof ifStatement) {
            generateIf((ifStatement) node, env, sb);
        }
        else if (node instanceof ForStatement) {
            generateFor((ForStatement) node, env, sb);
        }
        else if (node instanceof StyleBlock) {
            generateStyleBlock((StyleBlock) node, env, sb);
        }
    }

    private void generateHtmlElement(HtmlElementNode elem, Environment env, StringBuilder sb) {
        String tag = elem.tagName != null ? elem.tagName.toLowerCase() : "";
        sb.append("<").append(elem.tagName);

        if (elem.attributes != null) {
            for (HtmlAttributeNode attr : elem.attributes) {
                sb.append(" ");
                generateAttribute(attr, env, sb);
            }
        }

        if (VOID_ELEMENTS.contains(tag) || elem.children == null) {
            sb.append("/>");
            return;
        }

        sb.append(">");

        for (ContentNode child : elem.children) {
            generateNode(child, env, sb);
        }

        sb.append("</").append(elem.tagName).append(">");
    }

    private void generateAttribute(HtmlAttributeNode attr, Environment env, StringBuilder sb) {
        if (attr.name == null || attr.name.isEmpty()) {
            if (attr.value instanceof ExpressionAttribute) {
                Object val = evalExpression(((ExpressionAttribute) attr.value).expression, env);
                sb.append(val != null ? val.toString() : "");
            }
            return;
        }

        sb.append(attr.name);
        if (attr.value != null) {
            sb.append("=\"");
            if (attr.value instanceof StringAttribute) {
                String strValue = ((StringAttribute) attr.value).value;
                if (strValue != null && strValue.contains("{{")) {
                    strValue = interpolateTemplateString(strValue, env);
                }
                if ("href".equalsIgnoreCase(attr.name)) {
                    String resolved = resolveStaticLink(strValue);
                    if (!resolved.equals(strValue)) {
                        logBuilder.append("  [Link Resolution] ").append(strValue).append(" -> ").append(resolved).append("\n");
                    }
                    strValue = resolved;
                }
                sb.append(strValue);
            } else if (attr.value instanceof ExpressionAttribute) {
                Object val = evalExpression(((ExpressionAttribute) attr.value).expression, env);
                sb.append(val != null ? val.toString() : "");
            }
            sb.append("\"");
        }
    }

    private String interpolateTemplateString(String text, Environment env) {
        if (text == null) return "";

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\{\\{\\s*([^\\}]+)\\s*\\}\\}");
        java.util.regex.Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String exprText = matcher.group(1).trim();
            Object evaluatedValue = resolveNestedProperty(exprText, env);
            String replacement = evaluatedValue != null ? evaluatedValue.toString() : "";
            matcher.appendReplacement(result, java.util.regex.Matcher.quoteReplacement(replacement));
            logBuilder.append("  [Interpolate] {{ ").append(exprText).append(" }} -> ").append(replacement).append("\n");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    private Object resolveNestedProperty(String exprText, Environment env) {
        if (exprText.contains(".")) {
            String[] parts = exprText.split("\\.");
            Object obj = env.get(parts[0]);
            if (obj instanceof Map) {
                return ((Map<?, ?>) obj).get(parts[1]);
            }
        } else {
            return env.get(exprText);
        }
        return null;
    }

    // --- Jinja If Control ---
    private void generateIf(ifStatement ifNode, Environment env, StringBuilder sb) {
        Object cond = evalExpression(ifNode.condition, env);
        boolean isTrue = isTruthy(cond);
        logBuilder.append("  [Jinja If] Condition evaluated to: ").append(isTrue).append("\n");

        if (isTrue) {
            if (ifNode.thenBranch != null) {
                for (ContentNode n : ifNode.thenBranch) generateNode(n, env, sb);
            }
            return;
        }

        if (ifNode.elifBranch != null) {
            for (ElifBranch elif : ifNode.elifBranch) {
                Object elifCond = evalExpression(elif.expr, env);
                if (isTruthy(elifCond)) {
                    logBuilder.append("  [Jinja Elif] Branch taken.\n");
                    if (elif.statements != null) {
                        for (ContentNode n : elif.statements) generateNode(n, env, sb);
                    }
                    return;
                }
            }
        }

        if (ifNode.elseBranch != null && ifNode.elseBranch.statements != null) {
            logBuilder.append("  [Jinja Else] Branch taken.\n");
            for (ContentNode n : ifNode.elseBranch.statements) {
                generateNode(n, env, sb);
            }
        }
    }

    // --- Jinja For Loop ---
    private void generateFor(ForStatement forNode, Environment env, StringBuilder sb) {
        if (forNode.control == null) return;

        Object iterable = evalExpression(forNode.control.iterable, env);
        Iterable<?> list = toIterable(iterable);
        String varName = getIterVarName(forNode.control.iterables);

        int count = 0;
        for (Object item : list) {
            count++;
            Environment loopEnv = new Environment(env);
            if (varName != null) {
                loopEnv.define(varName, item);
            }

            if (forNode.body != null) {
                for (ContentNode n : forNode.body) {
                    generateNode(n, loopEnv, sb);
                }
            }
        }
        logBuilder.append("  [Jinja For] Loop executed ").append(count).append(" iteration(s).\n");
    }

    // --- CSS Block ---
    private void generateStyleBlock(StyleBlock style, Environment env, StringBuilder sb) {
        sb.append("<style>\n");
        if (style.rules != null) {
            for (CssRule rule : style.rules) {
                String selector = formatCssSelector(rule.selector);
                sb.append(selector).append(" {\n");

                if (rule.declarations != null) {
                    for (CssDeclaration decl : rule.declarations) {
                        sb.append("  ").append(decl.property).append(": ");
                        if (decl.values != null) {
                            for (int i = 0; i < decl.values.size(); i++) {
                                CssValueNode val = decl.values.get(i);
                                String valStr = "";
                                if (val instanceof CssLiteral) {
                                    valStr = ((CssLiteral) val).text;
                                } else if (val instanceof CssExpression) {
                                    Object res = evalExpression(((CssExpression) val).expression, env);
                                    valStr = res != null ? res.toString() : "";
                                }

                                if (i > 0) {
                                    sb.append(val.precededByComma ? ", " : " ");
                                }
                                sb.append(valStr);
                            }
                        }
                        sb.append(";\n");
                    }
                }
                sb.append("}\n");
            }
        }
        sb.append("</style>");
    }

    private String formatCssSelector(String selector) {
        return selector == null ? "" : selector.trim();
    }

    private Object evalExpression(ExpressionNode expr, Environment env) {
        if (expr == null) return null;

        if (expr instanceof Identifier) {
            String name = ((Identifier) expr).text;
            return env.get(name);
        } else if (expr instanceof StringNode) {
            return ((StringNode) expr).text;
        } else if (expr instanceof NumberLiteral) {
            return ((NumberLiteral) expr).text;
        } else if (expr instanceof Member) {
            Member m = (Member) expr;
            Object obj = evalExpression(m.object, env);
            return getMemberValue(obj, m.member);
        } else if (expr instanceof IndexAccess) {
            IndexAccess ia = (IndexAccess) expr;
            Object target = evalExpression(ia.target, env);
            Object idx = evalExpression(ia.index, env);
            return getIndexValue(target, idx);
        } else if (expr instanceof BinaryNode) {
            BinaryNode bn = (BinaryNode) expr;
            Object left = evalExpression(bn.left, env);
            Object right = evalExpression(bn.right, env);
            return evalBinary(left, bn.op, right);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private Object getMemberValue(Object obj, String member) {
        if (obj instanceof Map) {
            return ((Map<Object, Object>) obj).get(member);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private Object getIndexValue(Object obj, Object idx) {
        if (obj instanceof List) {
            int i = idx instanceof Number ? ((Number) idx).intValue() : 0;
            List<Object> list = (List<Object>) obj;
            return (i >= 0 && i < list.size()) ? list.get(i) : null;
        } else if (obj instanceof Map) {
            return ((Map<Object, Object>) obj).get(idx);
        }
        return null;
    }

    private Object evalBinary(Object left, String op, Object right) {
        if ("==".equals(op)) return Objects.equals(left, right);
        if ("!=".equals(op)) return !Objects.equals(left, right);
        if ("+".equals(op)) return String.valueOf(left) + String.valueOf(right);
        return null;
    }

    private boolean isTruthy(Object v) {
        if (v == null) return false;
        if (v instanceof Boolean) return (Boolean) v;
        if (v instanceof Number) return ((Number) v).doubleValue() != 0;
        if (v instanceof String) return !((String) v).isEmpty();
        if (v instanceof Collection) return !((Collection<?>) v).isEmpty();
        return true;
    }

    @SuppressWarnings("unchecked")
    private Iterable<?> toIterable(Object val) {
        if (val instanceof Iterable) return (Iterable<?>) val;
        if (val instanceof Map) return ((Map<?, ?>) val).keySet();
        return Collections.emptyList();
    }

    private String getIterVarName(List<ExpressionNode> iterVars) {
        if (iterVars != null && !iterVars.isEmpty()) {
            ExpressionNode first = iterVars.get(0);
            if (first instanceof Identifier) return ((Identifier) first).text;
        }
        return null;
    }

    public String resolveStaticLink(String route) {
        if (route == null) return "#";

        if (route.equals("/") || route.equals("/view")) {
            return "index.html";
        } else if (route.startsWith("/details/")) {
            String id = route.substring("/details/".length());
            return "product_details" + id + ".html";
        } else if (route.startsWith("/details")) {
            return "product_details.html";
        } else if (route.equals("/add")) {
            return "add_product.html";
        } else if (route.startsWith("/edit")) {
            return "edit_product.html";
        } else if (route.startsWith("/delete/")) {
            String id = route.substring("/delete/".length());
            return "delete_product" + id + ".html";
        } else if (route.startsWith("/delete")) {
            return "delete_product.html";
        }

        return route;
    }
}