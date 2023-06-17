import java.math.BigInteger;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Interpreter extends BigGrammarBaseVisitor<BigInteger> {

   private HashMap<String, BigInteger> vars;

   @Override public BigInteger visitProgram(BigGrammarParser.ProgramContext ctx) {
      vars = new HashMap<>();
      return visitChildren(ctx);
   }
   
   @Override public BigInteger visitStat(BigGrammarParser.StatContext ctx) {
      return visitChildren(ctx);
   }

   @Override public BigInteger visitAssign(BigGrammarParser.AssignContext ctx) {
      vars.put(ctx.ID().getText(), visit(ctx.expr()));
      return null;
   }

   @Override public BigInteger visitShow(BigGrammarParser.ShowContext ctx) {
      System.out.println(visit(ctx.expr()));
      return null;
   }

   @Override public BigInteger visitExprNumber(BigGrammarParser.ExprNumberContext ctx) {
      Long a = Long.parseLong(ctx.NUMBER().getText());
      return BigInteger.valueOf(a);
   }

   @Override public BigInteger visitExprID(BigGrammarParser.ExprIDContext ctx) {
      if( !vars.containsKey(ctx.ID().getText()) ) {
         throw new Error("Line: "+ctx.start.getLine()+", Variable not defined");
      }
      return vars.get(ctx.ID().getText());
   }

   @Override public BigInteger visitExprUnary(BigGrammarParser.ExprUnaryContext ctx) {
      if( ctx.op.getText().equals("-") ) {
         return visit(ctx.expr()).multiply(BigInteger.valueOf(-1));
      } else {
         return visit(ctx.expr());
      }
   }

   @Override public BigInteger visitExprMultDivMod(BigGrammarParser.ExprMultDivModContext ctx) {
      if( ctx.op.getText().equals("*") ) {
         return visit(ctx.expr(0)).multiply(visit(ctx.expr(1)));
      } else if( ctx.op.getText().equals("div") ) {
         return visit(ctx.expr(0)).divide(visit(ctx.expr(1)));
      } else {
         return visit(ctx.expr(0)).mod(visit(ctx.expr(1)));
      }
   }
   @Override public BigInteger visitExprSumSub(BigGrammarParser.ExprSumSubContext ctx) {
      if( ctx.op.getText().equals("+") ) {
         return visit(ctx.expr(0)).add(visit(ctx.expr(1)));
      } else {
         return visit(ctx.expr(0)).subtract(visit(ctx.expr(1)));
      }
   }
   @Override public BigInteger visitExprParen(BigGrammarParser.ExprParenContext ctx) {
      return visit(ctx.expr());
   }

}
