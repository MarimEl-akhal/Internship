import java.util.Scanner;

public class lifeWithoutZeros {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
         int a = input.nextInt();
         int b = input.nextInt();

        //Sum of a,b
        int c = a + b ;

        int A_WithoutZeros = 0;
        int B_WithoutZeros = 0;
        int C_WithoutZeros = 0;

        A_WithoutZeros = removeZeros(a);
        B_WithoutZeros = removeZeros(b);
        C_WithoutZeros = removeZeros(c);

        if(A_WithoutZeros+B_WithoutZeros == C_WithoutZeros){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }



    }

    public static int removeZeros(int m){
        String noZeros = Integer.toString(m).replaceAll("0","");
        int result = Integer.parseInt( noZeros );

        return result ;
    }
}
