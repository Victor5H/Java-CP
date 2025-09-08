package dp.adityaVerma;

import java.util.Arrays;

public class EqualSumPartition {
    public static boolean myRecursion(int [] arr, int sum1, int sum2, int ind){
        if(ind == arr.length){
            return sum1==sum2;
        }
        return myRecursion(arr,sum1+arr[ind],sum2,ind+1)||myRecursion(arr,sum1,sum2+arr[ind],ind+1);
    }
    public static int[][] dp;
    public static boolean memoization(int [] arr, int ind, int sum){
        if(sum==0){
            return true;
        } if (ind== arr.length|| sum<0) return false;
        if(dp[ind][sum]!=-1) return dp[ind][sum] == 1;
        boolean res= memoization(arr, ind+1, sum)|| memoization(arr, ind+1, sum-arr[ind]);
        dp[ind][sum] = res?1:0;
        return res;
    }
    public static void main(String[] args) {
        int [] arr= new int[]{1,5,5,11};
        System.out.println(myRecursion(arr,0,0,0));
//        this recursion is ok, but we can cleverly use dp of Subset sum problem
//        since we need to divide the array in 2 subsets such that the sum is same
//        that means the sum should always be even, and if we can find a subset with half of
//        that sum we have our answer
        int sum = Arrays.stream(arr).sum();
        if(sum%2!=0){ System.out.println("Not possible"); return;}
        int target =sum/2;
        dp = new int[arr.length][target+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(memoization(arr,0,target));
    }
}
