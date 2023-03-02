package Bloco1;
import java.util.Scanner;
import java.util.regex.Pattern;

class Ex1 {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("\n\n ---- CALCULATOR ----");
        while( sc.hasNextLine() ) {
            Scanner sl = new Scanner(sc.nextLine());

            if( sl.hasNextDouble() ) {
                double a = sl.nextDouble();
                if( !sl.hasNext() ) System.out.printf("%f\n\n", a);
                else if( sl.hasNext(Pattern.compile("[\\+\\-\\*\\/]")) ) {
                    String op = sl.next();
                    if( sl.hasNextDouble() ) {
                        double b = sl.nextDouble();
                        double res = calcDoubles(a, op, b);
                        System.out.printf("Result: %f\n\n", res);
                    } else {
                        System.out.println("Invalid Input\n");
                    }
                } else {
                    System.out.println("Invalid Input\n");
                }
            }
        }
    }

    public static double calcDoubles( double a, String op, double b ) {
        if( op.equals("+") ) {
            return a+b;
        } else if( op.equals("-") ) {
            return a-b;
        } else if( op.equals("*") ) {
            return a*b;
        } else if( op.equals("/") ) {
            return a/b;
        } else {
            return 0;
        }
    }
}