import java.util.Scanner;

public class tavasAndNafas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String [] from0To19 ={"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen"};
        String [] from20To90 ={"","",  "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety"};


        String result = "";
        if (s<20){
            System.out.println(from0To19[s]);
        }
        else {
            int n = s/10;
            int m = s%10;
            if (m==0){
            result  =  from20To90[n]; // (or n-2 in case remove "","" in from20To90) because start from 20 => 20/10 = 2 so a[2-2] = "twenty"
            }
            else {
              result =  from20To90[n] + "-" + from0To19[m];

            }
            System.out.println(result);
        }






    }
}
