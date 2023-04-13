import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Double> {
   private static HashMap<String, Double> variables;

   @Override public Double visitProgram(CalculatorParser.ProgramContext ctx) {
      variables = new HashMap<>();
      return visitChildren(ctx);
   }

   @Override public Double visitStat(CalculatorParser.StatContext ctx) {
      if( ctx.expr()!=null ) {
         double res = visit(ctx.expr());
         System.out.println(res);
      } else {
         return visit(ctx.assigment());
      }
      return null;
   }

   @Override public Double visitAssigment(CalculatorParser.AssigmentContext ctx) {
      variables.put(ctx.ID().getText(), visit(ctx.expr()));
      return null;
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
   }

   @Override public Double visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Double visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Double.parseDouble(ctx.Integer().getText());
   }

   @Override public Double visitExprId(CalculatorParser.ExprIdContext ctx) { 
      return variables.get(ctx.ID().getText());
   }

   @Override public Double visitExprPlusMinus(CalculatorParser.ExprPlusMinusContext ctx) {
      if( ctx.op.getText().equals("-") ) return -visit(ctx.expr());
      else return visit(ctx.expr());
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
   }
}
