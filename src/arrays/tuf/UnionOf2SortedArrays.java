package arrays.tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOf2SortedArrays {
    public static int[] union(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (!list.isEmpty()) {
                if (nums1[i] < nums2[j]) {
                    if (list.get(list.size() - 1) != nums1[i]) {
                        list.add(nums1[i]);
                    }
                    i++;
                } else {
                    if (list.get(list.size() - 1) != nums2[j]) {
                        list.add(nums2[j]);
                    }
                    j++;
                }

            } else {
                if (nums1[i] < nums2[j]) {
                    list.add(nums1[i++]);
                } else list.add(nums2[j++]);
            }
        }
        while (i < nums1.length) list.add(nums1[i++]);
        while ((j < nums2.length)) list.add(nums2[j++]);
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 1, 2, 2, 3, 3};
        int[] nums2 = new int[]{3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(union(nums1, nums2)));

    }
}
