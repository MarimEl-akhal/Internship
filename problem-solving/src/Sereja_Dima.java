import java.util.*;
public class Sereja_Dima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // the number of cards on the table
       int [] num = new int[n]; // The second line contains space-separated numbers on the cards from left to right. The numbers on the cards are distinct integers

        int countSerejaCards = 0;
        int countDimaCards = 0;
        int lastLeftCard = 0; // ArrayStart
        int lastRightCard = n-1; // Array start from 0 end to n-1 (ArrayEnd)


        for (int i = 0 ; i < n ; i++) {
           num[i] = sc.nextInt();
        }
            boolean playNow = true;

        while (lastLeftCard <= lastRightCard) {

            if(num[lastLeftCard] >= num[lastRightCard]) {
                if(playNow) {
                    countSerejaCards += num[lastLeftCard];
                } else {
                    countDimaCards += num[lastLeftCard];
                }
                lastLeftCard++; // move pointer to right

            } else if(num[lastLeftCard] <= num[lastRightCard]) {
                if(playNow){
                    countSerejaCards += num[lastRightCard];
                }
                 else {
                    countDimaCards += num[lastRightCard];
                }
                lastRightCard--; // move pointer to left
            }
            playNow = !playNow; // opposite operation to play


        }


        System.out.print(countSerejaCards + " " + countDimaCards);



    }
}