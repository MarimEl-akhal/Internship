import java.util.* ;

public class LuckyTicket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // length of ticket number that needs to be checked (even integer)
        String tickets = input.next(); // TicketNumber =length of n



        int half = n/2;
        int sumFristHalf = 0;
        int sumSecondHalf = 0;

            boolean lucky = true;
        for (int i = 0 ; i < n ; i++) {
            char ch = tickets.charAt(i);
            if (ch != '4' && ch != '7') {
                 lucky = false;
                    break;

            } else if (!lucky) {
             System.out.println("NO");
             return;
            }
        }

            for (int j = 0 ; j < half ; j++) {
               sumFristHalf += tickets.charAt(j)  ;
               sumSecondHalf += tickets.charAt(j+half) ;

                }
            if (sumFristHalf == sumSecondHalf && lucky == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            }







    }

