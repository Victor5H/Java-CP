package csesProblems.dynamicProgramming;

import java.util.Scanner;

public class DiceCombinations {
    static long [] dp;
    public static long myRecursion(long n){
        if(n==0) return 1;
        if(dp[Math.toIntExact(n)]!=-1) return dp[Math.toIntExact(n)];
        long count=0;
        for (int i = 1; i <=6 ; i++) {
            if(i<=n)
                count+= myRecursion(n-i);
        }
        return dp[Math.toIntExact(n)] =count;

    }
    public static void main(String[] args) {

        int n = new Scanner(System.in).nextInt();
//        dp = new long[n+1];
//        Arrays.fill(dp, -1);
//        System.out.println(myRecursion(n));
//        above code wont work for huge cases, cause of stack overflow
        long[] t = new long[n+1];
        t[0] = 1;
        for (int i = 1; i < t.length; i++) {
            for (int dice = 1; dice <= 6; dice++) {
                if(dice<=i){
                    long dont = t[i-dice];
                    long take = t[i];
                    t[i] = (take+ dont)%1_000_000_007;
                }

            }
        }
        System.out.println(t[n]);
    }
}
