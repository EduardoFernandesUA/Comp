@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitStat(CalculatorParser.StatContext ctx) {
      visitChildren(ctx);
      System.out.println();
      return null;
   }

   @Override public Double visitAssigment(CalculatorParser.AssigmentContext ctx) {
      System.out.printf("%s = ", ctx.ID().getText());
      visit(ctx.expr());
      return null;
   }

   @Override public Double visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      visit(ctx.expr(0));
      visit(ctx.expr(1));
      System.out.printf("%s ", ctx.op.getText());
      return null;
   }

   @Override public Double visitExprParent(CalculatorParser.ExprParentContext ctx) {
      visit(ctx.expr());
      return null;
   }

   @Override public Double visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      System.out.printf("%s ", ctx.Integer().getText());
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitExprPlusMinus(CalculatorParser.ExprPlusMinusContext ctx) {
      visit(ctx.expr());
      System.out.printf("!%s ", ctx.op.getText());
      return null;
   }

   @Override public Double visitExprId(CalculatorParser.ExprIdContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      visit(ctx.expr(0));
      visit(ctx.expr(1));
      System.out.printf("%s ", ctx.op.getText());
      return null;
   }
}
