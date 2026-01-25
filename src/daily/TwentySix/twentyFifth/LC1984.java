package daily.TwentySix.twentyFifth;

import java.util.Arrays;
//https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
public class LC1984 {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int minDiff=Integer.MAX_VALUE;
        if(n==1) return 0;
        Arrays.sort(nums);
        for(int i=0;i<n-k+1;i++){
            int diff = nums[i+k-1]-nums[i];
            minDiff = Math.min(diff,minDiff);
        }
        return minDiff;
    }
}
