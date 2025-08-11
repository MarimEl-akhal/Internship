import java.util.Scanner;

public class stringTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  s = sc.next().toLowerCase();
        String  vowels = "aeiouyAEIOUY";




        for (int i = 0; i<s.length();i++) {
            char ch = s.charAt(i);
            if( vowels.indexOf(ch) == -1) {
                System.out.print("."+ ch);
                continue;
            }

        }


    }
}
