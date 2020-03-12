import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Lexer;
import java.io.*;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class lexerMain {

    public static void main(String[] args) throws Exception {
        //Checks Argument Input
        try {
            if (args.length != 1) {
                System.out.println("Invalid Arguments. Exiting");
                System.exit(1);
            }
            System.out.println("Building Lexer...");

            CharStream charStream = CharStreams.fromFileName(args[0]);
            Lexer lexer = new LITTLE(charStream);   //LITTLE.java extends the Lexer class

            System.out.println("Scanning Program...\n");
            List<String> tokenNames = getTokenNames();
            List<? extends Token> tokenList = lexer.getAllTokens();

            String outputString = getOutput(tokenList, tokenNames);
            //writeMode 0 will print to console, writeMode 1 will print to output file
            writeOutput(1, outputString, args[0]);

        } catch (Exception e) {
            System.out.println("File Handle Exception. Exiting.");
            System.exit(1);
        }
    }


    public static List<String> getTokenNames() throws Exception {
        File file = new File("./LITTLE.tokens");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> tokens = new ArrayList<String>();
        String st;
        while ((st = br.readLine()) != null) {
            int idx = Integer.parseInt(st.split("=")[1]);
            String name = st.split("=")[0];
            while (idx > tokens.size()) {
                tokens.add(tokens.size(), "");
            }
            tokens.add(idx, name);
        }
        return tokens;
    }

    public static String getOutput(List<? extends Token> tokenList, List<String> tokenNames) {
        String outString = "";
        for (int i = 0; i < tokenList.size(); i++) {
            outString += "Token Type: ";
            outString += tokenNames.get(tokenList.get(i).getType()) + "\n";
            outString += "Value: ";
            outString += tokenList.get(i).getText() + "\n";
        }
        return outString;
    }

    public static void writeOutput(int writeMode, String output, String fileIn) throws Exception {
        if (writeMode == 0) {
            //Print to console
            System.out.println("--------------------------------\nTOKEN LIST:\n");
            System.out.println(output);
            System.out.println("--------------------------------");

        } else if (writeMode == 1) {
            //Print to output file, same location as input file
            String fileOut = fileIn;
            int position = fileOut.lastIndexOf(".");
            if (position > 0) {
                fileOut = fileOut.substring(0, position);
            }
            fileOut = fileOut.concat(".out");
            File outputFile = new File(fileOut);
            if (!outputFile.createNewFile()) {
                System.out.println("File already exists.");
                System.out.println("Removing old file.");
                outputFile.delete();
                System.out.println("Creating new file.");
            } else {
                outputFile.createNewFile();
                System.out.println("File created: " + outputFile.getName());
                FileWriter writer = new FileWriter(fileOut);
                writer.write(output);
                writer.close();
            }

        }

    }

}
