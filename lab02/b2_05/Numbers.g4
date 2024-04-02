grammar Numbers;

program: stat* EOF;
stat: expr? NEWLINE;

expr:
    Integer '-' Name                # ExprMap
  | ('A list of numbers:')? Name+   # ExprParsing
  ;

Integer: [0-9]+;
Name: [a-z-]+;
WS: [ \t]+ -> skip;
NEWLINE: '\r'? '\n';
