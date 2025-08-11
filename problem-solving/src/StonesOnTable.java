import java.util.Scanner;

public class StonesOnTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n  = sc.nextInt();  // number of stones on the table.
        String s  = sc.next().toUpperCase();
        int result = 0; // number of problems
        for (int i = 0; i < n-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                result++;
            }
        }
        System.out.println(result);





    }
}
