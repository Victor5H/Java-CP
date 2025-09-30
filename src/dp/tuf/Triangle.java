package dp.tuf;

import java.util.Arrays;

public class Triangle {
    public static int recursion(int [][]mat, int row, int col){
        if(row== mat.length-1) return mat[row][col];
        int down = recursion(mat, row+1, col);
        int diag = recursion(mat, row+1, col+1);
        return mat[row][col]+Math.max(diag,down);
    }
    static int[][]dp;
    public static int memoization(int [][]mat, int row, int col){
        if(row== mat.length-1) return mat[row][col];
        if(dp[row][col]!=-1) return dp[row][col];
        int down = memoization(mat, row+1, col);
        int diag = memoization(mat, row+1, col+1);
        return dp[row][col]=mat[row][col]+Math.max(diag,down);
    }

    public static void main(String[] args) {
        int[][]mat = new int[][]{
                {1,0,0,0},
                {2,3,0,0},
                {3,6,7,0},
                {8,9,6,10}
        };
        dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(recursion(mat,0,0));
        System.out.println(memoization(mat,0,0));
        int [][]t= new int[mat.length][mat.length];
        t[mat.length-1] = mat[mat.length-1];
        for (int i = mat.length-2; i >=0; i--) {
            for (int j = 0; j <=i; j++) {
                int down = t[i+1][j];
                int diag = t[i+1] [j+1];
                t[i][j]=mat[i][j]+Math.max(diag,down);
            }
        }
        System.out.println(t[0][0]);
        int []prev = mat[mat.length-1];
        for (int i = mat.length-2; i >=0; i--) {
            int []cur= new int[mat.length];
            for (int j = 0; j <=i; j++) {
                int down = prev[j];
                int diag = prev[j+1];
                cur[j]=mat[i][j]+Math.max(diag,down);
            }
            prev = cur;
        }
        System.out.println(prev[0]);
    }
}
