package searches.binarySearch;

public class NumberOfArrayRotations {
//    brute force : position of min element
    public static int logn(int []nums){
        int l=0,h= nums.length-1,mid=0,min= Integer.MAX_VALUE,minI=-1;
        while (l<=h){
            mid = l+(h-l)/2;
            if(nums[l]<=nums[mid]){
                if(nums[l]<min){
                    min = nums[l];
                    minI=l;
                }
                l=mid+1;
            }
            else {
                if(nums[mid]<min){
                    min = nums[mid];
                    minI=mid;
                }
                h=mid-1;
            }
        }
        return minI;
    }

    public static void main(String[] args) {
        int []arr = {3,4,5,1,2};
        System.out.println(logn(arr));
    }
}
