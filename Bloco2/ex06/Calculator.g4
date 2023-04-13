grammar Calculator;

program:
        stat* EOF
    ;

stat:
        assigment? NEWLINE
    |   expr? NEWLINE
    ;

assigment:
        ID '=' expr
    ;

expr:
        op=('+'|'-') expr           #ExprPlusMinus
    |   expr op=('*'|'/'|'%') expr  #ExprMultDivMod
    |   expr op=('+'|'-') expr      #ExprAddSub
    |   ID                          #ExprId
    |   Integer                     #ExprInteger
    |   '(' expr ')'                #ExprParent
    ;

ID: [a-zA-Z_]+;
Integer: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;