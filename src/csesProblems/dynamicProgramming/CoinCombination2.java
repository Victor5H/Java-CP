//package csesProblems.dynamicProgramming;

import java.util.Scanner;

public class CoinCombination2 {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sum = s.nextInt();
        int []coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i]= s.nextInt();
        }
        long []t = new long[sum+1];
        t[0]=1;
        for(int coin: coins){
            for (int i = 1; i < t.length; i++) {
                if(coin<=i){
                    long l = t[i] + t[i - coin];
                    if(t[i]>=mod){
                        t[i] = l % mod;
                    }
                    else {
                        t[i] = l;
                    }
                }
            }
        }
        System.out.println(t[sum]);
    }
}
