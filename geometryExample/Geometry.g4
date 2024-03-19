grammar Geometry;

program: instruction* EOF;

instruction:
    assignment #InstructionAssignment
  | expression #InstructionExpression
  ;

assignment: expression '->' Identifier;

distance returns [Double res]: 'distance' point point;

point returns [Double x, Double y]: '(' expression ',' expression ')';

expression returns [Double res]:
    expression op=('*' | '/') expression    #ExpressionMultDiv
  | expression op=('+' | '-') expression    #ExpressionSumSub
  | '(' expression ')'                      #ExpressionPriority
  | distance                                #ExpressionDistance
  | Number                                  #ExpressionNumber
  | Identifier                              #ExpressionIdentifier
  ;

Number: [0-9]+;
Identifier: [a-zA-Z]+;
WhiteSpace: [ \r\t\n]+ -> skip;