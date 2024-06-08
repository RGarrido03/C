grammar CSV;

program: header row* EOF;

header: row;
row: Value (Comma Value)* NL;

Value: ~[\n\r,;]+;
Comma: ',';
NL: '\r'? '\n';