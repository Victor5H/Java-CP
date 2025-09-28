package dp.tuf;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {
//    Max sum of any subsequence with no consecutive elements selected
    public static int recursion(int ind, int []arr){
        if (ind==0) return arr[ind];
        int dont = recursion(ind-1,arr);
        int take =arr[ind];
        if(ind>1)
            take +=recursion(ind-2,arr);
        return Math.max(dont,take);
    }
    static int[]dp;
    public static int memoization(int ind, int []arr){
        if (ind==0) return arr[ind];
        if (dp[ind]!=-1) return dp[ind];
        int dont = memoization(ind-1,arr);
        int take = arr[ind];
        if(ind>1)
            take +=memoization(ind-2,arr);
        return dp[ind]=Math.max(dont,take);
    }
    public static void main(String[] args) {
        int []arr = new int[]{10,20,30,40,40,50};
        System.out.println(recursion(arr.length-1 ,arr));
        dp = new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(memoization(arr.length-1, arr));
        int []t = new int[arr.length];
        t[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int dont = t[i-1];
            int take = arr[i];
            if(i>1)
                take += t[i-2];
            t[i]= Math.max(take,dont);
        }
        System.out.println(t[arr.length-1]);
////    space optimization since we are only referring to either previous or 2 previous elements
////    we only need to store those 2 elements
        int prev=arr[0],prev2=0;
        for (int i = 1; i < arr.length; i++) {
            int dont = prev;
            int take =arr[i];
            if(i>1)
                take += prev2;
            int curr= Math.max(dont,take);
            prev2 = prev;
            prev = curr;
        }
        System.out.println(prev);
    }

}
