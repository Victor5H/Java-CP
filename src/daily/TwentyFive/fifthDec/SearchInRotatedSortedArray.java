package daily.TwentyFive.fifthDec;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        while(l<=h){
            int mid = ((h-l)/2)+l;
            if(nums[mid]==target) return mid;//found

                // left sorted
            else if(nums[l]<=nums[mid]){
                // eliminate
                if(nums[l]<=target && target<=nums[mid]){
                    h = mid-1;
                }
                else{
                    l= mid+1;
                }
            }
            // right sorted
            else{
                // eliminate
                if(nums[h]>=target && target>=nums[mid]){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }

        }
        return -1;
    }
}
