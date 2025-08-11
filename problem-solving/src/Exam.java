import java.util.*;
/// wrong


import static java.lang.Math.abs;

public class Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int firstEvan = 0;
        int lastOdd = 0;

        List <Integer> a = new ArrayList<>(); //number list ith position


        if( n==1 || n==2){
            System.out.println(1);
            System.out.println(1);
            return;
        }
        if (n==3){
            System.out.println(2);
            System.out.println("1 3");
            return;

        }

        if (n==4){
            System.out.println(4);
            System.out.println("3 1 4 2");
            return;
        }

        // odd number
        for (int i = 1; i <=n; i+=2) {
            a.add(i);
           // lastOdd = a.get(a.size()-1);
        }

        // even number
        for (int j =2; j <= n; j+=2) {
                a.add(j);
               // firstEvan = a.get(0);
        }


        System.out.println(a.size());
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + (i == a.size() - 1 ? "" : " "));
        }









    }
}
