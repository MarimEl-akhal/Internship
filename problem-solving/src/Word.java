import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s  = input.next(); //word
        int countUpper=0;
        int countLower=0;

        for (int i= 0 ; i < s.length() ; i++){
            if (Character.isUpperCase(s.charAt(i))){
                countUpper++;
            }
            else if (Character.isLowerCase(s.charAt(i))) {
                countLower++;
            }


        }
        if (countUpper>countLower){
            System.out.println(s.toUpperCase());
        }
        else {
            System.out.println(s.toLowerCase());
        }


    }
}
