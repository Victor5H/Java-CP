package dp.tuf;

import java.util.Arrays;

public class ClimbingStairs {
    public static int recursion(int n){
        if (n==0) return 1;
        if(n<0) return 0;
        int count=0;
        for (int i = 1; i <= 2; i++) {
            count+=recursion(n-i);
        }
        return count;
    }
    static int []dp;
    public static int memoization(int n){
        if (n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int count=0;
        for (int i = 1; i <= 2; i++) {
            count+=memoization(n-i);
        }
        return dp[n]=count;
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(recursion(n));
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(memoization(n));
////    Bottom UP
        int []t = new int[n+1];
        t[0]=1;
        t[1]=1;
        for (int i = 2; i <=n; i++) {
            t[i] = t[i-1]+t[i-2];
        }
        System.out.println(t[n]);
////    Space optimization
        int prev=1,prev2=0;
        for (int i = 0; i < n; i++) {
            int curr = prev+prev2;
            prev2 = prev;
            prev = curr;
        }
        System.out.println(prev);

    }
}
