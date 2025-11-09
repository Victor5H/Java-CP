package daily.fourthNov;

public class CheckIfSortedAndRotated {
    public boolean check(int[] nums) {
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                count++;
            }
        }
        if(nums[nums.length-1]>nums[0])count++; // also check the last and first element

        return count>1?false:true;
    }
}
