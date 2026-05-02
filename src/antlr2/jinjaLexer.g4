lexer grammar jinjaLexer;

// ==========================================
// 1. DEFAULT MODE (Main Transitions & Text)
// ==========================================

STYLE_TAG_START : '<' [sS][tT][yY][lL][eE] [ \t\r\n]* '>' {pushMode(CSS_MODE);};

WS : [ \t\r\n]+ -> skip ;

// الانتقال إلى وضع التاغات عند رؤية < أو </
HTML_LT       : '<'  -> pushMode(HTML_TAG_MODE);
HTML_CLOSE_LT : '</' -> pushMode(HTML_CLOSE_TAG_MODE);
HTML_COMMENT: '<!--' ( ~'-' | '-' ~('-') )* '-->' -> channel(HIDDEN);


// التقاط النصوص العادية مع تجنب علامات HTML و Jinja
HTML_TEXT
    : ( ~[<{]
      | '{' ~[{%#]
      | '<' ~[a-zA-Z/]
      )+
    ;

JINJA2_COMMENT    : '{#' (~'#' | '#' ~'}')* '#}' -> channel(HIDDEN);
JINJA2_OPEN_EXPR   : '{{' -> pushMode(JINJA_EXPR_MODE);
JINJA2_OPEN_STMT   : '{%' -> pushMode(JINJA_STMT_MODE);


// ==========================================
// 2. HTML TAG MODE (Inside <...>)
// ==========================================
mode HTML_TAG_MODE;

// قواعد أسماء التاغات المحددة لكي يتمكن الـ Parser من التعرف عليها بسهولة
TAG_HTML    : [hH][tT][mM][lL] ;
TAG_HEAD    : [hH][eE][aA][dD] ;
TAG_BODY    : [bB][oO][dD][yY] ;
TAG_DIV     : [dD][iI][vV] ;
TAG_SPAN    : [sS][pP][aA][nN] ;
TAG_P       : [pP] ;
TAG_A       : [aA] ;
TAG_H1_6    : [hH] [1-6] ;
TAG_UL      : [uU][lL] ;
TAG_OL      : [oO][lL] ;
TAG_LI      : [lL][iI] ;
TAG_TABLE   : [tT][aA][bB][lL][eE] ;
TAG_TR      : [tT][rR] ;
TAG_TD      : [tT][dD] ;
TAG_FORM    : [fF][oO][rR][mM] ;
TAG_BUTTON  : [bB][uU][tT][tT][oO][nN] ;
TAG_SCRIPT  : [sS][cC][rR][iI][pP][tT] ;
TAG_HEADER  : [hH][eE][aA][dD][eE][rR] ;
TAG_FOOTER  : [fF][oO][oO][tT][eE][rR] ;
TAG_SECTION : [sS][eE][cC][tT][iI][oO][nN] ;

// تاغات الـ Void Elements يتم التعرف على أسمائها هنا كرموز مستقلة
TAG_BR      : [bB][rR] ;
TAG_HR      : [hH][rR] ;
TAG_IMG     : [iI][mM][gG] ;
TAG_INPUT   : [iI][nN][pP][uU][tT] ;
TAG_META    : [mM][eE][tT][aA] ;
TAG_LINK    : [lL][iI][nN][kK] ;

// أي اسم تاغ آخر غير معرف بالأعلى
HTML_TAG_NAME : [a-zA-Z][a-zA-Z0-9:-]*;

HTML_TAG_WS: [ \t\r\n]+ -> skip;
HTML_EQUALS : '=' ;

HTML_ATTR_VALUE_START_DOUBLE : '"'  -> pushMode(ATTR_VALUE_DOUBLE_MODE);
HTML_ATTR_VALUE_START_SINGLE : '\'' -> pushMode(ATTR_VALUE_SINGLE_MODE);

// التقاط القيم غير المحاطة باقتباسات
HTML_ATTRIBUTE_VALUE_UNQUOTED : ~[ \t\r\n>="'{]+ ;

JINJA2_OPEN_EXPR_IN_TAG : '{{' -> pushMode(JINJA_EXPR_MODE);
JINJA2_OPEN_STMT_IN_TAG : '{%' -> pushMode(JINJA_STMT_MODE);

HTML_TAG_SELF_CLOSE : '/' [ \t\r\n]* '>' -> popMode;
HTML_TAG_END        : '>' -> popMode;

HTML_ATTRIBUTE_NAME : [a-zA-Z_:][a-zA-Z0-9_.:\-]* ;


// ==========================================
// 3. CLOSING TAG MODE (Inside </...>)
// ==========================================
mode HTML_CLOSE_TAG_MODE;

HTML_CLOSE_TAG_NAME : [a-zA-Z][a-zA-Z0-9:-]* ;
HTML_CLOSE_TAG_WS   : [ \t\r\n]+ -> skip ;
HTML_CLOSE_TAG_END  : '>' -> popMode ;


// ==========================================
// 4. ATTRIBUTE VALUE MODES
// ==========================================
mode ATTR_VALUE_DOUBLE_MODE;
JINJA2_OPEN_EXPR_IN_ATTR : '{{' -> pushMode(JINJA_EXPR_MODE);
JINJA2_OPEN_STMT_IN_ATTR : '{%' -> pushMode(JINJA_STMT_MODE);
ATTR_VALUE_TEXT_DOUBLE   : (~["{] | '{' ~[{%#])+;
ATTR_VALUE_END_DOUBLE    : '"' -> popMode;

mode ATTR_VALUE_SINGLE_MODE;
JINJA2_OPEN_EXPR_IN_ATTR_S : '{{' -> pushMode(JINJA_EXPR_MODE);
JINJA2_OPEN_STMT_IN_ATTR_S : '{%' -> pushMode(JINJA_STMT_MODE);
ATTR_VALUE_TEXT_SINGLE   : (~['{] | '{' ~[{%#])+;
ATTR_VALUE_END_SINGLE    : '\'' -> popMode;


// ==========================================
// 5. CSS MODE
// ==========================================
mode CSS_MODE;

CSS_STYLE_END : '</' [sS][tT][yY][lL][eE] [ \t\r\n]* '>' {popMode();};

CSS_COLON       : ':' ;
CSS_SEMICOLON   : ';' ;
CSS_BRACE_OPEN  : '{' ;
CSS_BRACE_CLOSE : '}' ;
CSS_COMMA       : ',' ;

JINJA2_OPEN_EXPR_IN_CSS : '{{' -> pushMode(JINJA_EXPR_MODE) ;
JINJA2_OPEN_STMT_IN_CSS : '{%' -> pushMode(JINJA_STMT_MODE) ;

CSS_COMMENT : '/*' (~'*' | '*' ~'/')* '*/' -> channel(HIDDEN);
CSS_WS      : [ \t\r\n]+ -> skip ;

CSS_AT_RULE        : '@' [a-zA-Z-]+ ;
CSS_UNIVERSAL      : '*' ;
CSS_CLASS_SELECTOR : '.' [a-zA-Z_][a-zA-Z0-9_-]* ;
CSS_ID_SELECTOR    : '#' [a-zA-Z_][a-zA-Z0-9_-]* ;
CSS_PSEUDO_ELEMENT : '::' [a-zA-Z-]+ ;
CSS_PSEUDO_CLASS   : ':' [a-zA-Z-]+ ;

CSS_PROPERTY       : [a-zA-Z][-a-zA-Z0-9]* ;
CSS_VALUE          : [a-zA-Z0-9#.%()/-]+ ;
CSS_TYPE_SELECTOR  : [a-zA-Z_][a-zA-Z0-9_-]* ;
CSS_COMBINATOR     : '>' | '+' | '~' ;


// ==========================================
// 6. JINJA EXPR MODE
// ==========================================
mode JINJA_EXPR_MODE;
JINJA2_CLOSE_EXPR : '}}' -> popMode ;
JINJA_WS          : [ \t\r\n]+ -> skip ;
JINJA_IDENT       : [a-zA-Z_][a-zA-Z0-9_]* ;
JINJA_DOT         : '.' ;
JINJA_NUMBER      : [0-9]+ ('.' [0-9]+)? ;
JINJA_STRING
    : '\'' (~['\\] | '\\' .)* '\''
    | '"' (~["\\] | '\\' .)* '"'
    ;
JINJA_COMMA       : ',' ;
JINJA_COLON       : ':' ;
JINJA_LPAREN      : '(' ;
JINJA_RPAREN      : ')' ;
JINJA_LBRACK      : '[' ;
JINJA_RBRACK      : ']' ;
JINJA_PIPE        : '|' ;
JINJA_OP
    : '==' | '!=' | '>=' | '<=' | '>' | '<'
    | '+' | '-' | '*' | '/' | '%'
    ;
JINJA_TILDE       : '~' ;
JINJA_ASSIGN      : '=' ;
JINJA_OTHER       : (~[ \t\r\n}{()[\]'".,:|<>+=-])+;


// ==========================================
// 7. JINJA STMT MODE
// ==========================================
mode JINJA_STMT_MODE;
JINJA2_CLOSE_STMT : '%}' -> popMode ;
JINJA_STMT_WS     : [ \t\r\n]+ -> skip ;

JINJA_KW_FOR      : 'for' ;
JINJA_KW_ENDFOR   : 'endfor' ;
JINJA_KW_IF       : 'if' ;
JINJA_KW_ENDIF    : 'endif' ;
JINJA_KW_ELSE     : 'else' ;
JINJA_KW_ELIF     : 'elif' ;
JINJA_KW_IN       : 'in' ;

JINJA_STMT_COMMA  : ',' -> type(JINJA_COMMA) ;
JINJA_STMT_DOT    : '.' -> type(JINJA_DOT) ;
JINJA_STMT_LPAREN : '(' -> type(JINJA_LPAREN) ;
JINJA_STMT_RPAREN : ')' -> type(JINJA_RPAREN) ;
JINJA_STMT_LBRACK : '[' -> type(JINJA_LBRACK) ;
JINJA_STMT_RBRACK : ']' -> type(JINJA_RBRACK) ;
JINJA_STMT_PIPE   : '|' -> type(JINJA_PIPE) ;

JINJA_STMT_OP
    : ('==' | '!=' | '>=' | '<=' | '>' | '<' | '+' | '-' | '*' | '/' | '%')
    -> type(JINJA_OP) ;

JINJA_STMT_IDENT  : [a-zA-Z_][a-zA-Z0-9_]* -> type(JINJA_IDENT) ;
JINJA_STMT_NUMBER : [0-9]+ ('.' [0-9]+)?   -> type(JINJA_NUMBER) ;
JINJA_STMT_STRING : ('\'' (~['\\] | '\\' .)* '\'' | '"' (~["\\] | '\\' .)* '"') -> type(JINJA_STRING) ;
JINJA_STMT_ANY    : . ;

//
//lexer grammar jinjaLexer;
//
//// ==========================================
//// 1. VOID ELEMENTS (Self-Closing)
//// ==========================================
//BR_TAG      : '<' [bB][rR]             [ \t\r\n]* '/'? '>' ;
//HR_TAG      : '<' [hH][rR]             [ \t\r\n]* '/'? '>' ;
//IMG_TAG     : '<' [iI][mM][gG]         (JINJA2_OPEN_EXPR | JINJA2_OPEN_STMT | ~[>])* '>' ;
//INPUT_TAG   : '<' [iI][nN][pP][uU][tT]   (JINJA2_OPEN_EXPR | JINJA2_OPEN_STMT | ~[>])* '>' ;
//META_TAG    : '<' [mM][eE][tT][aA]      (JINJA2_OPEN_EXPR | JINJA2_OPEN_STMT | ~[>])* '>' ;
//LINK_TAG    : '<' [lL][iI][nN][kK]      (JINJA2_OPEN_EXPR | JINJA2_OPEN_STMT | ~[>])* '>' ;
//
//// ==========================================
//// 2. MAIN TRANSITIONS & TEXT
//// ==========================================
//STYLE_TAG_START : '<' [sS][tT][yY][lL][eE] '>' {pushMode(CSS_MODE);};
//
//WS : [ \t\r\n]+ -> skip ;
//HTML_LT : '<' -> pushMode(HTML_TAG_MODE);
//HTML_CLOSE_LT : '</' -> pushMode(HTML_CLOSE_TAG_MODE);
//HTML_COMMENT: '<!--' ( ~'-' | '-' ~('-') )* '-->' -> channel(HIDDEN);
//
//HTML_TEXT
//    : ( ~[<{]
//      | '{' ~[{%#]
//      | '<' ~[a-zA-Z/]
//      )+
//    ;
//
//JINJA2_COMMENT    : '{#' (~'#' | '#' ~'}')* '#}' -> channel(HIDDEN);
//JINJA2_OPEN_EXPR   : '{{' -> pushMode(JINJA_EXPR_MODE);
//JINJA2_OPEN_STMT   : '{%' -> pushMode(JINJA_STMT_MODE);
//
//// ==========================================
//// 3. HTML TAG MODE
//// ==========================================
//mode HTML_TAG_MODE;
//
//HTML_TAG_NAME : [a-zA-Z][a-zA-Z0-9:-]*;
//HTML_TAG_WS: [ \t\r\n]+ -> skip;
//
//HTML_EQUALS  : '=' ;
//HTML_ATTRIBUTE_VALUE_UNQUOTED: ~[ \t\r\n>="'{]+ ;
//
//HTML_ATTR_VALUE_START_DOUBLE  : '"' -> pushMode(ATTR_VALUE_DOUBLE_MODE);
//HTML_ATTR_VALUE_START_SINGLE : '\'' -> pushMode(ATTR_VALUE_SINGLE_MODE);
//
//JINJA2_OPEN_EXPR_IN_TAG : '{{' -> pushMode(JINJA_EXPR_MODE);
//JINJA2_OPEN_STMT_IN_TAG : '{%' -> pushMode(JINJA_STMT_MODE);
//
//HTML_TAG_SELF_CLOSE: '/' [ \t\r\n]* '>' -> popMode;
//HTML_TAG_END: '>' -> popMode;
//
//HTML_ATTRIBUTE_NAME  : [a-zA-Z_:][a-zA-Z0-9_.:\-]* ;
//
//// ==========================================
//// 4. CLOSING TAG MODE
//// ==========================================
//mode HTML_CLOSE_TAG_MODE;
//HTML_CLOSE_TAG_NAME : [a-zA-Z][a-zA-Z0-9:-]* ;
//HTML_CLOSE_TAG_WS   : [ \t\r\n]+ -> skip ;
//HTML_CLOSE_TAG_END  : '>' -> popMode ;
//
//// ==========================================
//// 5. ATTRIBUTE VALUE MODES
//// ==========================================
//mode ATTR_VALUE_DOUBLE_MODE;
//JINJA2_OPEN_EXPR_IN_ATTR : '{{' -> pushMode(JINJA_EXPR_MODE);
//JINJA2_OPEN_STMT_IN_ATTR : '{%' -> pushMode(JINJA_STMT_MODE);
//ATTR_VALUE_TEXT_DOUBLE : (~["{] | '{' ~[{%#])+;
//ATTR_VALUE_END_DOUBLE : '"' -> popMode;
//
//mode ATTR_VALUE_SINGLE_MODE;
//JINJA2_OPEN_EXPR_IN_ATTR_S : '{{' -> pushMode(JINJA_EXPR_MODE);
//JINJA2_OPEN_STMT_IN_ATTR_S : '{%' -> pushMode(JINJA_STMT_MODE);
//ATTR_VALUE_TEXT_SINGLE : (~['{] | '{' ~[{%#])+;
//ATTR_VALUE_END_SINGLE : '\'' -> popMode;
//
//// ==========================================
//// 6. CSS MODE (The Fixed Core)
//// ==========================================
//mode CSS_MODE;
//
//CSS_STYLE_END : '</' [sS][tT][yY][lL][eE] '>' {popMode();};
//
//// Symbols first for priority
//CSS_COLON       : ':' ;
//CSS_SEMICOLON   : ';' ;
//CSS_BRACE_OPEN  : '{' ;
//CSS_BRACE_CLOSE : '}' ;
//CSS_COMMA       : ',' ;
//JINJA2_OPEN_EXPR_IN_CSS : '{{' -> pushMode(JINJA_EXPR_MODE) ;
//JINJA2_OPEN_STMT_IN_CSS : '{%' -> pushMode(JINJA_STMT_MODE) ;
//
//CSS_COMMENT : '/*' (~'*' | '*' ~'/')* '*/' -> channel(HIDDEN);
//CSS_WS      : [ \t\r\n]+ -> skip ;
//
//CSS_AT_RULE        : '@' [a-zA-Z-]+ ;
//CSS_UNIVERSAL      : '*' ;
//CSS_CLASS_SELECTOR : '.' [a-zA-Z_][a-zA-Z0-9_-]* ;
//CSS_ID_SELECTOR    : '#' [a-zA-Z_][a-zA-Z0-9_-]* ;
//CSS_PSEUDO_ELEMENT : '::' [a-zA-Z-]+ ;
//CSS_PSEUDO_CLASS   : ':' [a-zA-Z-]+ ;
//
//CSS_PROPERTY : [a-zA-Z][-a-zA-Z0-9]* ;
//CSS_VALUE    : [a-zA-Z0-9#.%()/-]+ ;
//CSS_TYPE_SELECTOR  : [a-zA-Z_][a-zA-Z0-9_-]* ;
//CSS_COMBINATOR     : '>' | '+' | '~' ;
//
//// ==========================================
//// 7. JINJA MODES
//// ==========================================
//mode JINJA_EXPR_MODE;
//JINJA2_CLOSE_EXPR : '}}' -> popMode ;
//JINJA_WS : [ \t\r\n]+ -> skip ;
//JINJA_IDENT : [a-zA-Z_][a-zA-Z0-9_]* ;
//JINJA_DOT   : '.' ;
//JINJA_NUMBER : [0-9]+ ('.' [0-9]+)? ;
//JINJA_STRING
//    : '\'' (~['\\] | '\\' .)* '\''
//    | '"' (~["\\] | '\\' .)* '"'
//    ;
//JINJA_COMMA  : ',' ;
//JINJA_COLON  : ':' ;
//JINJA_LPAREN : '(' ;
//JINJA_RPAREN : ')' ;
//JINJA_LBRACK : '[' ;
//JINJA_RBRACK : ']' ;
//JINJA_PIPE   : '|' ;
//JINJA_OP
//    : '==' | '!=' | '>=' | '<=' | '>' | '<'
//    | '+' | '-' | '*' | '/' | '%'
//    ;
//JINJA_TILDE : '~' ;
//JINJA_ASSIGN : '=' ;
//JINJA_OTHER : (~[ \t\r\n}{()[\]'".,:|<>+=-])+;
//
//mode JINJA_STMT_MODE;
//JINJA2_CLOSE_STMT : '%}' -> popMode ;
//JINJA_STMT_WS : [ \t\r\n]+ -> skip ;
//
//JINJA_KW_FOR     : 'for' ;
//JINJA_KW_ENDFOR  : 'endfor' ;
//JINJA_KW_IF      : 'if' ;
//JINJA_KW_ENDIF   : 'endif' ;
//JINJA_KW_ELSE    : 'else' ;
//JINJA_KW_ELIF    : 'elif' ;
//JINJA_KW_IN      : 'in' ;
//
//JINJA_STMT_COMMA  : ',' -> type(JINJA_COMMA) ;
//JINJA_STMT_DOT    : '.' -> type(JINJA_DOT) ;
//JINJA_STMT_LPAREN : '(' -> type(JINJA_LPAREN) ;
//JINJA_STMT_RPAREN : ')' -> type(JINJA_RPAREN) ;
//JINJA_STMT_LBRACK : '[' -> type(JINJA_LBRACK) ;
//JINJA_STMT_RBRACK : ']' -> type(JINJA_RBRACK) ;
//JINJA_STMT_PIPE   : '|' -> type(JINJA_PIPE) ;
//
//JINJA_STMT_OP
//    : ('==' | '!=' | '>=' | '<=' | '>' | '<' | '+' | '-' | '*' | '/' | '%')
//    -> type(JINJA_OP) ;
//
//JINJA_STMT_IDENT  : [a-zA-Z_][a-zA-Z0-9_]* -> type(JINJA_IDENT) ;
//JINJA_STMT_NUMBER : [0-9]+ ('.' [0-9]+)?   -> type(JINJA_NUMBER) ;
//JINJA_STMT_STRING : ('\'' (~['\\] | '\\' .)* '\'' | '"' (~["\\] | '\\' .)* '"') -> type(JINJA_STRING) ;
//JINJA_STMT_ANY    : . ;
//





//lexer grammar jinjaLexer;
//
//@header {
//}
//
//STYLE_TAG_START
//    : '<' [sS][tT][yY][lL][eE] '>' {pushMode(CSS_MODE);}
//    ;
//
//WS : [ \t\r\n]+ -> skip ;
//HTML_LT : '<' -> pushMode(HTML_TAG_MODE);
//HTML_CLOSE_LT : '</' -> pushMode(HTML_CLOSE_TAG_MODE);
//HTML_COMMENT: '<!--' ( ~'-' | '-' ~('-') )* '-->' -> channel(HIDDEN);
//HTML_TEXT
//    : ( ~[<{]
//      | '{' ~[{%#]
//      | '<' ~[a-zA-Z/]
//      )+
//    ;
//JINJA2_COMMENT  : '{#' (~'#' | '#' ~'}')* '#}' -> channel(HIDDEN);
//JINJA2_OPEN_EXPR  : '{{' -> pushMode(JINJA_EXPR_MODE);
//JINJA2_OPEN_STMT : '{%' -> pushMode(JINJA_STMT_MODE);
//
//mode HTML_TAG_MODE;
//
//HTML_TAG_NAME : [a-zA-Z][a-zA-Z0-9:-]*;
//HTML_TAG_WS: [ \t\r\n]+ -> skip;
//
//HTML_EQUALS  : '=' ;
//HTML_ATTRIBUTE_VALUE_UNQUOTED: ~[ \t\r\n>="'{]+ ;
//
//HTML_ATTR_VALUE_START_DOUBLE  : '"' -> pushMode(ATTR_VALUE_DOUBLE_MODE);
//HTML_ATTR_VALUE_START_SINGLE : '\'' -> pushMode(ATTR_VALUE_SINGLE_MODE);
//
//JINJA2_OPEN_EXPR_IN_TAG : '{{' -> pushMode(JINJA_EXPR_MODE);
//JINJA2_OPEN_STMT_IN_TAG : '{%' -> pushMode(JINJA_STMT_MODE);
//
//HTML_TAG_SELF_CLOSE: '/' [ \t\r\n]* '>' -> popMode;
//HTML_TAG_END: '>' -> popMode;
//
//HTML_ATTRIBUTE_NAME  : [a-zA-Z_:][a-zA-Z0-9_.:\-]* ;
//
//mode HTML_CLOSE_TAG_MODE;
//HTML_CLOSE_TAG_NAME : [a-zA-Z][a-zA-Z0-9:-]* ;
//HTML_CLOSE_TAG_WS   : [ \t\r\n]+ -> skip ;
//HTML_CLOSE_TAG_END  : '>' -> popMode ;
//
//mode ATTR_VALUE_DOUBLE_MODE;
//JINJA2_OPEN_EXPR_IN_ATTR : '{{' -> pushMode(JINJA_EXPR_MODE);
//JINJA2_OPEN_STMT_IN_ATTR : '{%' -> pushMode(JINJA_STMT_MODE);
//ATTR_VALUE_TEXT_DOUBLE : (~["{] | '{' ~[{%#])+;
//ATTR_VALUE_END_DOUBLE : '"' -> popMode;
//
//mode ATTR_VALUE_SINGLE_MODE;
//JINJA2_OPEN_EXPR_IN_ATTR_S : '{{' -> pushMode(JINJA_EXPR_MODE);
//JINJA2_OPEN_STMT_IN_ATTR_S : '{%' -> pushMode(JINJA_STMT_MODE);
//ATTR_VALUE_TEXT_SINGLE : (~['{] | '{' ~[{%#])+;
//ATTR_VALUE_END_SINGLE : '\'' -> popMode;
//
//
//
//mode CSS_MODE;
//CSS_STYLE_END
//    : '</' [sS][tT][yY][lL][eE] '>' {popMode();}
//    ;
//
//JINJA2_OPEN_EXPR_IN_CSS : '{{' -> pushMode(JINJA_EXPR_MODE) ;
//JINJA2_OPEN_STMT_IN_CSS : '{%' -> pushMode(JINJA_STMT_MODE) ;
//CSS_COMMENT : '/*' (~'*' | '*' ~'/')* '*/' -> channel(HIDDEN);
//
//
//
//CSS_AT_RULE : '@' [a-zA-Z-]+ ;
//CSS_UNIVERSAL      : '*' ;
//CSS_TYPE_SELECTOR  : [a-zA-Z_][a-zA-Z0-9_-]* ;
//CSS_CLASS_SELECTOR : '.' [a-zA-Z_][a-zA-Z0-9_-]* ;
//CSS_ID_SELECTOR    : '#' [a-zA-Z_][a-zA-Z0-9_-]* ;
//CSS_COMBINATOR : '>' | '+' | '~' ;
//CSS_ATTR_START : '[' ;
//CSS_ATTR_END   : ']' ;
//CSS_ATTR_OP    : '=' | '~=' | '|=' | '^=' | '$=' | '*=' ;
//CSS_PSEUDO_ELEMENT  : '::' [a-zA-Z-]+ ;
//CSS_PSEUDO_CLASS    : ':' [a-zA-Z-]+ ;
//
//CSS_BRACE_OPEN  : '{' ;
//CSS_BRACE_CLOSE : '}' ;
//CSS_COLON       : ':' ;
//CSS_SEMICOLON   : ';' ;
//CSS_COMMA       : ',' ;
//CSS_PROPERTY : [a-zA-Z-]+ ;
//CSS_VALUE    : [a-zA-Z0-9#.%()/-]+ ;
//
//CSS_WS : [ \t\r\n]+ -> skip ;
//
//mode JINJA_EXPR_MODE;
//JINJA2_CLOSE_EXPR : '}}' -> popMode ;
//JINJA_WS : [ \t\r\n]+ -> skip ;
//JINJA_IDENT : [a-zA-Z_][a-zA-Z0-9_]* ;
//JINJA_DOT   : '.' ;
//JINJA_NUMBER : [0-9]+ ('.' [0-9]+)? ;
//JINJA_STRING
//    : '\'' (~['\\] | '\\' .)* '\''
//    | '"' (~["\\] | '\\' .)* '"'
//    ;
//JINJA_COMMA  : ',' ;
//JINJA_COLON  : ':' ;
//JINJA_LPAREN : '(' ;
//JINJA_RPAREN : ')' ;
//JINJA_LBRACK : '[' ;
//JINJA_RBRACK : ']' ;
//JINJA_PIPE   : '|' ;
//JINJA_OP
//    : '==' | '!=' | '>=' | '<=' | '>' | '<'
//    | '+' | '-' | '*' | '/' | '%'
//    ;
//JINJA_TILDE : '~' ;
//JINJA_ASSIGN : '=' ;
//JINJA_OTHER : (~[ \t\r\n}{()[\]'".,:|<>+=-])+;
//
//mode JINJA_STMT_MODE;
//    JINJA2_CLOSE_STMT : '%}' -> popMode ;
//    JINJA_STMT_WS : [ \t\r\n]+ -> skip ;
//
//    JINJA_KW_FOR     : 'for' ;
//    JINJA_KW_ENDFOR  : 'endfor' ;
//    JINJA_KW_IF      : 'if' ;
//    JINJA_KW_ENDIF   : 'endif' ;
//    JINJA_KW_ELSE    : 'else' ;
//    JINJA_KW_ELIF    : 'elif' ;
//    JINJA_KW_IN      : 'in' ;
//
//    JINJA_STMT_COMMA  : ',' -> type(JINJA_COMMA) ;
//    JINJA_STMT_DOT    : '.' -> type(JINJA_DOT) ;
//    JINJA_STMT_LPAREN : '(' -> type(JINJA_LPAREN) ;
//    JINJA_STMT_RPAREN : ')' -> type(JINJA_RPAREN) ;
//    JINJA_STMT_LBRACK : '[' -> type(JINJA_LBRACK) ;
//    JINJA_STMT_RBRACK : ']' -> type(JINJA_RBRACK) ;
//    JINJA_STMT_PIPE   : '|' -> type(JINJA_PIPE) ;
//
//    JINJA_STMT_OP
//        : ('==' | '!=' | '>=' | '<=' | '>' | '<' | '+' | '-' | '*' | '/' | '%')
//        -> type(JINJA_OP) ;
//
//    JINJA_STMT_IDENT  : [a-zA-Z_][a-zA-Z0-9_]* -> type(JINJA_IDENT) ;
//    JINJA_STMT_NUMBER : [0-9]+ ('.' [0-9]+)?   -> type(JINJA_NUMBER) ;
//    JINJA_STMT_STRING : ('\'' (~['\\] | '\\' .)* '\'' | '"' (~["\\] | '\\' .)* '"') -> type(JINJA_STRING) ;
//    JINJA_STMT_ANY    : . ;



