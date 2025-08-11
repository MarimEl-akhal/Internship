import java.util.*;

public class nearlyLuckyNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       String n =sc.next();

            int luckyDigitCount = 0;
            for (int i = 0; i < n.length(); i++) {
                char c = n.charAt(i);
                if (c == '4' || c == '7') {
                    luckyDigitCount++;
                }
            }

            if (luckyDigitCount == 4 || luckyDigitCount == 7) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }



    }
}


