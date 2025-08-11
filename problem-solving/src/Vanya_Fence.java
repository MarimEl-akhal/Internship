import java.util.Scanner;

public class Vanya_Fence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //no. of friends
        int h = sc.nextInt(); //height of fance
        int minWidth = 0;

        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt(); // height of the i-th friends
            if(a>h){
                minWidth += 2;
            } else{
                minWidth += 1;
            }
        }
        System.out.println(minWidth);

    }
}
