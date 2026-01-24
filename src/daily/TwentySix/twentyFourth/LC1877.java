package daily.TwentySix.twentyFourth;

import java.util.Arrays;
//https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
public class LC1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n/2;i++){
            int sum = nums[i]+nums[n-i-1];
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}
