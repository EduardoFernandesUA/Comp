import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings("CheckReturnValue")
public class Interpreter extends Ex05BaseVisitor<Double> {
   private static Map<String, Integer> numbers;

   @Override public Double visitProgram(Ex05Parser.ProgramContext ctx) {
      numbers = new HashMap<>();

      File numbersFile = new File("numbers.txt");
      try {
         Scanner numbersSC = new Scanner(numbersFile);
         
         while( numbersSC.hasNext() ) {
            int a = numbersSC.nextInt();
            numbersSC.next();
            String b = numbersSC.next();
            numbers.put(b, a);
         }
      } catch (Exception e) {
         // TODO: handle exception
      }
      
      return visitChildren(ctx);
   }
   
   @Override public Double visitStat(Ex05Parser.StatContext ctx) {
      Double res = null;
      for(TerminalNode word : ctx.Word()) {
         System.out.print(numbers.get(word.getText()) + " ");
      }
      System.out.println();
      return visitChildren(ctx);
      //return res;
   }
}
