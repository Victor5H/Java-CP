package dp.pepCoding;

import java.util.Arrays;

public class ClimbingStairsWithJumps {
//    problem is you are given the amount of jumps you can make at each step
    public static int recursion(int [] arr, int n){
        if(n==arr.length)
            return 1;
        int count =0;
        int jumps =arr[n];
        for (int i = 1; i <=jumps; i++) {
            if(i+n<= arr.length){
                count+=recursion(arr,n+i);
            }
        }
        return count;
    }
    static int [] dp;
    public static int memoization(int [] arr, int n){
        if(n==arr.length)
            return 1;
        if(dp[n]!=-1) return dp[n];
        int count =0;
        int jumps =arr[n];
        for (int i = 1; i <=jumps; i++) {
            if(i+n<= arr.length){
                count+=memoization(arr,n+i);
            }
        }
        return dp[n]= count;
    }

    public static void main(String[] args) {
        int []stairs ={3,3,0,2,2,3};
        System.out.println(recursion(stairs,0));
        dp = new int[stairs.length+1];
        Arrays.fill(dp,-1);
        System.out.println(memoization(stairs,0));

        int []t = new int[stairs.length+1];
        t[stairs.length]=1;
        for (int i= stairs.length-1; i>=0 ; i--) {
            for (int j = 1; j <=stairs[i]; j++) {
                if(i+j<=t.length-1){
                    t[i] = t[i]+t[i+j];
                }
            }
        }
        System.out.println(Arrays.toString(t));
        System.out.println(t[0]);
    }
}
