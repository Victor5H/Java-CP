package dp.tuf;

import java.util.Arrays;

public class MaxFallingPathSum {
    public static int recursion(int [][]mat, int row, int col){
        if(row== mat.length-1) return mat[row][col];
        int [][]dx = new int[][]{
                {1,0},{1,1},{1,-1}
        };
        int max = Integer.MIN_VALUE;
        for(int []d:dx){
            int dr = row+d[0];
            int dc = col+d[1];
            if(dc>=0 && dc<mat[0].length){
                max = Math.max(max,recursion(mat,dr,dc));
            }
        }
        return max+mat[row][col];
    }
    static int [][]dp;
    public static int memoization(int [][]mat, int row, int col){
        if(row== mat.length-1) return mat[row][col];
        if(dp[row][col]!=-1) return dp[row][col];
        int [][]dx = new int[][]{
                {1,0},{1,1},{1,-1}
        };
        int max = Integer.MIN_VALUE;
        for(int []d:dx){
            int dr = row+d[0];
            int dc = col+d[1];
            if(dc>=0 && dc<mat[0].length){
                max = Math.max(max,memoization(mat,dr,dc));
            }
        }
        return dp[row][col]=max+mat[row][col];
    }

    public static void main(String[] args) {
        int [][]mat = new int[][]{
                {1,2,10,4},
                {100,3,2,1},
                {1,1,20,2},
                {1,2,2,1}
        };
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat[0].length; i++) {
            max = Math.max(max,recursion(mat,0,i));
        }

        System.out.println(max);
        dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        int maxM = Integer.MIN_VALUE;
        for (int i = 0; i < mat[0].length; i++) {
            maxM = Math.max(max,memoization(mat,0,i));
        }
        System.out.println(maxM);
        int [][]t = new int[mat.length][mat[0].length];
        t[0] = mat[mat.length-1];
//        for (int i = 0; i < ; i++) {
//
//        }
    }

}
