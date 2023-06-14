import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("CheckReturnValue")
public class Interpreter extends FracLangBaseVisitor<Fraction> {

   private static Scanner sc = new Scanner(System.in);

   private HashMap<String, Fraction> vars = new HashMap<>();

   private static void throwSemantic(int line, String text) {
      throw new Error("At line "+line+": "+text);
   }

   @Override public Fraction visitProgram(FracLangParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitStat(FracLangParser.StatContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
      Fraction.println(visit(ctx.expr()));
      return null;
   }

   @Override public Fraction visitDeclaration(FracLangParser.DeclarationContext ctx) {
      String id = ctx.ID().getText();
      Fraction expr = visit(ctx.expr());
      vars.put(id, expr);
      return null;
   }

   @Override public Fraction visitExprFraction(FracLangParser.ExprFractionContext ctx) {
      return visit(ctx.fraction());
   }

   @Override public Fraction visitFraction(FracLangParser.FractionContext ctx) {
      int num = Integer.parseInt(ctx.INTEGER(0).getText());
      int den = ctx.INTEGER(1)!=null ? Integer.parseInt(ctx.INTEGER(1).getText()) : 1;
      return new Fraction(num, den);
   }

   @Override public Fraction visitExprID(FracLangParser.ExprIDContext ctx) {
      if( !vars.containsKey(ctx.ID().getText()) ) throwSemantic(ctx.getStart().getLine(), "Variable not declared!");
      return vars.get(ctx.ID().getText());
   }

   @Override public Fraction visitExprUnary(FracLangParser.ExprUnaryContext ctx) {
      int a = ctx.op.getText().equals("+") ? 1 : -1;
      return Fraction.mult(new Fraction(a), visit(ctx.expr()));
   }

   @Override public Fraction visitExprMultDiv(FracLangParser.ExprMultDivContext ctx) {
      if( ctx.op.getText().equals("*") ) {
         return Fraction.mult(visit(ctx.expr(0)), visit(ctx.expr(1)));
      } else {
         return Fraction.div(visit(ctx.expr(0)), visit(ctx.expr(1)));
      }
   }

   @Override public Fraction visitExprSumSub(FracLangParser.ExprSumSubContext ctx) {
      if( ctx.op.getText().equals("+") ) {
         return Fraction.sum(visit(ctx.expr(0)), visit(ctx.expr(1)));
      } else {
         return Fraction.sub(visit(ctx.expr(0)), visit(ctx.expr(1)));
      }
   }
   
   @Override public Fraction visitExprParen(FracLangParser.ExprParenContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Fraction visitExprRead(FracLangParser.ExprReadContext ctx) {
      System.out.printf("%s", ctx.STRING().getText());
      System.out.print("num: ");
      int a = sc.nextInt();
      System.out.print("den: ");
      int b = sc.nextInt();
      return new Fraction(a, b);
   }

   @Override public Fraction visitExprReduce(FracLangParser.ExprReduceContext ctx) {
      return Fraction.reduce(visit(ctx.expr()));
   }

}
