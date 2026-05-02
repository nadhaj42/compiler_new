

parser grammar jinjaParser;

options { tokenVocab=jinjaLexer; }

// ==========================================
// 1. ENTRY POINT
// ==========================================
prog
    : (content | JINJA_STMT_WS)* EOF   #Program
    ;

content
    : htmlElement      #HtmlElementContent
    | jinjaStatement   #JinjaStatementContent
    | jinjaExpression  #JinjaExpressionContent
    | styleBlock       #StyleBlockContent
    | htmlText         #TextContent
    ;

htmlText
    : HTML_TEXT #HtmlTextContent
    ;

// ==========================================
// 2. JINJA EXPRESSIONS & STATEMENTS
// ==========================================
jinjaExpression
    : (JINJA2_OPEN_EXPR
      | JINJA2_OPEN_EXPR_IN_TAG
      | JINJA2_OPEN_EXPR_IN_ATTR
      | JINJA2_OPEN_EXPR_IN_ATTR_S
      | JINJA2_OPEN_EXPR_IN_CSS
      ) expr JINJA2_CLOSE_EXPR
      #JinjaExpressionWrapper
    ;

expr
    : primaryExpr                                             #PrimaryExpression
    | expr JINJA_LPAREN (expr (JINJA_COMMA expr)*)? JINJA_RPAREN   #FunctionCallExpression
    | expr JINJA_DOT (primaryExpr | JINJA_IDENT)             #MemberAccessExpression
    | expr JINJA_LBRACK expr JINJA_RBRACK                    #IndexAccessExpression
    | expr JINJA_PIPE JINJA_IDENT (JINJA_LPAREN (expr (JINJA_COMMA expr)*)? JINJA_RPAREN)? #FilterExpression
    | expr JINJA_OP expr                                     #BinaryOpExpression
    | expr ifToken=JINJA_IDENT condition=expr elseToken=JINJA_IDENT elseExpr=expr #TernaryExpression
    ;

primaryExpr
    : JINJA_IDENT   #IdentifierPrimary
    | JINJA_NUMBER  #NumberPrimary
    | JINJA_STRING  #StringPrimary
    | JINJA_KW_IF   #IfKeywordPrimary
    | JINJA_KW_ELSE #ElseKeywordPrimary
    ;

jinjaStatement
    : ifStatement       #IfStatementContent
    | forStatement      #ForStatementContent
    | elifStatement     #ElifStatementContent
    | elseStatement     #ElseStatementContent
    | endifStatement    #EndifStatementContent
    | endforStatement   #EndforStatementContent
    ;

ifStatement
    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
      JINJA_KW_IF expr JINJA2_CLOSE_STMT
      #IfStatementWrapper
    ;

elifStatement
    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
      JINJA_KW_ELIF expr JINJA2_CLOSE_STMT
      #ElifStatementWrapper
    ;

elseStatement
    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
      JINJA_KW_ELSE JINJA2_CLOSE_STMT
      #ElseStatementWrapper
    ;

endifStatement
    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
      JINJA_KW_ENDIF JINJA2_CLOSE_STMT
      #EndifStatementWrapper
    ;

forStatement
    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
      JINJA_KW_FOR forControl JINJA2_CLOSE_STMT
      #ForStatementWrapper
    ;

endforStatement
    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
      JINJA_KW_ENDFOR JINJA2_CLOSE_STMT
      #EndforStatementWrapper
    ;

forControl
    : iterVars+=expr (JINJA_COMMA iterVars+=expr)* JINJA_KW_IN iterable=expr
      #ForControlContent
    ;

// ==========================================
// 3. HTML ELEMENTS
// ==========================================
//htmlElement
//    : (BR_TAG | HR_TAG | IMG_TAG | INPUT_TAG | META_TAG | LINK_TAG) #VoidElementSpecial
//    | HTML_LT open=tagName attribute* HTML_TAG_END
//      (content | JINJA_STMT_WS)* HTML_CLOSE_LT close=closeTagName HTML_CLOSE_TAG_END #PairedElement
//    | HTML_LT tagName attribute* HTML_TAG_SELF_CLOSE #SelfClosingElement
//    ;

