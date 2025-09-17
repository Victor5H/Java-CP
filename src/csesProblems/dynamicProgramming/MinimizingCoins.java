package csesProblems.dynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins {
    static int [] dp;
    public static int recursion(int[] arr, int sum) {
        if (sum==0) return 0;
        if(dp[sum]!=Integer.MIN_VALUE) return dp[sum];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<=sum){
                int res = recursion(arr, sum-arr[i]);
                if(res!=Integer.MAX_VALUE)
                    min = Math.min(min,res+1);
            }
        }
        return dp [sum]=min;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sum = s.nextInt();
        int []coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i]= s.nextInt();
        }
        dp = new int[sum+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int []t = new int[sum+1];
        Arrays.fill(t,Integer.MAX_VALUE);
        t[0]=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j =1; j < t.length; j++) {
                if(coins[i]<=j) {
                    int take = t[j - coins[i]]!=Integer.MAX_VALUE?t[j - coins[i]] + 1:Integer.MAX_VALUE ;
                    int dont = t[j];
                    t[j] = Math.min(take, dont);
                }
            }
        }
        int res = t[sum];
        System.out.println(res>=Integer.MAX_VALUE?-1:res);
    }

}