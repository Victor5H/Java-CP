package daily.fifteenthDec;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    public void dfs(int [] arr, int ind, List<Integer> n){
        if(ind==arr.length){
            res.add(new ArrayList<>(n));
            return;
        }
        n.add(arr[ind]);
        dfs(arr,ind+1,n);
        n.remove(n.size()-1);
        dfs(arr,ind+1,n);
    }
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return res;

    }

}
