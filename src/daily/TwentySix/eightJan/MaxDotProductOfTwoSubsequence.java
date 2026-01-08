package daily.TwentySix.eightJan;

import java.util.Arrays;

public class MaxDotProductOfTwoSubsequence {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n =nums1.length,m=nums2.length;
        int [][] dp = new int[n+1][m+1];
        for(int[] ar:dp){
            Arrays.fill(ar,Integer.MIN_VALUE);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = nums1[i]*nums2[j];
            }
        }

        // System.out.println(Arrays.deepToString(dp));
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int product = nums1[i] * nums2[j];

                // Calculate max dot product if we include nums1[i] and nums2[j]
                // We can extend a previous sequence (dp[i+1][j+1]) or start a new one (product
                // only)
                int currentMax = product;
                if (dp[i + 1][j + 1] != Integer.MIN_VALUE) {
                    currentMax = Math.max(product, product + dp[i + 1][j + 1]);
                }

                dp[i][j] = currentMax;

                // Inherit from skipping nums1[i]
                if (dp[i + 1][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
                }

                // Inherit from skipping nums2[j]
                if (dp[i][j + 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j + 1]);
                }

            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[0][0];

    }
}
