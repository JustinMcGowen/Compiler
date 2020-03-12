import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import java.io.*;
import java.util.List;

import java.util.ArrayList;
import java.util.List;


import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;

import javax.print.PrintException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class grammarMain {

    public static final String LEXER_START_RULE_NAME = "OPERATOR";
    private static LITTLEParser parser;

    public static void main(String[] args) throws Exception {
        //Checks Argument Input
        try {
            if (args.length != 1) {
                System.out.println("Invalid Arguments. Exiting");
                System.exit(1);
            }
            //System.out.println("Building Parser...");

            CharStream charStream = CharStreams.fromFileName(args[0]);
            LITTLELexer lexer = new LITTLELexer(charStream);   //LITTLE.java extends the Lexer class
            CommonTokenStream cts = new CommonTokenStream(lexer);
            parser = new LITTLEParser(cts);
            // = parser.getErrorHandler();
            ANTLRErrorStrategy handler = new DefaultErrorStrategy(){
                @Override
                public void reportError(Parser recognizer, RecognitionException e) {
                    //Logger.getLogger(MyClass.class .getName()).info(message);
                    //System.out.println(message);
                    System.out.println("Not accepted");
                    System.exit(1);
                }
                @Override
                public void reportNoViableAlternative(Parser recognizer,NoViableAltException e) {
                    //Logger.getLogger(MyClass.class .getName()).info(message);
                    //System.out.println(message);
                    //System.out.println("got here");
                    //System.out.println("got here");
                }
            };
            parser.setErrorHandler(handler);
            parser.program();
            //System.out.println(parser.getNumberOfSyntaxErrors());
            if(parser.getNumberOfSyntaxErrors() == 0){
              System.out.println("Accepted");
            }
            //System.out.println(parser.getTrimParseTree() );
            //Class<? extends Parser> pClass = null;
            //ClassLoader cl = Thread.currentThread().getContextClassLoader();
            //pClass = cl.loadClass(parserName).asSubclass(Parser.class);
			      //Constructor<? extends Parser> parserCtor = pClass.getConstructor(TokenStream.class);
            //process(lexer, pClass,parser, charStream);


            //parser.compileParseTreePattern("PROGRAM id BEGIN pgm_body END", 0);

        } catch (Exception e) {
            System.out.println("File Handle Exception. Exiting.");
            System.exit(1);
        }
    }

    protected static void process(Lexer lexer, Class<? extends Parser> parserClass, Parser parser, CharStream input) throws IOException, IllegalAccessException, InvocationTargetException, PrintException {
          String startRuleName = "program";

          lexer.setInputStream(input);
    			CommonTokenStream tokens = new CommonTokenStream(lexer);

          tokens.fill();

    			if ( startRuleName.equals(LEXER_START_RULE_NAME) ) return;

    			parser.setTokenStream(tokens);
    			parser.setTrace(false);

    			try {
            Method startRule = parserClass.getMethod(startRuleName);
    				ParserRuleContext tree = (ParserRuleContext)startRule.invoke(parser, (Object[])null);


    			}
    			catch (NoSuchMethodException nsme) {
    				System.err.println("No method for rule "+startRuleName+" or it has arguments");
    			}

    		}
    }
