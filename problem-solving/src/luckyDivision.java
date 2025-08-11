import java.util.*;



public class luckyDivision {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next(); // the number that needs to be checked

        if (isLucky(s)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    public static boolean isLucky(String m) {

               int n = Integer.parseInt(m);
                if (n % 4 == 0 || n % 7 == 0 || n % 47 == 0) {
                    return true;
                }
                m = m.replace("4","" );
                m = m.replace("7","");
                if(m.length()==0) {
                    return true;
                }

                return false;
    }




}
