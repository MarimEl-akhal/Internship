import java.util.Arrays;
import java.util.Scanner;

public class GravityFlip {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //no. of columns in box
        int  [] a = new int[n];  //no. of cubes in columns separated by space

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();

        }
         Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }




    }
}
