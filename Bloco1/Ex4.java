package Bloco1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Ex4 {
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
        String ret = "";
        while( in.hasNext() ) {
            String word = in.next();
            if( numbs.containsKey(word) ) ret += numbs.get(word) + " ";
            else ret += word + " ";
        }

        System.out.println(ret);

        numbersSC.close();
        in.close();
    }
}
