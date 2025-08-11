import java.util.Scanner;

public class Anton_Danik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no.of games played
         String s = sc.next(); // 'A' or 'D'

         int count_Anton = 0; // count wins Anton
         int count_Danik = 0; // count wins Danik

         for (int i = 0; i < n; i++) {
             if (s.charAt(i) == 'A') {
                 count_Anton++;
             } else {
                 count_Danik++;
             }

         }


        if(count_Anton > count_Danik){
            System.out.println("Anton");
        }
        else if (count_Anton < count_Danik) {
            System.out.println("Danik");
        }
        else {
            System.out.println("Friendship");
        }

          //sc.close();



    }

}