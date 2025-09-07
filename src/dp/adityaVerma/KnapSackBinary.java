package dp.adityaVerma;

import java.util.Arrays;

public class KnapSackBinary {
    static int [][]dp;
    public static int myRecursion(int [] val, int[] wt, int ind, int bag){
        if(bag<0) return Integer.MIN_VALUE;
        if(ind==val.length)return 0;

        int take= val[ind]+ myRecursion(val, wt, ind+1, bag-wt[ind]);
        int dint= myRecursion(val, wt, ind+1, bag);
        return Math.max(take,dint);
    }
    public static int real(int [] val, int[] wt, int ind, int bag){
        if(ind<0|bag==0)
            return 0;
        if(wt[ind]>bag){
            return real(val, wt, ind-1, bag);
        }
        int take = val[ind]+real(val, wt, ind-1, bag-wt[ind]);
        int dont = real(val, wt, ind-1, bag);
        return Math.max(take,dont);
    }
    public static int memoization(int [] val, int[] wt, int ind, int bag){
        if(ind<0||bag==0) {
            return 0;
        }
        if(dp[ind][bag]!=-1) return dp[ind][bag];
        if(wt[ind]>bag){
            return memoization(val, wt, ind-1, bag);
        }
        int take = val[ind]+memoization(val, wt, ind-1, bag-wt[ind]);
        int dont = memoization(val, wt, ind-1, bag);
        return dp[ind][bag]= Math.max(take,dont);
    }

    public static void main(String[] args) {
        int[] val = new int[]{15,14,10,45,30};
        int[] wt = new int[]{2,5,1,3,4};
        int w = 7;
        System.out.println(myRecursion(val,wt,0,w));
        System.out.println(real(val,wt, val.length-1, w));
        dp = new int[val.length][w+1];
        for (int i=0;i<dp.length;i++){
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(memoization(val,wt, val.length-1,w ));

        int [][] t = new int[val.length+1][w+1];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j <t[0].length; j++) {
                if(i==0||j==0) t[i][j]=0;
//                init the mat, altough its alreay init to 0
            }
        }
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if(wt[i-1]>j){
//                    cannot select since weight is more than the bag i.e. j
                    t[i][j]=t[i-1][j];
                }
                else if(wt[i-1]<=j){
                    int take = val[i-1]+t[i-1][j-wt[i-1]];
                    int dont = t[i-1][j];
                    t[i][j] = Math.max(take,dont);
                }
            }
        }
//        for (int i = 0; i < t.length; i++) {
//            System.out.println(Arrays.toString(t[i]));
//        }
        System.out.println(t[t.length-1][t[0].length-1]);

    }
}
