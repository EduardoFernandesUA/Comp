@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(CalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(CalculatorParser.StatContext ctx) {
      if( ctx.expr()!=null ) {
         double res = visit(ctx.expr());
         System.out.println("= " + res);
      }
      return null;
      //return res;
   }

   @Override public Double visitExprPlusMinus(CalculatorParser.ExprPlusMinusContext ctx) {
      if( ctx.op.getText().equals("-") ) return -visit(ctx.expr());
      else return visit(ctx.expr());
      //return res;
   }
   
   @Override public Double visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      switch(ctx.op.getText()) {
         case "*":
            return visit(ctx.expr(0)) * visit(ctx.expr(1));
         case "/":
            return visit(ctx.expr(0)) / visit(ctx.expr(1));
         case "%":
            return visit(ctx.expr(0)) % visit(ctx.expr(1));
         default:
            System.out.println("ERROR");
      }
      return 0.0;
      //return res;
   }

   @Override public Double visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      switch(ctx.op.getText()) {
         case "+":
            return visit(ctx.expr(0)) + visit(ctx.expr(1));
         case "-":
            return visit(ctx.expr(0)) - visit(ctx.expr(1));
         default:
            System.out.println("ERROR");
      }
      return 0.0;
      //return res;
   }
   
   @Override public Double visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Double.parseDouble(ctx.Integer().getText());
      //return res;
   }

   @Override public Double visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
      //return res;
   }

}
