package daily.fifteenthOct;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int c = nums[i];
            int diff = target-c;
            if(map.containsKey(diff)){
                int got  = map.get(diff);
                if(got!=i) return new int[]{i,got};
            }
        }
        return new int[]{-1,-1};
    }
}
