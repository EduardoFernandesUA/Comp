@SuppressWarnings("CheckReturnValue")
public class Interpreter extends PrefixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(PrefixCalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitStat(PrefixCalculatorParser.StatContext ctx) {
      if( ctx.expr()!=null ) {
         double res = visit(ctx.expr());
         System.out.println("Result: "+res);
      }
      return null;
   }

   @Override public Double visitExprSuffix(PrefixCalculatorParser.ExprSuffixContext ctx) {
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

   @Override public Double visitExprNumber(PrefixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
      //return res;
   }
}
