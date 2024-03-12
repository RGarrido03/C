grammar Geometry;

program: instruction* EOF;

instruction:
    assignment #InstructionAssignment
  | expression #InstructionExpression
  ;

assignment: expression '->' Identifier;

distance: 'distance' point point;

point: '(' expression ',' expression ')';

expression:
    distance    #ExpressionDistance
  | Number      #ExpressionNumber
  | Identifier  #ExpressionIdentifier
  ;

Number: [0-9]+;
Identifier: [a-zA-Z]+;
WhiteSpace: [ \r\t\n]+ -> skip;