package Semantic.htmlCssJInja;

import AST.html_css_jinja.*;
import AST.html_css_jinja.html.*;
import AST.html_css_jinja.jinja.*;
import AST.html_css_jinja.css.*;
import AST.html_css_jinja.Expression.*;

import java.util.ArrayList;
import java.util.List;

/**
 * يمشي على شجرة AST الجاهزة (بعد ما الـ Visitor الأساسي بناها)
 * ويعمّر الـ Symbol Table: متغيرات، متغيرات for-loop، دوال (FunctionCall)، فلاتر (Filter).
 * بيحترم الـ scoping: كل ForStatement بيفتح scope جديد لمتغيرات حلقته،
 * وبيسكّر هاد الـ scope عند الخروج من جسم الحلقة.
 */
public class SymbolTableBuilder {

    public SymbolTable table;
    public List<Scope> allScopes; // لتتبع كل الـ scopes المتفرعة بترتيب إنشائها (مفيد للطباعة الكاملة)
    private int forCounter = 0;   // عدّاد لتوليد أسماء واضحة لكل scope من for (For#1, For#2 ...)

    public SymbolTableBuilder() {
        this.table = new SymbolTable();
        this.allScopes = new ArrayList<>();
        this.allScopes.add(table.globalScope);
    }

    // نقطة الدخول الرئيسية: استدعها مع جذر الشجرة (Program)
    public void build(Program program) {
        if (program.statements == null) return;
        for (Node node : program.statements) {
            visit(node);
        }
    }

    // التوزيع العام حسب نوع العقدة (polymorphism يدوي لأن AST نفسه ما فيه accept/visitor pattern مدمج)
    private void visit(Node node) {
        if (node == null) return;

        if (node instanceof ifStatement) {
            visitIfStatement((ifStatement) node);
        } else if (node instanceof ForStatement) {
            visitForStatement((ForStatement) node);
        } else if (node instanceof HtmlElementNode) {
            visitHtmlElementNode((HtmlElementNode) node);
        } else if (node instanceof HtmlAttributeNode) {
            visitHtmlAttributeNode((HtmlAttributeNode) node);
        } else if (node instanceof JinjaExpression) {
            visitExpression(((JinjaExpression) node).expression);
        } else if (node instanceof StyleBlock) {
            visitStyleBlock((StyleBlock) node);
        } else if (node instanceof ExpressionNode) {
            visitExpression((ExpressionNode) node);
        }
    }


    private void visitIfStatement(ifStatement node) {
        // الشرط نفسه بيستخدم متغيرات (resolve)، ما بينشئ scope جديد
        visitExpression(node.condition);

        if (node.thenBranch != null) {
            for (ContentNode n : node.thenBranch) visit(n);
        }
        if (node.elifBranch != null) {
            for (ElifBranch elif : node.elifBranch) {
                visitExpression(elif.expr);
                if (elif.statements != null) {
                    for (ContentNode n : elif.statements) visit(n);
                }
            }
        }
        if (node.elseBranch != null && node.elseBranch.statements != null) {
            for (ContentNode n : node.elseBranch.statements) visit(n);
        }
    }

    private void visitForStatement(ForStatement node) {
        forCounter++;
        String scopeName = "For#" + forCounter + " (line " + node.line + ")";

        // 1. حل (resolve) الـ iterable من الـ scope الحالي (هو معرّف قبل الحلقة، مش جواها)
        if (node.control != null) {
            visitExpression(node.control.iterable);
            // استدلال نوع: أي متغير استُخدم كـ iterable بحلقة for غالباً LIST
            inferIterableType(node.control.iterable);
        }

        // 2. فتح scope جديد لمتغيرات حلقة for
        Scope forScope = table.enterScope(scopeName);
        allScopes.add(forScope);

        // 3. تصريح متغيرات الحلقة (iterables) كـ FOR_LOOP_VAR بهاد الـ scope الجديد
        if (node.control != null && node.control.iterables != null) {
            for (ExpressionNode var : node.control.iterables) {
                if (var instanceof Identifier) {
                    String varName = ((Identifier) var).text;
                    Symbol sym = new Symbol(varName, SymbolKind.FOR_LOOP_VAR,
                            DataType.UNKNOWN, forScope, node.line);
                    table.declare(sym);
                }
            }
        }

        // 4. زيارة جسم الحلقة وهو لسا داخل الـ scope الجديد
        if (node.body != null) {
            for (ContentNode n : node.body) visit(n);
        }

        // 5. الخروج من الـ scope (الرجوع للـ scope الأب)
        table.exitScope();
    }

    // ===================== HTML =====================

    private void visitHtmlElementNode(HtmlElementNode node) {
        if (node.attributes != null) {
            for (HtmlAttributeNode attr : node.attributes) visitHtmlAttributeNode(attr);
        }
        if (node.children != null) {
            for (ContentNode child : node.children) visit(child);
        }
    }

    private void visitHtmlAttributeNode(HtmlAttributeNode node) {
        if (node.value instanceof ExpressionAttribute) {
            visitExpression(((ExpressionAttribute) node.value).expression);
        }
        // StringAttribute: نص ثابت، ما فيه متغيرات
    }

    // ===================== CSS =====================

    private void visitStyleBlock(StyleBlock node) {
        if (node.rules == null) return;
        for (CssRule rule : node.rules) {
            if (rule.declarations == null) continue;
            for (CssDeclaration decl : rule.declarations) {
                if (decl.values == null) continue;
                for (CssValueNode val : decl.values) {
                    if (val instanceof CssExpression) {
                        visitExpression(((CssExpression) val).expression);
                    }
                }
            }
        }
    }

