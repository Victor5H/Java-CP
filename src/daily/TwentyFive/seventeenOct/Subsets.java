package daily.TwentyFive.seventeenOct;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class Subsets {
    List<List<Integer>> ans = new ArrayList<>();
    public void recursion(int []nums, int i, List<Integer> ansSF){
        if(i==nums.length){
            ans.add(new ArrayList<>(ansSF));
            return;
        }
        ansSF.add(nums[i]);
        recursion(nums, i+1,ansSF);
        ansSF.remove(ansSF.size()-1);
        recursion(nums, i+1,ansSF);
    }
    public List<List<Integer>> subsets(int[] nums) {
        recursion(nums,0,new ArrayList<>());
        return ans;
    }
}
