package leetcode.interview150;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicate {
    public static final int removeDuplicates(int [] nums){
        int n = nums.length;
        int pointUnique=0,pointAhead=1,count=1;
        while(pointAhead< nums.length){
            if(nums[pointAhead]==nums[pointUnique]){
                pointAhead++;
            }
            else {
                int temp = nums[pointUnique+1];
                nums[pointUnique+1]=nums[pointAhead];
                nums[pointAhead] = nums[pointUnique+1];
                pointAhead++;
                count++;
                pointUnique++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(RemoveDuplicate.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

    }
}