    // ===================== Expressions =====================

    private void visitExpression(ExpressionNode expr) {
        if (expr == null) return;

        if (expr instanceof Identifier) {
            visitIdentifier((Identifier) expr);

        } else if (expr instanceof BinaryNode) {
            BinaryNode b = (BinaryNode) expr;
            visitExpression(b.left);
            visitExpression(b.right);

        } else if (expr instanceof Ternary) {
            Ternary t = (Ternary) expr;
            visitExpression(t.condition);
            visitExpression(t.trueExp);
            visitExpression(t.falseExp);

        } else if (expr instanceof Member) {
            Member m = (Member) expr;
            visitExpression(m.object);
            // استدلال نوع: أي متغير استُخدم بـ member access (مثل product.name) غالباً DICT (كائن له خصائص)
            inferMemberObjectType(m.object);
            // m.member هو اسم خاصية (property) مش متغير مستقل، فما منعرّفه بالجدول

        } else if (expr instanceof IndexAccess) {
            IndexAccess ia = (IndexAccess) expr;
            visitExpression(ia.target);
            visitExpression(ia.index);

        } else if (expr instanceof FunctionCall) {
            visitFunctionCall((FunctionCall) expr);

        } else if (expr instanceof Filter) {
            visitFilter((Filter) expr);

        }
        // NumberLiteral, StringNode: قيم ثابتة (literals) بنوع معروف 100% (NUMBER/STRING بالترتيب)،
        // لكنها لا تُسجَّل كرموز بالجدول لأنها ليست متغيرات قابلة لإعادة الاستخدام، فلا حاجة لاستدلال نوع هنا.
    }

    private void visitIdentifier(Identifier id) {
        // لو مسجّل مسبقاً (بهاد الـ scope أو بأب له) ما بنعيد تعريفه، هون استخدام فقط
        Symbol existing = table.resolve(id.text);
        if (existing == null) {
            // متغير غير معروف مسبقاً => غالباً جاي من Flask (context خارجي) => UNKNOWN
            Symbol sym = new Symbol(id.text, SymbolKind.VARIABLE, DataType.UNKNOWN,
                    table.getCurrentScope(), id.line);
            table.declare(sym);
        } else {
            // الرمز موجود مسبقاً => هاد استخدام جديد له (مش تعريف)، نسجل سطره بقائمة usages
            existing.addUsage(id.line);
        }
    }

    private void visitFunctionCall(FunctionCall call) {
        // اسم الدالة نفسها
        if (call.function instanceof Identifier) {
            String funcName = ((Identifier) call.function).text;
            Symbol existing = table.resolve(funcName);
            if (existing == null) {
                Symbol sym = new Symbol(funcName, SymbolKind.FUNCTION, DataType.UNKNOWN,
                        table.getCurrentScope(), call.line);
                table.declare(sym);
            } else {
                existing.addUsage(call.line);
            }
        } else {
            visitExpression(call.function);
        }
        // متغيرات الـ arguments المستخدمة بالنداء
        if (call.arguments != null) {
            for (ExpressionNode arg : call.arguments) visitExpression(arg);
        }
    }

    private void visitFilter(Filter filter) {
        // المتغير المدخل للفلتر (قبل |)
        visitExpression(filter.input);

        // استدلال نوع: لو الفلتر رقمي معروف، المتغير المدخل غالباً NUMBER
        inferFilterInputType(filter.input, filter.filterName);

        // اسم الفلتر نفسه
        Symbol existing = table.resolve(filter.filterName);
        if (existing == null) {
            Symbol sym = new Symbol(filter.filterName, SymbolKind.FILTER, DataType.UNKNOWN,
                    table.getCurrentScope(), filter.line);
            table.declare(sym);
        } else {
            existing.addUsage(filter.line);
        }

        // متغيرات arguments الفلتر (مثل |round(2))
        if (filter.arguments != null) {
            for (ExpressionNode arg : filter.arguments) visitExpression(arg);
        }
    }

    private static final List<String> NUMERIC_FILTERS = List.of("round", "abs", "int", "float");

    // لو المتغير استُخدم كـ iterable بحلقة for، نستنتج إنه LIST (إلا لو نوعه معروف ومحدد مسبقاً بدقة)
    private void inferIterableType(ExpressionNode iterable) {
        if (iterable instanceof Identifier) {
            Symbol sym = table.resolve(((Identifier) iterable).text);
            if (sym != null && sym.dataType == DataType.UNKNOWN) {
                sym.dataType = DataType.LIST;
            }
        }
    }

    // لو المتغير استُخدم كـ object بـ member access (product.name)، نستنتج إنه DICT
    private void inferMemberObjectType(ExpressionNode object) {
        if (object instanceof Identifier) {
            Symbol sym = table.resolve(((Identifier) object).text);
            if (sym != null && sym.dataType == DataType.UNKNOWN) {
                sym.dataType = DataType.DICT;
            }
        }
    }

    // لو المتغير مُمرَّر لفلتر رقمي معروف (round, abs...)، نستنتج إنه NUMBER
    private void inferFilterInputType(ExpressionNode input, String filterName) {
        if (input instanceof Identifier && NUMERIC_FILTERS.contains(filterName)) {
            Symbol sym = table.resolve(((Identifier) input).text);
            if (sym != null && sym.dataType == DataType.UNKNOWN) {
                sym.dataType = DataType.NUMBER;
            }
        }
    }

    //  Printing

    public String printTable() {
        return table.printTable(allScopes);
    }
}