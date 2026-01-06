package daily.TwentyFive.fourthOct;

import java.util.Arrays;
import java.util.List;

public class AdjacentIncreasingSubarray {
    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int first = -1,second = -1;
        if(k==1 && nums.size()>=2) return true;
        int count=1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                count++;
            }
            else count=1;
            if(count==k){
                if(first!=-1) second=i-k-1;
                else first=i-k-1;
                count=1;
            }
        }
        if(first==-1 && second==-1) return false;
        if(second-k!=first) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasIncreasingSubarrays(Arrays.asList(2,5,7,8,9,2,3,4,3,1),3));
    }
}
