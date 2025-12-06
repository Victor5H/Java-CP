package searches.binarySearch;

public class LowerAndUpperBound {
    protected int lowerBound(int []nums, int target){
//        it is the number with smallest index which is >= target
        int l=0,h= nums.length-1,ansI = -1,mid=0;
        while (l<=h){
            mid = ((h-l)/2)+l;
            if(nums[mid]>=target){
                ansI=mid;//could be the ans but will continue to search,
                h=mid-1;
            }
            else {
//                since this is lower that tagert eliminate left part
                l=mid+1;
            }
        }
        return ansI;

    }
    protected int upperBound(int []nums, int target){
//        it is the number with smallest index which is > target
        int l=0,h= nums.length-1,ansI = -1,mid=0;
        while (l<=h){
            mid = ((h-l)/2)+l;
            if(nums[mid]>target){
                ansI=mid;//could be the ans but will continue to search,
                h=mid-1;
            }
            else {
//                since this is lower that tagert eliminate left part
                l=mid+1;
            }
        }
        return ansI;

    }
}
