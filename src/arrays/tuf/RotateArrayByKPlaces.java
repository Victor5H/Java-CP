package arrays.tuf;

import java.util.Arrays;

public class RotateArrayByKPlaces {

    public static void reverse(int []nums, int l, int h){
        while(l<h){
            int t = nums[l];
            nums[l] = nums[h];
            nums[h] = t;
            h--;l++;
        }
    }
    public static void leftRotate(int []nums, int k){
        k = k% nums.length;
        reverse(nums,0,k-1);
        reverse(nums,k, nums.length-1);
        reverse(nums,0, nums.length-1 );
    }
    public static void rightRotate(int []nums, int k){
        k = k% nums.length;
        reverse(nums,0,nums.length-1-k);
        reverse(nums,nums.length-k, nums.length-1);
        reverse(nums,0, nums.length-1 );
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5,6,7};
        rightRotate(nums,84);
        System.out.println(Arrays.toString(nums));

    }
}
