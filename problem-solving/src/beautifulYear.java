import java.util.*;


public class beautifulYear {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int  year=sc.nextInt();

        boolean flag=true;
        while (flag){
            year++;
            Set<Character> set=new HashSet<>();
            char [] digits=Integer.toString(year).toCharArray();
            for(char c:digits){
                if(!set.contains(c)){
                    set.add(c);
                }
            }

            if(set.size()== digits.length){
                System.out.println(year);
                flag=false;
            }

        }

    }
}
