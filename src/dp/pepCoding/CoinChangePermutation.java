package dp.pepCoding;

import java.util.Arrays;

public class CoinChangePermutation {
    public static int recursion(int []coins, int target){
        if(target==0) return 1;
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if(target-coins[i]>=0)
                count+=recursion(coins,target-coins[i]);
        }
        return count;
    }
//    there are infinite supply of coins of each value, need to show number of
//    permutation to achieve the target sum
    public static void main(String[] args) {
        int[]coins = new int[]{5,2,3};
        int targetSum = 7;
        int [] t = new int[targetSum+1];
        t[0] =1;
//        here since we are iterating over t first and the over coins
//        we will try to find the number of permutation to pay t[i] using all coins
        for (int i = 1; i < t.length; i++) {
            for (int coin: coins) {
                if(coin<=i){
                    t[i] += t[i-coin];
                }
            }
        }
        System.out.println(recursion(coins,targetSum));
        System.out.println(Arrays.toString(t));
        System.out.println(t[targetSum]);
    }
}
