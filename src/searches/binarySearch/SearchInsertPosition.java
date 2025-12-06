package searches.binarySearch;

public class SearchInsertPosition {
//    given an sorted arr with disticnt element find the index of target,
//    if target is not present find the index where the target should be inserted to maintain
//    sorted array
    public static int doit(int []nums,int target){
//        same as lower bound
        int l=0,h= nums.length-1,mid=0,ans=-1;
        while (l<=h){
            mid=(h-l)/2+l;
            if(nums[mid]==target){ ans=mid; break;}
            if(l==h){ ans=mid; break;}
            else if(target>nums[mid]) l=mid+1;
            else h=mid-1;
            if(h<l){ ans=mid;break;}
        }
        return ans;
    }

    public static void main(String[] args) {
        int []arr = {1,2,4,7};
        System.out.println(doit(arr,3));
    }
}
