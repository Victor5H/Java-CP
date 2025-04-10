package searches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static int search(int[] nums, int target){
        int left =0,right= nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2; //to avoid overflowing for bigger values
            if (nums[mid]==target)
                return mid;
            else if (target<nums[mid])
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
//        list.sort(null);
        System.out.println(Arrays.toString(arr));
        System.out.println(search(arr,90));
    }
}
