grammar Hello;

greetings: (message ID+)+ EOF;
message: 'hello' | 'bye';
ID: [a-zA-Zá-ú]+;
WS: [ \t\r\n]+ -> skip;