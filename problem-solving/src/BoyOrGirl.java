import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoyOrGirl {
    public  static void main(String[] args) {
        Scanner input = new Scanner(System.in);
           String s = input.next().toLowerCase(); // username

        Set<Character> distinctCharacters = new HashSet<>();

           for(char ch : s.toCharArray()){
               distinctCharacters.add(ch);
           }
               if (distinctCharacters.size() % 2 ==0){
                    System.out.println("CHAT WITH HER!");
               }
               else{
                   System.out.println("IGNORE HIM!");
               }





    }

}
