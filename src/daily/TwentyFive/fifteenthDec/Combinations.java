package daily.TwentyFive.fifteenthDec;
//https://leetcode.com/problems/combinations/
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    int n=0,k=0;
    public void dfs(int ind, List<Integer> curr){
        if(curr.size()==k){
            res.add(new     ArrayList<>(curr));
            return;
        }
        for(int i=ind;i<=n;i++){
            curr.add(i);
            dfs(i+1,curr);
            curr.remove(curr.size()-1);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        dfs(1,new ArrayList<>());
        return res;
    }
}
