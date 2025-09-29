package dp.tuf;

import java.util.Arrays;

public class GridUniquePaths {
//// find all unique paths from top right to bottom left on a grid
    public static int recursion(int [][]grid, int row, int col){
        if(row==0&&col==0) return 1;
        int [][] dx = new int[][]{{-1,0},{0,-1}};
        int ret=0;
        for (int []d:dx) {
            int dr = d[0]+row;
            int dc = d[1]+col;
            if(dr>=0 && dc>=0){
                ret+=recursion(grid,dr,dc);
            }
        }
        return ret;

    }
    static int [][]dp;
    public static int memoization(int [][]grid, int row, int col){
        if(row==0&&col==0) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        int [][] dx = new int[][]{{-1,0},{0,-1}};
        int ret=0;
        for (int []d:dx) {
            int dr = d[0]+row;
            int dc = d[1]+col;
            if(dr>=0 && dc>=0){
                ret+=memoization(grid,dr,dc);
            }
        }

        return dp[row][col]=ret;

    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(recursion(new int[n][n],n-1,n-1));
        dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(memoization(new int[n][n],n-1,n-1));
////    tabulation
        int [][]t = new int[n][n];
        t[0][0]=1;
        int [][] dx = new int[][]{{-1,0},{0,-1}};
        for (int i = 0; i <t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if(i==0&j==0) continue;
                else {
                    for (int []d:dx) {
                        int dr = d[0]+i;
                        int dc = d[1]+j;
                        if(dr>=0 && dc>=0){
                            t[i][j]+=t[dr][dc];
                        }
                    }
                }
            }
        }
        System.out.println(t[t.length-1][t[0].length-1]);
////    space optimization, it's wrong
        int []so = new int[n];
        so[0]=1 ;
        for (int i = 0; i < n; i++) {
            int [] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0) continue;
                else {
                    for (int []d:dx) {
                        int dr = d[0]+i;
                        int dc = d[1]+j;
                        if(dr>=0 && dc>=0){
                            curr[j]+=curr[dc]+so[dr];
                        }
                    }
                }
            }
            so=curr;
        }
        System.out.println(so[n-1]);

    }
}
