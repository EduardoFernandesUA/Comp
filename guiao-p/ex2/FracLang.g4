grammar FracLang;

program: (stat ';')* EOF;

stat: display
    | declaration
    | expr
    ;

display: 'display' expr;

declaration: ID '<=' expr;

expr:
    op=('+'|'-') expr               # exprUnary
    | '(' expr ')'                  # exprParen
    | 'read' STRING                 # exprRead
    | 'reduce' expr                 # exprReduce
    | expr op=('*'|':') expr        # exprMultDiv
    | expr op=('+'|'-') expr        # exprSumSub
    | fraction                      # exprFraction
    | ID                            # exprID
    ;

fraction: INTEGER ('/' INTEGER)?;

ID: [a-z][a-z0-9]*;
INTEGER: [0-9]+;
STRING: '"' ~["]* '"';
WS: [ \r\n\t]+ -> skip;
COMMENT: '--'~[\n]* -> skip;