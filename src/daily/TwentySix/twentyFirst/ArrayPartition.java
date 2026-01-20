package daily.TwentySix.twentyFirst;

import java.util.Arrays;
//https://leetcode.com/problems/array-partition/
public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0;i<nums.length;i+=2){
            ret+=nums[i];
        }
        return ret;
    }
}
