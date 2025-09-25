package dp.tuf;

import java.util.Arrays;

public class FrogJumpKDistance {
    public static int recursion(int[] height, int ind, int k){
        if(ind==0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int dind = ind-i;
            if(dind >=0){
                int diff = Math.abs(height[ind]-height[dind]);
                min = Math.min(min,diff+recursion(height, dind,k));
            }
        }
        return min;
    }
    static int []dp;
    public static int memoization(int[] height, int ind, int k){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int di = ind-i;
            if(di>=0){
                int diff = Math.abs(height[ind]-height[di]);
                min = Math.min(min,diff+memoization(height,di,k));
            }
        }
        return dp[ind]=min;
    }
    public static void main(String[] args) {
        int [] height = new int[]{30,10,60,10,60,50};
        int n=6,k=4;
        System.out.println(recursion(height,n-1,k));
        dp = new  int[n];
        Arrays.fill(dp,-1);
        System.out.println(memoization(height,n-1,k));

        int []t = new int[n];
        for (int i = 1; i < t.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                int di = i-j;
                if(di>=0){
                    int diff = Math.abs(height[i]-height[di]);
                    min = Math.min(min,diff+t[di]);
                }
            }
            t[i] = min;
        }
        System.out.println(t[n-1]);
////    Space optimization for this is possible by only storing previous K elements
////    But its unnecessary we can just as easily store the whole t array
    }
}
