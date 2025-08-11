import java.util.Scanner;

public class Bear_BigBrother {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //weight of limak
        int b = sc.nextInt(); // weight of Bob
         int yearsCount = 0;

         while (a <= b ){
            a *= 3 ;
             b *= 2 ;
             yearsCount++;
         }
        System.out.println(yearsCount);

    }
}
