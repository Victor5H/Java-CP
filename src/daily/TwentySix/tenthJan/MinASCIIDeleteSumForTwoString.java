package daily.TwentySix.tenthJan;
//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
public class MinASCIIDeleteSumForTwoString {
    String s1=null,s2= null;
    public int dfs(int i, int j){
        if (i == s1.length()) {
            int sum = 0;
            while (j < s2.length()) sum += s2.charAt(j++);
            return sum;
        }
        if (j == s2.length()) {
            int sum = 0;
            while (i < s1.length()) sum += s1.charAt(i++);
            return sum;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dfs(i+1,j+1);
        }

        int d1 = dfs(i+1,j);
        d1 = d1==Integer.MAX_VALUE?d1:d1+(int) s1.charAt(i);
        int d2 = dfs(i,j+1);
        d2 = d2==Integer.MAX_VALUE?d2:d2+(int) s2.charAt(j);
        return Math.min(d1,d2);
    }

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Base case: s1 exhausted → delete rest of s2
        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = dp[n][j + 1] + s2.charAt(j);
        }

        // Base case: s2 exhausted → delete rest of s1
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i + 1][m] + s1.charAt(i);
        }

        // Fill table bottom-up
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(
                            s1.charAt(i) + dp[i + 1][j],
                            s2.charAt(j) + dp[i][j + 1]
                    );
                }
            }
        }

        return dp[0][0];
    }
}
