package daily.TwentyFive.eighteenOct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//https://leetcode.com/problems/permutations-ii/
public class PermutationII {
//    the way java makes hashcodes of list of integers depends on the order of the elements
//    so if the order of elements in 2 list are same, the hashcode will be same
//    and can be eliminated using hashset
//    used same logic as permutation but used hashset to remove duplicate lists, since
//    elements given in input are not unique.
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        res.add(new ArrayList<>());
        for(int n: nums){
            HashSet<List<Integer>> newP = new HashSet<>();
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
        return new ArrayList<>(res);
    }
}
