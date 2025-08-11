import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int view = 0;
         int count=0; // no.of friends sure from solution
        int problemCount = 0; //count problem be implemend

        for(int i=1;i<=n;i++){
            count = 0 ;
            for(int j=1;j<=3 ;j++){
                view = sc.nextInt();
                if(view == 1){
                    count++;
                }
            }
            if(count >= 2 ){
                problemCount++;
            }


        }
        System.out.println(problemCount);
    }
}
