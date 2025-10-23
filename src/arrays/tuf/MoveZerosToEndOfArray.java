package arrays.tuf;

import java.util.Arrays;
//https://leetcode.com/problems/move-zeroes/
public class MoveZerosToEndOfArray {
    public static void move(int []nums){
        int i=0;
        for(int j=0;j< nums.length-1;j++){
            if(nums[j]==0){
                i=j+1;
                while(i<nums.length-1&& nums[i]==0){
                    i++;
                }
                int t = nums[i];
                nums[i]= nums[j];
                nums[j]=t;
            }
        }
    }

    public static void main(String[] args) {
        int[]nums = new int[]{1,0,3,4,0,6,0,5,5};
        move(nums);
        System.out.println(Arrays.toString(nums));
    }
}
