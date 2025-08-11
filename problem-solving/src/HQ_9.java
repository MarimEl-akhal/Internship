import java.util.Scanner;

public class HQ_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String p = sc.nextLine();

        for (int i = 0; i <= p.length(); i++) {
            if(p.contains("H")|| p.contains("Q") ||p.contains("9") ){
                System.out.println("YES");
                break;
            }
            else{
                System.out.println("NO");
                break;
            }
        }


    }
}
