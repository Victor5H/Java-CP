package searches.binarySearch;

public class FirstAndLastOccurrence {
    public static void linear(int [] nums, int target){
        int first=-1,last=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) {
                if (first == -1) first = i;
                last=i;
            }
        }
        System.out.println("First occurrence at "+first);
        System.out.println("Last occurrence at "+last);
    }
    public static void tlogn(int[]nums, int target){
//        tc: O(2 logn)
//        with help of lower bound and upper bound
        LowerAndUpperBound lu = new LowerAndUpperBound();
        int lb= lu.lowerBound(nums,target);
        int ub = lu.upperBound(nums,target)-1;
        if(lb==-1||nums[lb]!=target){
            System.out.println("Element not found");
            return;
        }
        System.out.println("First occurrence at "+lb);
        System.out.println("Last occurrence at "+ub);

    }
    protected static int firstOccurrence(int[] nums, int target){
        int l =0, h = nums.length-1,mid=0,ansI=-1;
        while (l <= h){
            mid = l +(h - l)/2;
            if (nums[mid]==target) {
                ansI=mid;
                h=mid-1;//to move left
            }
            else if (target<nums[mid])
                h =mid-1;
            else
                l =mid+1;
        }
        return ansI;
    }
    protected static int lastOccurrence(int[] nums, int target){
        int l =0, h = nums.length-1,mid=0,ansI=-1;
        while (l <= h){
            mid = l +(h - l)/2;
            if (nums[mid]==target) {
                ansI=mid;
                l=mid+1;//to move right
            }
            else if (target<nums[mid])
                h =mid-1;
            else
                l =mid+1;
        }
        return ansI;
    }


    public static void main(String[] args) {
        int []arr = {1,2,2,2,2,4,4,5};
        tlogn(arr,2);

        System.out.println("First occurrence at "+firstOccurrence(arr,5));
        System.out.println("Last occurrence at "+lastOccurrence(arr,5));
    }
}
