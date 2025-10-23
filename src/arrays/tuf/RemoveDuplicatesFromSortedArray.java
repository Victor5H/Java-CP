package arrays.tuf;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l = 0,r=0;
        while(r<nums.length){
            while(r<nums.length&&nums[r]!=nums[l]){
                nums[l+1] = nums[r];
                l++;
                r++;
            }
            r++;
        }
        return l+1;
    }
}

