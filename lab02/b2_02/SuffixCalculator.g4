grammar SuffixCalculator;

program: stat* EOF;

stat: expr? NEWLINE;

expr:
    expr expr op=('*'|'/'|'+'|'-')  #ExprSuffix
  | Number                          #ExprNumber
  ;

Number: [0-9]+('.'[0-9]+)?; // fixed point real number

NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;