lexer grammar pythonLexer;

@header { package antlr; }

@members {
    private java.util.Stack<Integer> indents = new java.util.Stack<>();
    private java.util.Queue<Token> tokens = new java.util.LinkedList<>();
    private int opened = 0;

    @Override public void emit(Token token) {
        super.setToken(token);
        tokens.add(token);
    }

    @Override public Token nextToken() {
        if (!tokens.isEmpty()) return tokens.poll();
        Token next = super.nextToken();
        if (next.getType() == NEWLINE) {
            handleNewline();
        } else if (next.getType() == EOF) {
            while (!indents.isEmpty() && indents.peek() > 0) {
                indents.pop();
                emit(new CommonToken(DEDENT, "DEDENT"));
            }
            emit(next);
        }
        return tokens.isEmpty() ? next : tokens.poll();
    }

    private void handleNewline() {
        if (opened > 0) return;
        int spaces = 0;
        while (_input.LA(spaces + 1) == ' ') { spaces++; }
        int currentIndent = indents.isEmpty() ? 0 : indents.peek();
        if (spaces > currentIndent) {
            indents.push(spaces);
            emit(new CommonToken(INDENT, "INDENT"));
        } else if (spaces < currentIndent) {
            while (!indents.isEmpty() && spaces < indents.peek()) {
                indents.pop();
                emit(new CommonToken(DEDENT, "DEDENT"));
            }
        }
    }
}

DEF     : 'def';
IF      : 'if';
ELIF    : 'elif';
ELSE    : 'else';
WHILE   : 'while';
FOR     : 'for';
IN      : 'in';
RETURN  : 'return';
PRINT   : 'print';
FROM    : 'from';
IMPORT  : 'import';
WITH    : 'with';
AS      : 'as';
NONE    : 'None';
TRUE    : 'True';
FALSE   : 'False';

AND   : 'and' ;
OR    : 'or' ;
NOT   : 'not' ;

EQUAL_CHECK  : '==';
NOT_EQUAL    : '!=';
LESS_EQUAL   : '<=';
GREATER_EQUAL: '>=';
ASSIGN       : '=';
PLUS         : '+';
MINUS        : '-';
MUL          : '*';
DIV          : '/';
LESS_THAN    : '<';
GREATER_THAN : '>';

COLON    : ':';
COMMA    : ',';
DOT      : '.';
AT       : '@';
OPEN_B   : '(' { opened++; };
CLOSE_B  : ')' { opened--; };
LBRACK   : '[' { opened++; };
RBRACK   : ']' { opened--; };
LBRACE   : '{' { opened++; };
RBRACE   : '}' { opened--; };

FLOAT    : [0-9]+ '.' [0-9]+;
NUMBER   : [0-9]+;
STRING   : '"' ( ~["\\] | '\\' . )* '"' | '\'' ( ~['\\] | '\\' . )* '\'';
VARIABLE : [a-zA-Z_][a-zA-Z0-9_]*;

COMMENT  : '#' ~[\r\n]* -> skip ;
NEWLINE  : '\r'? '\n';
WS       : ' ' + -> skip;
INDENT   : 'INDENT';
DEDENT   : 'DEDENT';