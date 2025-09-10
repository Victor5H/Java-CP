package dp.pepCoding;

import java.util.Arrays;

public class ClimbingStairs {
//    number of paths to from n to 0th stair
    public static int recursion(int n){
        if (n==0) return 1;
        int count = 0;
        for (int i = 1; i <= 3; i++) {
            if(i<=n){
                count+=recursion(n-i);
            }
        }
        return count;
    }

    static int []dp;
    public static int memoization(int n){
        if (n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        int count = 0;
        for (int i = 1; i <= 3; i++) {
            if(i<=n){
                count+=memoization(n-i);
            }
        }
        return dp[n]=count;
    }

    public static void main(String[] args) {
        int stairs = 5;
        System.out.println(recursion(stairs));

        dp = new int[stairs+1];
        Arrays.fill(dp,-1);
        System.out.println(memoization(stairs));

        int [] t = new int[stairs+1];
        t[0]=1;
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j <= 3; j++) {
                if(j<=i){
                    t[i] =t[i]+ t[i-j];
                }
            }
        }
        System.out.println(t[stairs]);
    }
}
