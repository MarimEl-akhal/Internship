import java.util.Scanner;

public class iqTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // amount of numbers of in task

        int [] m = new int[n];

        for(int i =0 ;i<n;i++){
            m[i] = sc.nextInt();
        }
        int countEven = 0;
        int countOdd = 0;
        for(int i =0 ;i<n;i++){
            if(m[i]%2==0){
                countEven++;
            }
            else {
                countOdd++;
            }
        }
        boolean lookingForEven = countOdd > countEven  ;
        for(int i =0 ;i<n;i++){
            if(lookingForEven && m[i]%2==0){
                System.out.println(i+1);
                break;
            }
            else if(!lookingForEven && m[i]%2!= 0) {
                System.out.println(i+1);
            }
        }





    }
}
