grammar Calculator;

program:
        stat* EOF
    ;

stat:
        assigment? ENDLINE
    |   print? ENDLINE
    ;

assigment:
        expr '->' ID
    ;

print:
        'print' expr
    ;

expr:
        'reduce' expr               #ExprReduce
    |   op=('+'|'-') expr           #ExprPlusMinus
    |   expr op=('*'|':'|'%') expr  #ExprMultDivMod
    |   expr op=('+'|'-') expr      #ExprAddSub
    |   ID                          #ExprId
    |   Fraction                    #ExprFraction
    |   '(' expr ')'                #ExprParent
    ;

Fraction: 
        [0-9]+ '/' [1-9]+
    |   '-' [0-9]+ '/' [1-9]+
    |   [0-9]+ '/' '-' [1-9]+
    |   [0-9]+
    ;

ID: [a-zA-Z_]+;
Integer: [0-9]+;
ENDLINE: ';';
WS: [ \t\n]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;