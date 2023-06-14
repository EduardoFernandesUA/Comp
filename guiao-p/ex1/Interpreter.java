import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("CheckReturnValue")
public class Interpreter extends StrLangBaseVisitor<String> {

   private static Scanner sc = new Scanner(System.in);
   private static HashMap<String, String> vars;

   @Override public String visitProgram(StrLangParser.ProgramContext ctx) {
      vars = new HashMap<>();
      return visitChildren(ctx);
   }

   @Override public String visitStat(StrLangParser.StatContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitExprInput(StrLangParser.ExprInputContext ctx) {
      System.out.printf("%s", visit(ctx.expr()));
      String res = sc.nextLine();
      return res;
   }

   @Override public String visitExprID(StrLangParser.ExprIDContext ctx) {
      return vars.get(ctx.ID().getText());
   }

   @Override public String visitExprString(StrLangParser.ExprStringContext ctx) {
      String raw = ctx.getText();
      return raw.substring(1, raw.length()-1);
   }

   @Override public String visitPrint(StrLangParser.PrintContext ctx) {
      System.out.println(visit(ctx.expr()));
      return null;
   }

   @Override public String visitDeclare(StrLangParser.DeclareContext ctx) {
      String id = ctx.ID().getText();
      String expr = visit(ctx.expr());
      vars.put(id, expr);
      return null;
   }

   @Override public String visitExprParen(StrLangParser.ExprParenContext ctx) {
      return visit(ctx.expr());
   }

   @Override public String visitExprSub(StrLangParser.ExprSubContext ctx) {
      String a = visit(ctx.expr(0));
      a = a.replaceFirst(visit(ctx.expr(1)), "");
      return a;
   }

   @Override public String visitExprConcat(StrLangParser.ExprConcatContext ctx) {
      return visit(ctx.expr(0))+visit(ctx.expr(1));
   }

   @Override public String visitExprTrim(StrLangParser.ExprTrimContext ctx) {
      return visit(ctx.expr()).trim();
   }

   @Override public String visitExprSum(StrLangParser.ExprSumContext ctx) {
      return visit(ctx.expr(0))+visit(ctx.expr(1));
   }
}
