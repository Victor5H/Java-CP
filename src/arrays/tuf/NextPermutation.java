package arrays.tuf;

import java.util.Arrays;
//https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public static void reverse(int []nums,int start, int end){
        int l=start,h=end;
        while (l<h){
            int temp = nums[l];
            nums[l] = nums[h];
            nums[h] = temp;
            l++;h--;
        }
    }
    public static void optimal(int[] nums) {
        int ind = -1;
        for (int i = nums.length-1; i >-0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        if(ind==-1){ // its already the last permutation
            reverse(nums,0, nums.length-1);
            return;
        }
        for (int i = nums.length-1; i >=0; i--) {
            if(nums[i]> nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }
        reverse(nums,ind+1, nums.length-1);
    }

    public static void main(String[] args) {
        int [] nums = new int[]{2,1,5,4,3,0,0};
        System.out.println(Arrays.toString(nums));
        optimal(nums);
        System.out.println(Arrays.toString(nums));
    }
}
