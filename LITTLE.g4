//Define grammar called LITTLE
lexer grammar LITTLE;

//program: 'PROGRAM' IDENTIFIER 'BEGIN' 'END';
//string_decl: 'STRING' IDENTIFIER ':=' str;
//str: STRINGLITERAL;

OPERATOR: ':='|'+'|'-'|'*'|'/'|'='|'!='|'<'|'>'|'('|')'|';'|','|'<='|'>=';
KEYWORD: 'PROGRAM'|'BEGIN'|'END'|'FUNCTION'|'READ'|'WRITE'|'IF'|'ELSE'|'ENDIF'|'WHILE'|'ENDWHILE'|'CONTINUE'|'BREAK'|'RETURN'|'INT'|'VOID'|'STRING'|'FLOAT';
IDENTIFIER: [A-z]([A-z]|[0-9])*;
INTLITERAL: [0-9]+;
FLOATLITERAL: [0-9]*'.'[0-9]+;
STRINGLITERAL: '"'.*?'"';

COMMENT: '--'.*?[\r\n] -> skip; //skip comments
WS : [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines
