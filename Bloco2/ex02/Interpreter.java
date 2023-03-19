@SuppressWarnings("CheckReturnValue")
public class Interpreter extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      if( ctx.expr()!=null ) {
         double res = visit(ctx.expr());
         System.out.println("Result: "+res);
      }
      return null;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      Double res = null;
      switch(ctx.op.getText()) {
         case "+":
            return visit(ctx.expr(0)) + visit(ctx.expr(1));
         case "-":
            return visit(ctx.expr(0)) - visit(ctx.expr(1));
         case "*":
            return visit(ctx.expr(0)) * visit(ctx.expr(1));
         case "/":
            return visit(ctx.expr(0)) / visit(ctx.expr(1));
         default:
            System.out.println("Invalid");
      }
      return 0.0;
   }
}
