package daily.TwentyFive.thirteenthAug;

import java.util.Scanner;

public class IsPowerOf3 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(is(n));
    }
    public static boolean is(int n){
        int pow =1;
        while(pow<=n){
            if(n==pow)
                return true;
            pow=pow*3;
        }
        return false;
    }
}
