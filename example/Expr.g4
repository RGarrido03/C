grammar Expr;

// main é um símbolo sintático
// Exemplo de recursão main: (stat | stat main)* EOF;
main: stat* EOF;

stat: assignment | expression;

// '=' é um símbolo léxico definido implicitamente
assignment: Identifier '=' expression;

expression: Integer | Identifier;

// Começa com uma letra ou underscore, seguido de 0 ou mais letras, números ou _
Identifier: [a-zA-Z_][a-zA-Z_0-9]*;

// Definir um int
Integer: [0-9]+;

// Ignorar espaço, \t, \r e \n
WhiteSpace: [ \t\r\n]+ -> skip;