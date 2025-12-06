package searches.binarySearch;

public class FloorAndCeil {
//    floor = larget number in arr <=target
//    ceil = smallest number in arr >=target
//    [10,20,30,40,50], target = 25
//    floor = 20, ceil = 30
//    if target = 20, ceil and floor = 20
    public int ceil (int []nums, int target){
//        similar to lower bound
        int l=0,h= nums.length-1,mid=0,ans=-1;
        while (l<=h){
            mid=(h-l)/2+l;
            if(nums[mid]>=target){
                ans=nums[mid];
                h=mid-1;// eliminating greater part, since we need smallest
            }
            else l=mid+1;
        }
        return ans;
    }
    public int floor (int []nums, int target){
        int l=0,h= nums.length-1,mid=0,ans=-1;
        while (l<=h){
            mid=(h-l)/2+l;
            if(nums[mid]<=target){
                ans=nums[mid];
                l=mid+1;//eliminating the lower part since we need greatest
            }
            else h=mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        FloorAndCeil fc = new FloorAndCeil();
        int []arr= {10,20,30,40,50};
        System.out.println(fc.ceil(arr,25));
        System.out.println(fc.floor(arr,25));
    }
}

