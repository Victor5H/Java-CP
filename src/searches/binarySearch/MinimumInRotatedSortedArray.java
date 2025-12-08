package searches.binarySearch;

public class MinimumInRotatedSortedArray {
//    brute force to try linear
    public static int logn(int []nums){
        int l=0,h= nums.length-1,mid=0,min= Integer.MAX_VALUE;
        while (l<=h){
            mid = l+(h-l)/2;

            if(nums[l]<=nums[mid]){//sorted left part
                min = Math.min(min,nums[l]);//getting min from sorted part
                l= mid+1;//eliminating it
            }
            else if (nums[mid] <= nums[h]) {//sorted right part
                min = Math.min(min,nums[mid]);//getting min from sorted part
                h=mid-1;//eliminating it
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int [] arr= {1,2,3,4,5,6,7};
        System.out.println(logn(arr));
    }
}
