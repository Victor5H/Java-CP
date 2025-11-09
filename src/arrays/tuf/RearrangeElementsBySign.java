package arrays.tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeElementsBySign {
    //    here number of +ve number and -ve numbers are same
    public static void bruteForce1(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int n : nums) {
            if (n > 0) pos.add(n);
            else neg.add(n);
        }
        for (int i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = pos.get(i);
            nums[2 * i + 1] = neg.get(i);
        }
    }

    //    here number of +ve number and -ve numbers are same
    public static int[] optimal1(int[] nums) {
        int[] ret = new int[nums.length];
        int pos = 0, neg = 1;
        for (int n : nums) {
            if (n > 0) {
                ret[pos] = n;
                pos += 2;
            } else {
                ret[neg] = n;
                neg += 2;
            }
        }
        return ret;
    }

//    public static int[] optimal2(int[] nums) {
//        List<Integer> pos = new ArrayList<>();
//        List<Integer> neg = new ArrayList<>();
//
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 3, -2, -4, 6, 7};
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(optimal1(nums)));
    }
}
