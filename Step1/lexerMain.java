import java.io.*;

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
    System.out.println(program);
  }

}
