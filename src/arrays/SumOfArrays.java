package arrays;

import java.util.Arrays;

public class SumOfArrays {
    public static int [] sum(int [] nums1,int [] nums2){
        int min = Math.min(nums1.length, nums2.length);
        int max = Math.max(nums1.length, nums2.length);
        int [] ret = new int[max];
        int i=0;
        while (i<min){
            ret[i] = nums1[i]+nums2[i];
            i++;
        }
        if(i== nums1.length){
            while (i<max){
                ret[i] = nums2[i];
                i++;
            }
        }
        else{
            while (i<max){
                ret[i] = nums1[i];
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sum(new int[]{1,2,3,4,5,6,7,8},new int[]{1,2,3,4,5})));
    }
}
