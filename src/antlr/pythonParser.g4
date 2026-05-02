//parser grammar pythonParser;
//options { tokenVocab=pythonLexer; }
//
//
// // التعديل هنا: السماح بأسطر ومسافات قبل وبعد الكود
// prog: (statement | NEWLINE | INDENT | DEDENT)* EOF;
//
// statement
//     : decorator_stmt                            #decoratorStatement
//     | import_stmt                               #importStatement
//     | assign_stmt                               #assignStatement
//     | func_def                                  #functionDefinition
//     | if_stmt                                   #ifStatement
//     | with_stmt                                 #withStatement
//     | for_stmt                                  #forStatement
//     | while_stmt                                #whileStatement
//     | print_stmt                                #printStatement
//     | return_stmt                               #returnStatement
//     | expr_stmt                                 #expressionStatement
//     ;
//
// // تأكدي أن suite تسمح بأسطر فارغة بداخلها
// suite: (NEWLINE)* INDENT (statement | NEWLINE)* DEDENT;
//
// // ... باقي القواعد كما هي في الكود السابق ...
//decorator_stmt: AT primary (OPEN_B arg_list? CLOSE_B)? NEWLINE statement;
//func_def: DEF VARIABLE OPEN_B param_list? CLOSE_B COLON suite;
//if_stmt: IF expr COLON suite (elif_clause)* (else_clause)?;
//elif_clause: ELIF expr COLON suite;
//else_clause: ELSE COLON suite;
//for_stmt: FOR VARIABLE IN expr COLON suite;
//while_stmt: WHILE expr COLON suite;
//print_stmt: PRINT OPEN_B arg_list? CLOSE_B (NEWLINE | EOF);
//with_stmt: WITH expr (AS VARIABLE)? COLON suite;
//
////suite: (NEWLINE)* INDENT (statement | NEWLINE)* DEDENT;
//
//import_stmt: (FROM path)? IMPORT path (COMMA path)* (NEWLINE | EOF);
//path: (VARIABLE | DOT)+;
//
//assign_stmt: primary (NEWLINE)* ASSIGN (NEWLINE)* expr (NEWLINE | EOF);
//return_stmt: RETURN expr? (NEWLINE | EOF);
//expr_stmt: expr (NEWLINE | EOF);
//
//// --- تعديل قاعدة الـ expr لدعم العمليات المنطقية و != ---
//
//expr
//    : or_test                                            #logicalExpr
//    | primary FOR VARIABLE IN primary (IF expr)?         #listComprehension
//    ;
//
//or_test: and_test (OR (NEWLINE)* and_test)*;
//and_test: not_test (AND (NEWLINE)* not_test)*;
//not_test: NOT not_test | comparison;
//
//// هنا أضفنا NOT_EQUAL لكي يعمل كود الحذف
//comparison
//    : arithmeticExpr ( (EQUAL_CHECK | NOT_EQUAL | LESS_THAN | GREATER_THAN | LESS_EQUAL | GREATER_EQUAL) (NEWLINE)* arithmeticExpr )*
//    ;
//
//arithmeticExpr
//    : term ( (PLUS | MINUS) (NEWLINE)* term )*
//    ;
//
//term
//    : factor ( (MUL | DIV) (NEWLINE)* factor )*
//    ;
//
//factor
//    : (PLUS | MINUS) factor                             #unaryExpr
//    | primary                                           #toPrimary
//    ;
//
//// --------------------------------------------------
//
//primary
//    : atom                                      #atomExprPrimary
//    | primary DOT VARIABLE                      #attributeAccess
//    | primary OPEN_B arg_list? CLOSE_B          #functionCall
//    | primary LBRACK expr RBRACK                #listIndex
//    ;
//
//atom
//    : VARIABLE | NUMBER | FLOAT | STRING | NONE | TRUE | FALSE
//    | dict_literal | list_literal | OPEN_B expr CLOSE_B
//    ;
//
//arg_list: argument (COMMA (NEWLINE)* argument)*;
//argument: (VARIABLE ASSIGN)? expr;
//
//dict_literal: LBRACE (NEWLINE)* (kv_pair (COMMA (NEWLINE)* kv_pair)* (COMMA (NEWLINE)*)?)? (NEWLINE)* RBRACE;
//kv_pair: expr (NEWLINE)* COLON (NEWLINE)* expr;
//
//list_literal: LBRACK (NEWLINE)* (expr (COMMA (NEWLINE)* expr)* (COMMA (NEWLINE)*)?)? (NEWLINE)* RBRACK;
//param_list: (VARIABLE (ASSIGN expr)?) (COMMA (VARIABLE (ASSIGN expr)?))*;

parser grammar pythonParser;

options { tokenVocab=pythonLexer; }

@header {
package antlr;
}

prog
    : (statement | NEWLINE | INDENT | DEDENT)* EOF   #ProgramRule
    ;

