package daily.TwentyFive.twentythOct;
//https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public void reverse(int[] nums, int l, int h){
        while(l<h){
            int temp = nums[l];
            nums[l] = nums[h];
            nums[h] = temp;
            l++;
            h--;
        }
    }
    public void rotate(int[] nums, int k) {

        if(nums.length==1) return;
        k = k%nums.length;
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-k-1);
        reverse(nums,0,nums.length-1);
    }
}
