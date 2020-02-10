//Define grammar called LITTLE
grammar LITTLE;

program: 'PROGRAM' IDENTIFIER 'BEGIN' 'END';

IDENTIFIER: [A-z]([A-z]|[0-9])*;
INTLITERAL: [0-9]+;
FLOATLIETERAL: [0-9]*.[0-9]+;
STRINGLITERAL: '"'.+'"';
COMMENT: '--'.*NEWLINE;
NEWLINE : [\r\n]+ ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
