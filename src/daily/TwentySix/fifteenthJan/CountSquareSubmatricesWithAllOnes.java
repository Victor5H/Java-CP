package daily.TwentySix.fifteenthJan;

import java.util.Arrays;
//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
public class CountSquareSubmatricesWithAllOnes {
    int [][]mat=null;
    int n=0,m=0;
    int [][] maxL=null;
    public int dfs(int i, int j){
        if(i>=n || j>=m)
            return 0;
        if(mat[i][j]==0) return maxL[i][j]=0;
        if(maxL[i][j]!=-1) return maxL[i][j];

        int len = Integer.MAX_VALUE;
        int [][]dx = {{0,1},{1,0},{1,1}};
        for(int []d:dx){
            int dr = i+d[0];
            int dc = j+d[1];
            len = Math.min(len,dfs(dr,dc));
        }
        len = len==Integer.MAX_VALUE?1:len+1;
        return maxL[i][j]=len;
    }
    public int countSquares(int[][] matrix) {
        this.mat = matrix;
        this.n=matrix.length;
        this.m=matrix[0].length;
        int count=0;
        maxL = new int[n][m];
        for(int []m:maxL){
            Arrays.fill(m,-1);
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         count+=dfs(i,j);
        //     }
        // }
        int [][]dp = new int[n+1][m+1];
        // for(int []m:maxL){
        //     Arrays.fill(dp,0);
        // }
        int dpcount=0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(mat[i][j]==0){
                    dp[i][j]=0;
                }
                else{
                    int len = Integer.MAX_VALUE;
                    int [][]dx = {{0,1},{1,0},{1,1}};
                    for(int []d:dx){
                        int dr = i+d[0];
                        int dc = j+d[1];
                        len = Math.min(len,dp[dr][dc]);
                    }
                    len = len==Integer.MAX_VALUE?1:len+1;
                    dpcount+= dp[i][j]=len;
                }
            }
        }
        return dpcount;
    }
}
