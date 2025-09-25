package dp.tuf;

import java.util.Arrays;

public class FrogJump {
    public static int recursion(int n,int []arr){
        if(n ==0) return 0;
        int firstJump = Math.abs(arr[n]-arr[n-1])+recursion(n-1,arr);
        int secondJump = Integer.MAX_VALUE;
        if(n > 1)
            secondJump = Math.abs(arr[n]-arr[n-2])+recursion(n-2,arr);
        return Math.min(firstJump,secondJump);
    }
    static int [] dp;
    public static int memoization(int n,int []arr){
        if(n ==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int firstJump = Math.abs(arr[n]-arr[n-1])+memoization(n-1,arr);
        int secondJump = Integer.MAX_VALUE;
        if(n > 1)
            secondJump = Math.abs(arr[n]-arr[n-2])+memoization(n-2,arr);
        return dp[n]=Math.min(firstJump,secondJump);
    }

    public static void main(String[] args) {
        int [] height = new int[]{30,10,60,10,60,50};
        int n=6;
        System.out.println(recursion(n-1, height));
        dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(memoization(n-1, height));
        int []t = new int[n];
        for (int i = 1; i <n; i++) {
            int firstJump = t[i-1]+Math.abs(height[i]- height[i-1]);
            int secondJump = Integer.MAX_VALUE;
            if(i>1)
                secondJump = t[i-2]+Math.abs(height[i]- height[i-2]);
            t[i] = Math.min(firstJump,secondJump);

        }
        System.out.println(t[n-1]);
////    Space optimization since a frog can make 2 jumps. only 2 prev values are required
        int prev = 0,prev2 = 0;
        for (int i = 1; i < height.length; i++) {
            int first =prev+Math.abs(height[i]- height[i-1]);
            int second = Integer.MAX_VALUE;
            if(i>1)
                second =prev2+Math.abs(height[i]- height[i-2]);
            int cur = Math.min(first,second);
            prev2 = prev;
            prev = cur;
        }
        System.out.println(prev);

    }
}
