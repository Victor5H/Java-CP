package dp.pepCoding;

import java.util.Arrays;

public class TargetSumSubset {
    public static boolean recursion(int[] arr, int target, int ind){
        if(ind== arr.length){
            return target==0;
        }
        if (target<0) return false;
        return recursion(arr, target-arr[ind], ind+1)||recursion(arr, target, ind+1);
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,7};
        int target=6;
        System.out.println(recursion(arr,target,0));
        boolean [][]t = new boolean[arr.length+1][target+1];
        for (int i = 0; i < t.length; i++) {
            t[i][0] = true;
        }
        for (int i =1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if(arr[i-1]<=j){
                    boolean take =t[i-1][j-arr[i-1]];
                    boolean dont = t[i-1][j];
                    t[i][j]=  take|| dont;
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
        System.out.println(t[t.length-1][t[0].length-1]);
    }
}
