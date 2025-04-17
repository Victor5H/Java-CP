package daily.sixteenApril;

public class Max {
    public static int maxi(int [] nums, int pointer){
        if(pointer == nums.length-1) return nums[pointer];
        int max = maxi(nums,pointer+1);
        if(nums[pointer]>max) return nums[pointer];
        return max;
    }
}
