package daily.TwentyFive.eighteenOct;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/permutations/
public class Permutation {
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int [] nums, List<Integer> ansSF){
        if(ansSF.size()==nums.length){ ans.add(new ArrayList<>(ansSF)); return;}
        for(int j=0;j<nums.length;j++){
            if(!ansSF.contains(nums[j])){
                ansSF.add(nums[j]);
                dfs(nums,ansSF);
                ansSF.remove(ansSF.size()-1);
            }
        }
    }
    public ArrayList<List<Integer> >per(int nums[], int i){
        if(i==nums.length-1){
            ArrayList<List<Integer>> l= new ArrayList<>();
            l.add(new ArrayList<>(nums[i]));
            return l;
        }
        ArrayList<List<Integer>> perms = per(nums,i+1);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for(List<Integer> p: perms){
            for(int j=0;j<=p.size();j++){
                List<Integer> temp = new ArrayList<>(p);
                temp.add(j,nums[i]);
                res.add(temp);
            }
        }
        return res;

    }
    public List<List<Integer>> permute(int[] nums) {
        // dfs(nums,new ArrayList<>());
        // return ans;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int n: nums){
            List<List<Integer>> newP = new ArrayList<>();
            for(List<Integer> l: res){
                for(int i=0;i<=l.size();i++)
                {
                    List<Integer> temp = new ArrayList<>(l);
                    temp.add(i,n);
                    newP.add(temp);
                }
            }
            res = newP;
        }
        return res;
        // return per(nums,0);
    }
}
