package searches.binarySearch;

import java.util.Arrays;
import java.util.stream.Stream;

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
        int []arr= Stream.iterate(1, x->x+1).limit(500).mapToInt(Integer::intValue).toArray();
//        list.sort(null);
        System.out.println(Arrays.toString(arr));
        System.out.println(search(arr,90));
    }
}
