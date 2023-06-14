import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Fraction> {
   private final HashMap<String, Fraction> vars = new HashMap<>();

   @Override public Fraction visitProgram(CalculatorParser.ProgramContext ctx) {
      System.out.println("Fraction Calculator:");
      return visitChildren(ctx);
   }

   @Override public Fraction visitStat(CalculatorParser.StatContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitAssigment(CalculatorParser.AssigmentContext ctx) {
      vars.put(ctx.ID().getText(), visit(ctx.expr()));
      return null;
   }

   @Override public Fraction visitPrint(CalculatorParser.PrintContext ctx) {
      System.out.println( visitChildren(ctx) );
      return null;
   }

   @Override public Fraction visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Fraction left = visit(ctx.expr(0));
      Fraction right = visit(ctx.expr(1));
      if( ctx.op.getText().equals("+") ) return left.addTo(right);
      else if( ctx.op.getText().equals("-") ) return left.subTo(right);
      return null;
   }

   @Override public Fraction visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());

   }

   @Override public Fraction visitExprReduce(CalculatorParser.ExprReduceContext ctx) {
      Fraction f = visit(ctx.expr());
      f.reduce();
      return f;
   }

   @Override public Fraction visitExprPlusMinus(CalculatorParser.ExprPlusMinusContext ctx) {
      return null;
   }

   @Override public Fraction visitExprId(CalculatorParser.ExprIdContext ctx) {
      return vars.get(ctx.ID().getText());
   }

   @Override public Fraction visitExprFraction(CalculatorParser.ExprFractionContext ctx) {
      String[] ff = ctx.getText().split("/");
      Fraction f;
      if( ff[0].charAt(0)=='-' ) f = new Fraction( -Integer.parseInt( ff[0].substring(1) ) );
      else f = new Fraction( Integer.parseInt( ff[0] ));

      if( ff.length==2 ) {
         if( ff[1].charAt(0)=='-' ) f.setDenominator( -Integer.parseInt( ff[1].substring(1) ) );
         else f.setDenominator( Integer.parseInt( ff[1] ) );
      }
      return f;
   }

   @Override public Fraction visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Fraction left = visit(ctx.expr(0));
      Fraction right = visit(ctx.expr(1));
      if( ctx.op.getText().equals("*") ) return left.mulTo(right);
      else if( ctx.op.getText().equals(":") ) return left.divTo(right);
      else if( ctx.op.getText().equals("%") ) return left.mulTo(right); // TODO: add mod to fraction class
      return null;
   }
}
