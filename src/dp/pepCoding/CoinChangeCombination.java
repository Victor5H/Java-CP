package dp.pepCoding;

import java.util.Arrays;

public class CoinChangeCombination {
//    there are infinite supply of coins of each value, need to show number of
//    combinations to achieve the target sum
    public static void main(String[] args) {
        int [] coins = new int[]{2,3,5};
        int targetSum = 7;
        int []t   = new int[targetSum+1];
        t[0] = 1;
//        the way it is making combination is because of the loops over coins
//        since we are traversing the coins first, the answer will form in 2,3,5 way only
//        there wont be a way that 2 will come again after 3 or 5
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < t.length; j++) {
                if(coins[i]<=j){
                    t[j] += t[j-coins[i]];
                }
            }
        }
        System.out.println(Arrays.toString(t));
        System.out.println(t[targetSum]);
    }
}
