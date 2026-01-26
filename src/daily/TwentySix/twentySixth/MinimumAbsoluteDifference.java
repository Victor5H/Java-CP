package daily.TwentySix.twentySixth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/minimum-absolute-difference/
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE,n=nums.length;
        for(int i=0;i<n-1;i++){
            int diff = Math.abs(nums[i]-nums[i+1]);
            if(diff<minDiff){
                minDiff=diff;
                ret.clear();
                List<Integer> li = new ArrayList<>();
                li.add(nums[i]);
                li.add(nums[i+1]);
                ret.add(li);
            }
            else if(diff==minDiff){
                List<Integer> li = new ArrayList<>();
                li.add(nums[i]);
                li.add(nums[i+1]);
                ret.add(li);
            }
        }
        return ret;
    }
}
