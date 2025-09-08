package dp.adityaVerma;

import java.util.Arrays;

public class MinimumSubsetSumDifference {
    public static int myRecursion(int []arr, int ind, int sum1, int target){
        if (ind== arr.length){
            int sum2 = target-sum1;
            return Math.abs(sum1-sum2);
        }
        int one = myRecursion(arr, ind+1, sum1+arr[ind], target);
        int two = myRecursion(arr, ind+1, sum1, target);
        return Math.min(one,two);
    }
    static int [][]dp;
    public static int memoization(int []arr, int ind, int sum1, int target){
        if (ind== arr.length){
            int sum2 = target-sum1;
            return Math.abs(sum1-sum2);
        }
        if(dp[ind][sum1]!=-1) return dp[ind][sum1];
        int one = memoization(arr, ind+1, sum1+arr[ind], target);
        int two = memoization(arr, ind+1, sum1, target);

        return dp[ind][sum1]= Math.min(one,two);
    }


    public static void main(String[] args) {
        int []arr = new int[]{1,6,5,11};
        int target = Arrays.stream(arr).sum();
        System.out.println(myRecursion(arr,0,0,target));
        dp = new int[arr.length+1][target+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(memoization(arr,0,0,target));
    }
}
