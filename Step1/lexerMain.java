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
    //Checks Argument Input
    try{
    if (args.length !=1){
	    System.out.println("Invalid Input Amount. Exiting");
	    System.exit(1);
    }
    System.out.print("Starting Lexer Script\n");

    List<String> tokenNames = getTokenNames();
    CharStream s = CharStreams.fromFileName(args[0]);
    Lexer l = new LITTLE(s);   //LITTLE.java extends the Lexer class
    List<? extends Token> t = l.getAllTokens();

    //Once we have the tokens, we can get the token name and type with the following:
    /*System.out.println(t.get(0));
    System.out.println(t.get(0).getText());
    System.out.println(tokenNames.get(t.get(0).getType()));*/
    String fileOut = args[0];
    int position = fileOut.lastIndexOf(".");
    if (position > 0){
	fileOut = fileOut.substring(0,position);
    }
    String outString = "";
    for(int i = 0; i<t.size();i++){
      outString += "Token Type: ";
      outString += tokenNames.get(t.get(i).getType()) + "\n";
      outString += "Value: ";
      outString += t.get(i).getText() + "\n";
    }


    writeOutput(fileOut+".out",outString);
  }catch(Exception e){System.out.println("File Handle Exception. Exiting.");System.exit(1);}
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

	System.out.println("Removing old file.");
	out.delete();
	System.out.println("Creating new file.");
	out.createNewFile();
	System.out.println("File created: " + out.getName());
      }
      FileWriter write = new FileWriter(filename);
      write.write(stuff);
      write.close();
  }

}
