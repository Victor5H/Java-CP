package dp.tuf;

import java.util.Arrays;

public class MinimumPathSum {
    public static int recursion(int [][]grid,int row, int col){
        if(row==0&&col==0) return grid[row][col];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(row>0) up = recursion(grid, row-1, col);
        if(col>0) left = recursion(grid, row, col-1);
        int res = Math.min(up,left);
        return res==Integer.MAX_VALUE?Integer.MAX_VALUE:res+grid[row][col];
    }
    static int [][]dp;
    public static int memoization(int [][]grid,int row, int col){
        if(row==0&&col==0) return grid[row][col];
        if(dp[row][col]!=-1) return dp[row][col];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(row>0) up = memoization(grid, row-1, col);
        if(col>0) left = memoization(grid, row, col-1);
        int res = Math.min(up,left);
        return dp[row][col]=res==Integer.MAX_VALUE?Integer.MAX_VALUE:res+grid[row][col];
    }
    public static void main(String[] args) {
        int [][]grid = new int[][]{
                {2,3,4,5},
                {1,2,3,1},
                {7,4,2,1},
                {1,2,1,1}
        };
        System.out.println(recursion(grid, grid.length-1,grid[0].length-1));
        dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(memoization(grid, grid.length-1,grid[0].length-1));
        int [][]t = new int[grid.length][grid[0].length];
        t[0][0] = grid[0][0];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if(i==0&&j==0) continue;
                else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i>0) up = t[i-1][j];
                    if(j>0) left = t[i][j-1];
                    int res = Math.min(up,left);
                    t[i][j]= res==Integer.MAX_VALUE?Integer.MAX_VALUE:res+grid[i][j];
                }
            }
        }
        System.out.println(t[t.length-1][t[0].length-1]);
    }
}