statement
    : decorator_stmt                            #DecoratorStatementRule
    | import_stmt                               #ImportStatementRule
    | assign_stmt                               #AssignStatementRule
    | func_def                                  #FunctionDefinitionRule
    | if_stmt                                   #IfStatementRule
    | with_stmt                                 #WithStatementRule
    | for_stmt                                  #ForStatementRule
    | while_stmt                                #WhileStatementRule
    | print_stmt                                #PrintStatementRule
    | return_stmt                               #ReturnStatementRule
    | expr_stmt                                 #ExpressionStatementRule
    ;

suite
    : (NEWLINE)* INDENT (statement | NEWLINE)* DEDENT   #SuiteBlockRule
    ;

decorator_stmt
    : AT test NEWLINE statement   #DecoratorStmtRule
    ;

func_def
    : DEF VARIABLE OPEN_B param_list? CLOSE_B COLON suite   #FunctionDefRule
    ;

if_stmt
    : IF expr COLON suite (elif_clause)* (else_clause)?   #IfStmtRule
    ;

elif_clause
    : ELIF expr COLON suite   #ElifClauseRule
    ;

else_clause
    : ELSE COLON suite   #ElseClauseRule
    ;

for_stmt
    : FOR VARIABLE IN expr COLON suite   #ForStmtRule
    ;

while_stmt
    : WHILE expr COLON suite   #WhileStmtRule
    ;

print_stmt
    : PRINT OPEN_B arg_list? CLOSE_B (NEWLINE | EOF)   #PrintStmtRule
    ;

with_stmt
    : WITH expr (AS VARIABLE)? COLON suite   #WithStmtRule
    ;

import_stmt
    : (FROM path)? IMPORT path (COMMA path)* (NEWLINE | EOF)   #ImportStmtRule
    ;

path
    : (VARIABLE | DOT)+   #PathRule
    ;

assign_stmt
    : test (NEWLINE)* ASSIGN (NEWLINE)* expr (NEWLINE | EOF)   #AssignStmtRule
    ;

return_stmt
    : RETURN expr? (NEWLINE | EOF)   #ReturnStmtRule
    ;

expr_stmt
    : expr (NEWLINE | EOF)   #ExprStmtRule
    ;

expr
    : or_test                                   #LogicalExprRule
    | test FOR VARIABLE IN test (IF expr)?      #ListComprehensionRule
    ;

or_test
    : and_test (OR (NEWLINE)* and_test)* #OrTestRule
    ;

and_test
    : not_test (AND (NEWLINE)* not_test)* #AndTestRule
    ;

not_test
    : NOT not_test                              #NotExprRule
    | comparison                                #ComparisonExprRule
    ;

comparison
    : arithmeticExpr ( (EQUAL_CHECK | NOT_EQUAL | LESS_THAN | GREATER_THAN | LESS_EQUAL | GREATER_EQUAL) (NEWLINE)* arithmeticExpr )* #ComparisonRule
    ;

arithmeticExpr
    : term ( (PLUS | MINUS) (NEWLINE)* term )* #ArithmeticRule
    ;

term
    : factor ( (MUL | DIV) (NEWLINE)* factor )* #TermRule
    ;

factor
    : (PLUS | MINUS) factor                     #UnaryExprRule
    | test                                      #FactorToTestRule
    ;
test
    : atom (
        DOT VARIABLE
      | OPEN_B arg_list? CLOSE_B
      | LBRACK expr RBRACK
      )*
    ;

atom
    : VARIABLE              #VariableAtomRule
    | NUMBER                #NumberAtomRule
    | FLOAT                 #FLOATAtomRule
    | STRING                #StringAtomRule
    | NONE                  #NoneAtomRule
    | TRUE                  #TrueAtomRule
    | FALSE                 #FalseAtomRule
    | dict_literal          #DictAtomRule
    | list_literal          #ListAtomRule
    | OPEN_B expr CLOSE_B   #ParenAtomRule
    ;

arg_list
    : argument (COMMA (NEWLINE)* argument)* #ArgListRule
    ;

argument
    : (VARIABLE ASSIGN)? expr   #ArgumentRule
    ;

dict_literal
    : LBRACE (NEWLINE)* (kv_pair (COMMA (NEWLINE)* kv_pair)* (COMMA (NEWLINE)*)?)? (NEWLINE)* RBRACE   #DictLiteralRule
    ;

kv_pair
    : expr (NEWLINE)* COLON (NEWLINE)* expr   #KvPairRule
    ;

list_literal
    : LBRACK (
          expr (COMMA (NEWLINE)* expr)*
        | expr FOR VARIABLE IN expr (IF expr)?
      )? RBRACK
    ;

param_list
    : (VARIABLE (ASSIGN expr)?) (COMMA (VARIABLE (ASSIGN expr)?))* #ParamListRule
    ;