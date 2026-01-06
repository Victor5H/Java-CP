package daily.TwentySix.sixthJan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> list =
                Arrays.stream(intervals).map(l -> {
                    return Arrays.stream(l).boxed().toList();
                }).collect(Collectors.toList());
        list.sort((l1, l2) -> {
            return l1.get(0) - l2.get(0);
        });
        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(0).get(0));
        temp.add(list.get(0).get(1));
        ans.add(temp);
        for (int i = 1; i < list.size(); i++) {
            List<Integer> c = ans.get(ans.size() - 1);
            List<Integer> t = list.get(i);
            if (c.get(1) >= t.get(0)) {
                c.set(1, Math.max(t.get(1), c.get(1)));
            } else {
                List<Integer> n = new ArrayList<>();
                n.add(t.get(0));
                n.add(t.get(1));
                ans.add(n);
            }
        }
        return ans.stream().map(inner -> inner.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    }
}
