grammar Ex05;

program:
        stat* EOF
    ;

stat:
        word* NEWLINE
    ;

word:
        [a-z]+
    ;

NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;