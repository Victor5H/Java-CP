package dp.adityaVerma;

import java.util.Arrays;

public class SubsetSum {
    public static boolean myRecursion(int [] arr, int ind, int sum){
        if(sum==0) return true;
        if (ind== arr.length|| sum<0) return false;

        return myRecursion(arr, ind+1, sum)|| myRecursion(arr, ind+1, sum-arr[ind]);
    }
    public static int[][] dp;
    public static boolean memoization(int [] arr, int ind, int sum){
        if(sum==0){
            return true;
        } if (ind== arr.length|| sum<0) return false;
        if(dp[ind][sum]!=-1) return dp[ind][sum] == 1;
        boolean res= memoization(arr, ind+1, sum)|| memoization(arr, ind+1, sum-arr[ind]);
        dp[ind][sum] = res?1:0;
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3,5,7};
        int sum = 15;
        long st,end;
        st = System.nanoTime();
        System.out.println(myRecursion(arr,0,sum));
        end = System.nanoTime();
        System.out.println(end-st);
        dp=new int[arr.length][sum+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        st = System.nanoTime();
        System.out.println(memoization(arr,0,sum));
        end = System.nanoTime();
        System.out.println(end-st);

        boolean [][]t = new boolean[arr.length+1][sum+1];
//        init dp
        for (int i = 0; i < t.length; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i < t.length; i++) {
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
