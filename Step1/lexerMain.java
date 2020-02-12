//import org.antlr.v4.runtime.ANTLRFileStream;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Lexer;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class lexerMain{

  public static void main(String[] args)throws Exception{
    System.out.print("Starting Lexer Script\n");

    File file = new File("./inputs/fibonacci.micro");

    BufferedReader br = new BufferedReader(new FileReader(file));

    String program = "";
    String st;
    while ((st = br.readLine()) != null) {
      program = program + st;
      //System.out.println(st);
    }
    //System.out.println(program);

    List<String> tokenNames = getTokenNames();

    //CodePointCharStream s = CharStreams.fromString(program, "name");
    CharStream s = CharStreams.fromFileName("./inputs/fibonacci.micro");

    Lexer l = new LITTLE(s);   //LITTLE.java extends the Lexer class
    List<? extends Token> t = l.getAllTokens();

    //System.out.println(l.getAllTokens());

    //once we have the tokens, we can get the token name and type with the following:
    /*System.out.println(t.get(0));
    System.out.println(t.get(0).getText());
    System.out.println(tokenNames.get(t.get(0).getType()));*/

    String outString = "";
    for(int i = 0; i<t.size();i++){
      outString += "Token Type: ";
      outString += tokenNames.get(t.get(0).getType()) + "\n";
      outString += "Value: ";
      outString += t.get(i).getText() + "\n";
    }

    writeOutput("./ProgramOutput/fibonacci.out",outString);



  }
  public static List<String> getTokenNames()throws Exception{
    File file = new File("./LITTLE.tokens");

    BufferedReader br = new BufferedReader(new FileReader(file));

    List<String> tokens = new ArrayList<String>();
    String st;
    while ((st = br.readLine()) != null) {
      int idx = Integer.parseInt(st.split("=")[1]);
      String name = st.split("=")[0];
      while(idx>tokens.size()){
        tokens.add(tokens.size(), "");
      }
      tokens.add(idx, name);
    }
    return tokens;
  }

  public static void writeOutput(String filename, String stuff)throws Exception{
    File out = new File(filename);
    if (out.createNewFile()) {
        System.out.println("File created: " + out.getName());
      } else {
        System.out.println("File already exists.");
      }
      FileWriter write = new FileWriter(filename);
      write.write(stuff);
      write.close();
  }

}
