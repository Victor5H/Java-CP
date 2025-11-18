package arrays.tuf;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public static void optimal(int [] arr){
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        int min = arr[0],profit = 0;
        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i] - min;
            profit = Math.max(profit,cost);
            min = Math.min(min,arr[i]);
        }
        System.out.println(Arrays.toString(dp));
    }

    public static void main(String[] args) {
        int []arr = new int[]{7,1,5,3,6,4};
        optimal(arr);

    }
}