htmlElement
    : HTML_LT voidTagName attribute* (HTML_TAG_END | HTML_TAG_SELF_CLOSE) #VoidElementSpecial
    | HTML_LT open=tagName attribute* HTML_TAG_END
      (content | JINJA_STMT_WS)* HTML_CLOSE_LT close=closeTagName HTML_CLOSE_TAG_END #PairedElement
    | HTML_LT tagName attribute* HTML_TAG_SELF_CLOSE #SelfClosingElement
    ;

// قاعدة للتعرف على أسماء التاغات الفارغة (Void Elements)
voidTagName
    : TAG_BR          #TagBr
    | TAG_HR          #TagHr
    | TAG_IMG         #TagImg
    | TAG_INPUT       #TagInput
    | TAG_META        #TagMeta
    | TAG_LINK        #TagLink
    ;
tagName
    : TAG_HTML        #TagHtml
    | TAG_HEAD        #TagHead
    | TAG_BODY        #TagBody
    | TAG_DIV         #TagDiv
    | TAG_SPAN        #TagSpan
    | TAG_P           #TagP
    | TAG_A           #TagA
    | TAG_H1_6        #TagH
    | TAG_UL          #TagUl
    | TAG_OL          #TagOl
    | TAG_LI          #TagLi
    | TAG_TABLE       #TagTable
    | TAG_TR          #TagTr
    | TAG_TD          #TagTd
    | TAG_FORM        #TagForm
    | TAG_BUTTON      #TagButton
    | TAG_SCRIPT      #TagScript
    | TAG_HEADER      #TagHeader
    | TAG_FOOTER      #TagFooter
    | TAG_SECTION     #TagSection
    | HTML_TAG_NAME   #GenericTag
    ;

closeTagName
    : HTML_CLOSE_TAG_NAME   #CloseTagLiteral
    | tagName               #CloseTagFromOpen
    ;

attribute
    : (HTML_ATTRIBUTE_NAME | HTML_TAG_NAME | tagName) (HTML_EQUALS attrValue)? #RegularAttribute
    | jinjaExpression                                                        #DynamicAttribute
    ;

attrValue
    : HTML_ATTR_VALUE_START_DOUBLE (ATTR_VALUE_TEXT_DOUBLE | jinjaExpression)* ATTR_VALUE_END_DOUBLE #DoubleQuotedValue
    | HTML_ATTR_VALUE_START_SINGLE (ATTR_VALUE_TEXT_SINGLE | jinjaExpression)* ATTR_VALUE_END_SINGLE #SingleQuotedValue
    | HTML_ATTRIBUTE_VALUE_UNQUOTED                                                                 #UnquotedValue
    ;

// ==========================================
// 4. CSS & STYLE BLOCKS
// ==========================================
styleBlock
    : STYLE_TAG_START (cssContent)* CSS_STYLE_END #StyleBlockWrapper
    ;

cssContent
    : cssRule         #CssRuleContent
    | jinjaStatement  #CssJinjaStatementContent
    | jinjaExpression #CssJinjaExpressionContent
    | CSS_SEMICOLON   #CssSemicolon
    ;

cssRule
    : cssSelectorList CSS_BRACE_OPEN cssDeclarationList CSS_BRACE_CLOSE #StandardCssRule
    ;

cssSelectorList
    : cssSelector (CSS_COMMA cssSelector)* #CssSelectorListRule
    ;

cssSelector
    : (CSS_TYPE_SELECTOR | CSS_CLASS_SELECTOR | CSS_ID_SELECTOR | CSS_UNIVERSAL | CSS_PSEUDO_CLASS | CSS_PSEUDO_ELEMENT | CSS_PROPERTY)
      (CSS_COMBINATOR? (CSS_TYPE_SELECTOR | CSS_CLASS_SELECTOR | CSS_ID_SELECTOR | CSS_UNIVERSAL | CSS_PSEUDO_CLASS | CSS_PSEUDO_ELEMENT | CSS_PROPERTY))*
      #CssSelectorWrapper
    ;

cssDeclarationList
    : (declaration | jinjaStatement | jinjaExpression | CSS_SEMICOLON | JINJA_STMT_WS)* #CssDeclarationListRule
    ;

