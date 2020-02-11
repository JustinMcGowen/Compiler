# Compiler
bcornett@ubuntu:~/csci468/setup1$ grun LITTLE tokens -tokens
"hello" PROGRAM graph 790 8.9  
[@0,0:6='"hello"',<STRINGLITERAL>,1:0]
[@1,8:14='PROGRAM',<KEYWORD>,1:8]
[@2,16:20='graph',<IDENTIFIER>,1:16]
[@3,22:24='790',<INTLITERAL>,1:22]
[@4,26:28='8.9',<FLOATLIETERAL>,1:26]
[@5,29:29='\n',<NEWLINE>,1:29]
[@6,30:29='<EOF>',<EOF>,2:0]

Seems to be parsing tokens correctly. Found this grun option by running it with no options "Use startRuleName='tokens' if GrammarName is a lexer grammar.":
bcornett@ubuntu:~/csci468/setup1$ grun
java org.antlr.v4.gui.TestRig GrammarName startRuleName
  [-tokens] [-tree] [-gui] [-ps file.ps] [-encoding encodingname]
  [-trace] [-diagnostics] [-SLL]
  [input-filename(s)]
Use startRuleName='tokens' if GrammarName is a lexer grammar.
Omitting input-filename makes rig read from stdin.
