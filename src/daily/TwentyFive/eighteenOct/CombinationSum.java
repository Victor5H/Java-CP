package daily.TwentyFive.eighteenOct;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/?
public class CombinationSum {
    public List<List<Integer>> ans = new ArrayList<>();
    public void recursion(int []candidates, int target, List<Integer> ansSF){
        if(target==0) ans.add(new ArrayList<>(ansSF));
        if(target<0) return;
        if(target>0){
            for(int i=0;i<candidates.length;i++){
                ansSF.add(candidates[i]);
                recursion(candidates,target-candidates[i],ansSF);
                ansSF.remove(ansSF.size()-1);
            }

        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recursion(candidates, target, new ArrayList<Integer>());
        return ans;
    }
}