declaration
    : (CSS_PROPERTY | CSS_TYPE_SELECTOR | HTML_ATTRIBUTE_NAME)
      (CSS_COLON | )
      cssValueList
      CSS_SEMICOLON
      #CssDeclaration
    ;

cssValue
    : CSS_VALUE          #CssValueLiteral
    | CSS_PROPERTY       #CssValueProperty
    | CSS_TYPE_SELECTOR  #CssValueTypeSelector
    | CSS_ID_SELECTOR    #CssValueIdSelector
    | CSS_PSEUDO_CLASS   #CssValuePseudoClass
    | jinjaExpression    #CssValueJinjaExpression
    ;

cssValueList
    : cssValue (CSS_COMMA? cssValue)* #CssValueListRule
    ;














//parser grammar jinjaParser;
//
//options { tokenVocab=jinjaLexer; }
//
//
//prog
//    : (content | JINJA_STMT_WS)* EOF
//    ;
//
//content
//    : htmlElement      #htmlElementContent
//    | jinjaStatement   #jinjaStatementContent        //{% %}
//    | jinjaExpression  #jinjaExpressionContent       //{{  }}
//    | styleBlock       #styleBlockContent
//    | htmlText         #textContent
//    ;
//
//htmlText : HTML_TEXT #htmlTextContent;
//
//jinjaExpression
//    : (JINJA2_OPEN_EXPR
//      | JINJA2_OPEN_EXPR_IN_TAG
//      | JINJA2_OPEN_EXPR_IN_ATTR
//      | JINJA2_OPEN_EXPR_IN_ATTR_S
//      | JINJA2_OPEN_EXPR_IN_CSS
//      ) expr JINJA2_CLOSE_EXPR
//      #jinjaExpressionWrapper
//    ;
//
//expr
//    : primaryExpr                                             #primaryExpression
//    | expr JINJA_LPAREN (expr (JINJA_COMMA expr)*)? JINJA_RPAREN   #functionCallExpression
//    | expr JINJA_DOT (primaryExpr | JINJA_IDENT)             #memberAccessExpression
//    | expr JINJA_LBRACK expr JINJA_RBRACK                    #indexAccessExpression
//    | expr JINJA_PIPE JINJA_IDENT (JINJA_LPAREN (expr (JINJA_COMMA expr)*)? JINJA_RPAREN)? #filterExpression
//    | expr JINJA_OP expr                                     #binaryOpExpression
//    | expr ifToken=JINJA_IDENT condition=expr elseToken=JINJA_IDENT elseExpr=expr #ternaryExpression
//    ;
//
//primaryExpr
//    : JINJA_IDENT   #identifierPrimary
//    | JINJA_NUMBER  #numberPrimary
//    | JINJA_STRING  #stringPrimary
//    | JINJA_KW_IF   #ifKeywordPrimary
//    | JINJA_KW_ELSE #elseKeywordPrimary
//    ;
//
//jinjaStatement
//    : ifStatement       #ifStatementContent
//    | forStatement      #forStatementContent
//    | elifStatement     #elifStatementContent
//    | elseStatement     #elseStatementContent
//    | endifStatement    #endifStatementContent
//    | endforStatement   #endforStatementContent
//    ;
//
//
//ifStatement
//    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
//      JINJA_KW_IF expr JINJA2_CLOSE_STMT
//      #ifStatementWrapper
//    ;
//
//elifStatement
//    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
//      JINJA_KW_ELIF expr JINJA2_CLOSE_STMT
//      #elifStatementWrapper
//    ;
//
//elseStatement
//    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
//      JINJA_KW_ELSE JINJA2_CLOSE_STMT
//      #elseStatementWrapper
//    ;
//
//endifStatement
//    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
//      JINJA_KW_ENDIF JINJA2_CLOSE_STMT
//      #endifStatementWrapper
//    ;
//
//forStatement
//    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
//      JINJA_KW_FOR forControl JINJA2_CLOSE_STMT
//      #forStatementWrapper
//    ;
//
//endforStatement
//    : (JINJA2_OPEN_STMT | JINJA2_OPEN_STMT_IN_TAG | JINJA2_OPEN_STMT_IN_CSS)
//      JINJA_KW_ENDFOR JINJA2_CLOSE_STMT
//      #endforStatementWrapper
//    ;
//
//forControl
//    : iterVars+=expr (JINJA_COMMA iterVars+=expr)* JINJA_KW_IN iterable=expr
//      #forControlContent
//    ;
//
//styleBlock
//    : STYLE_TAG_START (cssContent | JINJA_STMT_WS)* CSS_STYLE_END
//      #styleBlockWrapper
//    ;
//
//cssContent
//    : cssRule       #cssRuleContent
//    | cssAtRule     #cssAtRuleContent
//    | jinjaStatement #cssJinjaStatementContent
//    | jinjaExpression #cssJinjaExpressionContent
//    | CSS_SEMICOLON #cssSemicolon
//    ;
//
//cssAtRule
//    : CSS_AT_RULE (cssValue | CSS_COLON)* CSS_BRACE_OPEN (cssContent | JINJA_STMT_WS)* CSS_BRACE_CLOSE
//      #cssAtRuleWrapper
//    ;
//
//cssRule
//    : cssSelectorList CSS_BRACE_OPEN (declaration | cssContent | JINJA_STMT_WS)* CSS_BRACE_CLOSE  #standardCssRule
//    | jinjaExpression (CSS_COLON cssValueList CSS_SEMICOLON)?                                #dynamicCssRule
//    ;
//
//cssSelectorList : cssSelector (CSS_COMMA cssSelector)* #cssSelectorListWrapper;
//
//cssSelector
//    : ( CSS_TYPE_SELECTOR
//      | CSS_CLASS_SELECTOR
//      | CSS_ID_SELECTOR
//      | CSS_VALUE
//      | CSS_UNIVERSAL
//      | CSS_PSEUDO_CLASS
//      | CSS_PSEUDO_ELEMENT
//      | CSS_COMBINATOR
//      | jinjaExpression
//      )+
//      #cssSelectorWrapper
//    ;
//
//declaration
//    : (CSS_PROPERTY | CSS_TYPE_SELECTOR | jinjaExpression | HTML_ATTRIBUTE_NAME | CSS_VALUE)
//      (jinjaExpression)* CSS_COLON cssValueList CSS_SEMICOLON
//      #cssDeclaration
//    ;
//
//cssValueList : (cssValue | CSS_COMMA | CSS_TYPE_SELECTOR)* #cssValueListWrapper;
//
//cssValue
//    : CSS_VALUE          #cssValueLiteral
//    | CSS_TYPE_SELECTOR  #cssValueTypeSelector
//    | CSS_ID_SELECTOR    #cssValueIdSelector
//    | jinjaExpression    #cssValueJinjaExpression
//    | jinjaStatement     #cssValueJinjaStatement
//    | CSS_LPAREN         #cssValueLParen
//    | CSS_RPAREN         #cssValueRParen
//    ;
//
//
//htmlElement
//    : HTML_LT open=HTML_TAG_NAME attribute* HTML_TAG_END (content | JINJA_STMT_WS)* HTML_CLOSE_LT close=HTML_CLOSE_TAG_NAME HTML_CLOSE_TAG_END #pairedElement
//    | HTML_LT HTML_TAG_NAME attribute* HTML_TAG_SELF_CLOSE                                                    #selfClosingElement
//    | HTML_LT HTML_TAG_NAME attribute* HTML_TAG_END                                                           #voidElement
//    ;
//
//attribute
//    : (HTML_ATTRIBUTE_NAME | HTML_TAG_NAME) (HTML_EQUALS attrValue)? #regularAttribute
//    | jinjaExpression                                               #dynamicAttribute
//    ;
//
//attrValue
//    : HTML_ATTR_VALUE_START_DOUBLE (ATTR_VALUE_TEXT_DOUBLE | jinjaExpression)* ATTR_VALUE_END_DOUBLE #doubleQuotedValue
//    | HTML_ATTR_VALUE_START_SINGLE (ATTR_VALUE_TEXT_SINGLE | jinjaExpression)* ATTR_VALUE_END_SINGLE #singleQuotedValue
//    | HTML_ATTRIBUTE_VALUE_UNQUOTED                                                                 #unquotedValue
//    ;
