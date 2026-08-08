package Generation.Python;

import java.util.*;

/**
 * بارسر JSON بسيط ويدوي (بدون مكتبات خارجية).
 * بيدعم: Object, Array, String, Number, Boolean, null
 * كافي لقراءة products.json (قائمة من objects بسيطة).
 */
public class SimpleJsonParser {

    private final String text;
    private int pos = 0;

    private SimpleJsonParser(String text) {
        this.text = text;
    }

    /** نقطة الدخول العامة: بترجع List أو Map حسب محتوى الملف */
    public static Object parse(String jsonText) {
        SimpleJsonParser parser = new SimpleJsonParser(jsonText);
        parser.skipWhitespace();
        Object result = parser.parseValue();
        return result;
    }

    private Object parseValue() {
        skipWhitespace();
        char c = peek();
        if (c == '{') return parseObject();
        if (c == '[') return parseArray();
        if (c == '"') return parseString();
        if (c == 't' || c == 'f') return parseBoolean();
        if (c == 'n') { expectLiteral("null"); return null; }
        return parseNumber();
    }

    private Map<String, Object> parseObject() {
        Map<String, Object> map = new LinkedHashMap<>();
        expect('{');
        skipWhitespace();
        if (peek() == '}') { pos++; return map; }

        while (true) {
            skipWhitespace();
            String key = parseString();
            skipWhitespace();
            expect(':');
            Object value = parseValue();
            map.put(key, value);
            skipWhitespace();
            char c = peek();
            if (c == ',') { pos++; continue; }
            if (c == '}') { pos++; break; }
            throw new RuntimeException("خطأ صيغة JSON عند الموقع " + pos + " (متوقع , أو })");
        }
        return map;
    }

    private List<Object> parseArray() {
        List<Object> list = new ArrayList<>();
        expect('[');
        skipWhitespace();
        if (peek() == ']') { pos++; return list; }

        while (true) {
            Object value = parseValue();
            list.add(value);
            skipWhitespace();
            char c = peek();
            if (c == ',') { pos++; continue; }
            if (c == ']') { pos++; break; }
            throw new RuntimeException("خطأ صيغة JSON عند الموقع " + pos + " (متوقع , أو ])");
        }
        return list;
    }

    private String parseString() {
        expect('"');
        StringBuilder sb = new StringBuilder();
        while (peek() != '"') {
            char c = text.charAt(pos++);
            if (c == '\\') {
                char next = text.charAt(pos++);
                switch (next) {
                    case '"':  sb.append('"'); break;
                    case '\\': sb.append('\\'); break;
                    case '/':  sb.append('/'); break;
                    case 'n':  sb.append('\n'); break;
                    case 't':  sb.append('\t'); break;
                    case 'r':  sb.append('\r'); break;
                    case 'u':
                        String hex = text.substring(pos, pos + 4);
                        sb.append((char) Integer.parseInt(hex, 16));
                        pos += 4;
                        break;
                    default: sb.append(next);
                }
            } else {
                sb.append(c);
            }
        }
        pos++;
        return sb.toString();
    }

    private Object parseNumber() {
        int start = pos;
        if (peek() == '-') pos++;
        while (pos < text.length() && Character.isDigit(text.charAt(pos))) pos++;
        boolean isFloat = false;
        if (pos < text.length() && text.charAt(pos) == '.') {
            isFloat = true;
            pos++;
            while (pos < text.length() && Character.isDigit(text.charAt(pos))) pos++;
        }
        if (pos < text.length() && (text.charAt(pos) == 'e' || text.charAt(pos) == 'E')) {
            isFloat = true;
            pos++;
            if (text.charAt(pos) == '+' || text.charAt(pos) == '-') pos++;
            while (pos < text.length() && Character.isDigit(text.charAt(pos))) pos++;
        }
        String numStr = text.substring(start, pos);
        return isFloat ? (Object) Double.parseDouble(numStr) : (Object) Long.parseLong(numStr);
    }

    private Boolean parseBoolean() {
        if (peek() == 't') { expectLiteral("true"); return true; }
        expectLiteral("false");
        return false;
    }

    private void expectLiteral(String literal) {
        if (!text.startsWith(literal, pos)) {
            throw new RuntimeException("متوقع '" + literal + "' عند الموقع " + pos);
        }
        pos += literal.length();
    }

    private void expect(char c) {
        skipWhitespace();
        if (text.charAt(pos) != c) {
            throw new RuntimeException("متوقع '" + c + "' عند الموقع " + pos + " لكن وُجد '" + text.charAt(pos) + "'");
        }
        pos++;
    }

    private char peek() {
        skipWhitespace();
        return text.charAt(pos);
    }

    private void skipWhitespace() {
        while (pos < text.length() && Character.isWhitespace(text.charAt(pos))) pos++;
    }
}