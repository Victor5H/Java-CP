package arrays.tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOf2Arrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) i++;
            else if (nums2[j] < nums1[i]) j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 2, 3, 3, 4, 4, 5, 6};
        int[] nums2 = new int[]{2, 3, 3, 5, 6, 6, 7};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
