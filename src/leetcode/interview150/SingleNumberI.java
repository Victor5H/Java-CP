package leetcode.interview150;

public class SingleNumberI {
    public static int singleNumber(int[] nums) {
        int u = 0;
        for(int i=0;i<nums.length;i++){
            u = u^nums[i]  ;
        }
        return u;
    }
}
