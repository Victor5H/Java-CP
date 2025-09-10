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
        Arrays.fill(dp,Integer.MIN_VALUE);
        int []t = new int[sum+1];

        int res = recursion(coins,sum);
        System.out.println(res==Integer.MAX_VALUE?-1:res);
    }

}