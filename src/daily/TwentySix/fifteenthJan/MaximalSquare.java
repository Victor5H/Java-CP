package daily.TwentySix.fifteenthJan;

import java.util.Arrays;
//https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
    char [][]matrix = null;
    int n=0;
    int m =0;
    int [][]lenM = null;
    int maxArea = 0;
    public int dfs(int i, int j){
        if(i>=n || j>=m) return 0;
        if(matrix[i][j]=='0') return lenM[i][j]=0;
        if(lenM[i][j]!=-1) return lenM[i][j];
        int [][] dx  = {{1,0},{1,1},{0,1}};
        int len = Integer.MAX_VALUE;
        for(int []d:dx){
            int dr = i+d[0];
            int dc = j+d[1];
            len = Math.min(len,dfs(dr,dc));
        }
        len = len==Integer.MAX_VALUE?1:len+1;
        maxArea = Math.max(maxArea,len*len);
        return lenM[i][j]=len;
    }
    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        this.lenM = new int [matrix.length][matrix[0].length];
        for(int []i:lenM){
            Arrays.fill(i,-1);
        }
        this.n = matrix.length;
        this.m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(i,j);
            }
        }
//        System.out.println(Arrays.deepToString(lenM));
        return maxArea;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] ar = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(maximalSquare.maximalSquare(ar));
    }
}
