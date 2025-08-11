import java.util.Scanner;

public class Bit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //the number of statements in the programme.

        int x = 0 ;

       for (int i = 1; i <= n; i++) {
           String op = input.next();
           if(op.charAt(0)=='X'){
               if(op.charAt(1)=='+'){
                   x++;
               }
                if(op.charAt(1)=='-'){
                   x--;
               }
           } else if(op.charAt(0)=='+'){
                   ++x;
           }
               else {
                   --x;
               }

        }

        System.out.println(x);
    }
}
