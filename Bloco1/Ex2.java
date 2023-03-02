package Bloco1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex2 {
    private enum tokens {
        NUMBER, EXPRESSION, ID, NONE, EQUAL
    }

    private static Scanner sc = new Scanner(System.in);
    private static Map<String, Double> m;

    public static void main(String[] args) {
        m = new HashMap<>();
        while( sc.hasNextLine() ) {
            Scanner sf = new Scanner(sc.nextLine());

            if( sf.hasNextDouble() ) System.out.printf("> %f\n\n", solveExpression(sf));
            else if( sf.hasNext("[a-z]+") ) {
                String id = sf.next();
                if( sf.hasNext("=") ) {
                    sf.next();
                    double res = solveExpression(sf);
                    m.put(id, res);
                    System.out.printf("\n");
                    //System.out.printf("Inserted: %s %f -> %f\n\n", id,res,m.get(id));
                } else {
                    System.out.printf("> %f\n\n", solveExpression(sf, id), id);
                }
            }
        }
    }


    public static Double solveExpression(Scanner line) { return solveExpression(line, ""); }
    public static Double solveExpression(Scanner line, String id) {
        double a = 0,b = 0;
        String op;

        // get a
        //System.out.println("ID:"+id);
        if( !id.equals("") ) a = m.get(id);
        else if( line.hasNext("[a-z]+") ) a = m.get(line.next()); // calculate a // TODO: needs to check for invalid ID
        else if( line.hasNextDouble() ) a = line.nextDouble();

        // get op
        if( !line.hasNext() ) return a;
        else if( line.hasNext("[\\+\\-\\*\\/]") ) op = line.next();
        else { System.out.println("Invalid Expression"); return 0.0; }

        // get b
        if( line.hasNext("[a-z]+") ) b = m.get(line.next()); // calculate a // TODO: needs to check for invalid ID
        else if( line.hasNextDouble() ) b = line.nextDouble();

        if( op.equals("+") ) return a+b;
        if( op.equals("-") ) return a-b;
        if( op.equals("*") ) return a*b;
        if( op.equals("/") ) return a/b;
        return 0.0;
    }

}
