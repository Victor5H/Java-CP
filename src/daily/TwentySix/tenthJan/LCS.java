package daily.TwentySix.tenthJan;

import java.util.Arrays;
//https://leetcode.com/problems/longest-common-subsequence/
public class LCS {
    String s1=null,s2=null;
    int [][]t = null;
    public int dfs(int i, int j){

        if(i>=s1.length() || j>=s2.length()) return 0;
        if(t[i][j]!=-1) return t[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return t[i][j] = 1+dfs(i+1,j+1);
        }
        return t[i][j] = Math.max(dfs(i+1,j),dfs(i,j+1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1;
        s2 = text2;
         t = new int [s1.length()][s2.length()];
         for(int [] ar: t){
             Arrays.fill(ar,-1);
         }
//         return dfs(0,0);
        int [][]dp = new int [s1.length()+1][s2.length()+1];
        for(int i=s1.length()-1;i>=0;i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];

                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
