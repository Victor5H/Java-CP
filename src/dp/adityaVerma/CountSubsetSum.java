package dp.adityaVerma;

import java.util.Arrays;

public class CountSubsetSum {
    public static int myRecursion(int []arr, int ind, int sum){
        if(ind== arr.length){
            if(sum==0) return 1;
            return 0;
        }
        int take = myRecursion(arr, ind+1, sum-arr[ind]);
        int dont = myRecursion(arr, ind+1, sum);
        return take+dont;
    }
     static int [][]dp;
    public static int memoization(int []arr, int ind, int sum){
//        to prevent negative sum
        if(sum<0) return 0;

        if(ind== arr.length){
            if(sum==0) return 1;
            return 0;
        }
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        int take = memoization(arr, ind+1, sum-arr[ind]);
        int dont = memoization(arr, ind+1, sum);

        return dp[ind][sum]= take+dont;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,6,8,10};
        int target =10;
        System.out.println(myRecursion(arr,0,target));
        dp = new int[arr.length][target+1];
        for (int i=0;i< dp.length;i++){
            for (int j = 0; j < dp[0].length; j++) {
                 dp[i][j]=-1;
            }
        }
        System.out.println(memoization(arr,0,target));
    }
}
