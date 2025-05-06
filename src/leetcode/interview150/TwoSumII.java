package leetcode.interview150;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int [] ret = new int[2];
        int l = 0,r = numbers.length-1;
        while(l<r){
            int sum = numbers[l]+numbers[r];
            if(sum<target){
                l++;
            }
            else if(sum>target) r--;
            else {ret[0]=l+1; ret[1]=r+1; break;}
        }
        return ret;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr,9)));
    }
}
