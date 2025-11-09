package arrays.tuf;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static int optimal(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxLength = 0;
        for (Integer n : nums) {
            if (set.contains(n)) {
                if (!set.contains(n - 1)) {
                    int length = 1;
                    n++;
                    while (set.contains(n)) {
                        set.remove(n);
                        n++;
                        length++;
                    }
                    maxLength = Math.max(length, maxLength);
                }
            }
        }
        return maxLength;
    }

    public static int better(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int maxLength = 0, closeMin = Integer.MIN_VALUE, length = 1;
        for (int n : nums) {
            if (closeMin == n - 1) {
                length++;
                closeMin = n;
            } else if (closeMin == n - 1) {
                length = 1;
                closeMin = n;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;

    }
}
