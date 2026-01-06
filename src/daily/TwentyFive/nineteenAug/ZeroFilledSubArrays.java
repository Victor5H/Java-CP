package daily.TwentyFive.nineteenAug;
//https://leetcode.com/problems/number-of-zero-filled-subarrays/
public class ZeroFilledSubArrays {
    public long zeroFilledSubarray(int[] nums) {
        long totalCount=0,sub=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                sub=0;
            }
            else{
                sub++;
                totalCount+=sub;
            }
        }
        return totalCount;
    }
    public long zeroFilledSubarray1(int[] nums) {
        long totalCount=0,sub=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                totalCount+=sub*(sub+1)/2;
                sub=0;
            }
            else{
                sub++;
            }
        }
        if(sub!=0) totalCount+=sub*(sub+1)/2;
        return totalCount;
    }
}
