package daily.twentyfourthApril;

import java.util.HashSet;

public class ArraySubset {
    public static boolean checkSubset(int [] nums, int [] subset){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < subset.length; i++) {
            if(!set.contains(subset[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkSubset(new int[]{1, 2, 2, 3, 4}, new int[]{2, 2, 3}));
    }
}
