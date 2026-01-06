package daily.TwentyFive.twentyfourthApril;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    static HashSet<Integer> set = new HashSet<>();
    public static int  lcs(int [] nums){
       int maxcounter = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(set.contains(num)){
                int get = check(num);
                if(get>maxcounter) maxcounter = get;
            }
        }
        return maxcounter;
    }
    public static int check(int num){
        int counter = 0;
        int i = num;
        i--;
        while (set.contains(i)){
            i--;
        }
        i++;
        while (set.contains(i)){
            set.remove(i);
            i++;
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(lcs(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
