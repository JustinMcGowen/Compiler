//Define grammar called LITTLE
lexer grammar LITTLE;

//program: 'PROGRAM' IDENTIFIER 'BEGIN' 'END';
//string_decl: 'STRING' IDENTIFIER ':=' str;
//str: STRINGLITERAL;

OPERATOR: ':='|'+'|'-'|'*'|'/'|'='|'!='|'<'|'>'|'('|')'|';'|','|'<='|'>=';
KEYWORD: 'PROGRAM'|'BEGIN'|'END'|'FUNCTION'|'READ'|'WRITE'|'IF'|'ELSE'|'ENDIF'|'WHILE'|'ENDWHILE'|'CONTINUE'|'BREAK'|'RETURN'|'INT'|'VOID'|'STRING'|'FLOAT';
IDENTIFIER: [A-z]([A-z]|[0-9])*;
INTLITERAL: [0-9]+;
FLOATLIETERAL: [0-9]*'.'[0-9]+;
STRINGLITERAL: '"'.+'"';
COMMENT: '--'.*NEWLINE;
NEWLINE : [\r\n]+ ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
