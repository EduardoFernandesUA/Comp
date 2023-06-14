grammar StrLang;

program: (stat? '\n')* EOF;

stat: 
    expr
    | declare
    | print
    ;

expr: 
    'input' '(' expr ')'    # exprInput
    | expr '/' expr         # exprConcat
    | '(' expr ')'          # exprParen
    | 'trim' expr           # exprTrim
    | expr '-' expr         # exprSub
    | expr '+' expr         # exprSum
    | ID                    # exprID
    | STRING                # exprString
    ;

print: 'print' expr;

declare: ID ':' expr;

ID: [a-zA-Z_][a-zA-Z0-9_]*;
STRING: '"' ~["]* '"';
WS: [ \t\r]+ -> skip;
LINE_COMMENT: '//' ~[\n]* -> skip;