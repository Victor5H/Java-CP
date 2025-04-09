package leetcode.interview150;


import java.util.*;
import java.lang.*;
import java.io.*;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = nums1.length - 1;
        m--;
        n--;
        while (n >= 0 && m>=0) {
            if (nums1[m] > nums2[n]) {
                int temp = nums1[last];
                nums1[last] = nums1[m];
                nums1[m]=temp;
                m--;
//                if (m == 0){--last; break;}
            } else {
                nums1[last] = nums2[n];
                n--;
//                if (n == 0){--last; break;}
            }
            last--;
        }
        if(last!=0 && n>=0){
            while (last>=0&& n>=0){
                nums1[last]=nums2[n];
                last--;
                n--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) throws java.lang.Exception {
//        int[] first = {4, 0, 0, 0, 0, 0};
//        int[] second = {1, 2, 3, 5, 6};
//        int m = 1, n = 5;

        int [] first={4,5,6,0,0,0};
        int [] second = {1,2,3};
        int m=3,n=3;

        MergeSortedArray.merge(first, m, second, n);
    }
}


