package Bloco1;
import java.util.Scanner;
import java.util.Stack;

public class Ex3 {
    public static void main(String[] args) {
        Stack<Double> st = new Stack<>();
        Scanner sc = new Scanner(System.in);

        while( sc.hasNextDouble() || sc.hasNext("[\\+\\-\\*\\/]") ) {
            if( sc.hasNextDouble() ) {
                st.add( sc.nextDouble() );
            } else {
                if( st.size()<2 ) System.out.println("Error!");
                String op = sc.next("[\\+\\-\\*\\/]");
                Double a = st.peek(); st.pop();
                Double b = st.peek(); st.pop();
                if( op.equals("+") )  st.add(a+b);
                else if( op.equals("-") )  st.add(a-b);
                else if( op.equals("*") )  st.add(a*b);
                else if( op.equals("/") )  st.add(a/b);
            }
        }

        System.out.printf("Result: %f\n", st.peek());
    }
}
