grammar Ex05;

program:
        stat* EOF
    ;

stat:
        Word* NEWLINE
    ;

Word:
        [a-z]+
    ;

NEWLINE: '\r'? '\n';
WS: [ \-\t]+ -> skip;