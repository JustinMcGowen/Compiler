import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import java.io.*;
import java.util.List;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


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

    private static int registerNo = 4;

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
	          STListener listener = new STListener();
            new ParseTreeWalker().walk(listener, parser.program());
	          //listener.prettyPrint();

            // System.out.println(listener.nodeStack);
            //System.out.println(listener.astRoot.temp);
            System.out.println(generateCode(listener.nodeStack));


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

    public static String generateCode(Stack<ASTNode> nodeList){
      String code = "";
      while(nodeList.size()>0){
        code = generateNodeCode(nodeList.pop()) + code;
      }
      return code;
    }


    public static String generateNodeCode(ASTNode node){
      String code = "";
      if(node.temp.equals("WRITE")){
        if(node.getTypeFromChild().equals("STRING")){
          code = "sys writes "+node.leftRef.name+"\n";
        }
        if(node.getTypeFromChild().equals("INT")){
          code = "sys writei "+node.leftRef.name+"\n";
        }
        if(node.getTypeFromChild().equals("FLOAT")){
          code = "sys writer "+node.leftRef.name+"\n";
        }

      }
      if(node.temp.equals("READ")){
        if(node.getTypeFromChild().equals("STRING")){
          code = "sys reads "+node.leftRef.name+"\n";
        }
        if(node.getTypeFromChild().equals("INT")){
          code = "sys readi "+node.leftRef.name+"\n";
        }
        if(node.getTypeFromChild().equals("FLOAT")){
          code = "sys readr "+node.leftRef.name+"\n";
        }
      }
      if(node.temp.equals("VAR")){
        code = "var "+node.leftRef.name+"\n";
      }
      if(node.temp.equals(":=")){
        // if(node.leftRef.currRegister==null || node.leftRef.currRegister == ""){
        //   node.leftRef.currRegister = "r" + Integer.toString(registerNo++);
        // }
        if(node.getTypeFromChild().equals("STRING")){
          code = "str "+node.leftRef.name+" " + node.rightRef.name + "\n";
        }
        if(node.getTypeFromChild().equals("INT")){
          code = generateNodeCode(node.rightRef);
          code += "move r4 " + node.leftRef.name + "\n";
        }
        if(node.getTypeFromChild().equals("FLOAT")){
          code = generateNodeCode(node.rightRef);
          code += "move r4 " + node.leftRef.name + "\n";
        }
      }
      if(node.temp.equals("*") || node.temp.equals("/") || node.temp.equals("+") || node.temp.equals("-")){
        String opType = "";
        if(node.getTypeFromChild().equals("INT")){
          opType = "i";
        }
        if(node.getTypeFromChild().equals("FLOAT")){
          opType = "r";
        }

        if(node.leftRef == null){
          code = "move "+node.name+" r4\n";
        }else{
          int myReg1, myReg2, regStart;
          regStart = registerNo;
          code += generateNodeCode(node.leftRef);
          myReg1 = ++registerNo;
          code += "move r4 r"+myReg1+"\n";
          code += generateNodeCode(node.rightRef);
          myReg2 = ++registerNo;
          code += "move r4 r"+myReg2+"\n";
          switch(node.temp){
            case("*"):
              code += "mul"+opType;
              break;
            case("/"):
              code += "div"+opType;
              break;
            case("+"):
              code += "add"+opType;
              break;
            case("-"):
              code += "sub"+opType;
              break;
          }
          code += " r"+myReg2+" r"+myReg1+"\n";
          code += "move r"+myReg1+" r4\n";
          registerNo = regStart;
        }
      }
      if(node.value != null && node.value.equals("LITERAL")){
        code = "move "+ node.temp+" r4 \n";
      }
      if(node.type != null && (node.type.equals("INT") || node.type.equals("FLOAT"))){
        code = "move "+ node.temp+" r4 \n";
      }
      return code;
    }


}
