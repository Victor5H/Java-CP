package daily.TwentyFive.thirdOct;
//https://leetcode.com/problems/range-sum-query-immutable/
public class RangeSumQueryImmutable {
    private int []nums;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;

        initPrefix();
    }
    private void initPrefix(){
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        if(left==0) return nums[right];
        return nums[right]-nums[left-1];
    }
}
