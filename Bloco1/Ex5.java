package Bloco1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> numbs = new HashMap<>();

        File numbersFile = new File("numbers.txt");
        Scanner numbersSC = new Scanner(numbersFile);

        while( numbersSC.hasNext() ) {
            int a = numbersSC.nextInt();
            numbersSC.next();
            String b = numbersSC.next();
            numbs.put(b, a);
        }

        Scanner in = new Scanner(System.in);
        in.useDelimiter("[ \\-\\n]");
        int ret = 0;
        Integer acc = null;
        while( in.hasNext() ) {
            String word = in.next();
            if( numbs.containsKey(word) ) {
                int a = numbs.get(word);
                if( acc==null ) acc = a;
                else if( a>acc ) acc *= a;
                else {
                    ret += acc;
                    acc = a;
                }
            }
        }
        
        ret += acc;
        System.out.printf("Result: %d\n", ret);
        
        numbersSC.close();
        in.close();
    }
}
