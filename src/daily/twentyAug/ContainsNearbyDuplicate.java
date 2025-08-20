package daily.twentyAug;

import java.util.HashMap;
//https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k){
//                 checking if current index and index stored in map of same element has 'k' difference
                return true;
            }
            map.put(nums[i],i); // always putting the latest index
        }
        return false;
    }
}
