package dp.pepCoding;

import java.util.Arrays;

public class ClimbingStairsWithMinMoves {
//    goal is to reach on top stair from 0 using minimum steps
    public static int recursion(int [] stairs,int n){
        if(n== stairs.length) return 0;
        int jumps = stairs[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= jumps; i++) {
            if(n+i<= stairs.length)
                min = Math.min(min,recursion(stairs,n+i));
        }
        return min==Integer.MAX_VALUE?Integer.MAX_VALUE:min+1;
    }
   static int [] dp;
    public static int memoization(int [] stairs,int n){
        if(n== stairs.length) return 0;
        int jumps = stairs[n];
        if(dp[n]!=-1) return dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= jumps; i++) {
            if(n+i<= stairs.length)
                min = Math.min(min,memoization(stairs,n+i));
        }
        return dp[n]= min==Integer.MAX_VALUE?Integer.MAX_VALUE:min+1;
    }


    public static void main(String[] args) {
//        int [] stairs = new int[]{2,3,2,2,0,2,4};
        int [] stairs = new int[]{4,2,0,2,2,3,2};
        System.out.println(recursion(stairs,0));
        dp = new int[stairs.length+1];
        Arrays.fill(dp,-1);
        System.out.println(memoization(stairs,0));
        Integer [] t = new Integer[stairs.length+1];
        t[stairs.length]=0;
        System.out.println(Arrays.toString(t));
        for (int i = stairs.length-1 ;i >=0;i--) {
            if(stairs[i]>0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= stairs[i]; j++) {
                    if (j + i < t.length && t[i+j]!=null) {
                        min = Math.min(min, t[j + i]);
                    }

                }
                t[i] = min==Integer.MAX_VALUE?null:min+1;
            }
        }
        System.out.println(Arrays.toString(t));
        System.out.println(t[0]);
    }
}
