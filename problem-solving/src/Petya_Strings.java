import java.util.Scanner;

public class Petya_Strings {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s1  = input.nextLine().toLowerCase().toUpperCase();
        String s2 = input.nextLine().toLowerCase().toUpperCase();

        for (int i=0 ;i < s1.length();i++){

            if(s1.charAt(i) > s2.charAt(i)){
                System.out.println("1");
                return;
            }
            else if (s1.charAt(i) < s2.charAt(i)){
                System.out.println("-1");
                return;
            }



        }
     System.out.println("0");


    }
}
