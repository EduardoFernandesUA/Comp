grammar BigGrammar;

program: (stat ';')* EOF;

stat: 
    assign
    | show
    ;

assign: expr '->' ID;
show: 'show' expr;

expr: 
    op=('-'|'+') expr # exprUnary
    | expr op=('*'|'div'|'mod') expr #exprMultDivMod
    | expr op=('+'|'-') expr #exprSumSub
    | '(' expr ')' #exprParen
    | NUMBER # exprNumber
    | ID   # exprID
    ;

ID: [a-zA-Z][a-zA-Z0-9]*;
NUMBER: [0-9]+;
WS: [ \n\t\r] -> skip;
COMMENT: [#] ~[\n]* [\n] -> skip;