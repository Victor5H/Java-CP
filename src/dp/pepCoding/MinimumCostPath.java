package dp.pepCoding;

import java.util.Arrays;

public class MinimumCostPath {
    public static int recursion(int[][] mat, int r, int c) {
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            return mat[r][c];
        }
        int[][] dx = new int[][]{{0, 1}, {1, 0}};
        int min = Integer.MAX_VALUE;
        for (int[] d : dx) {
            int dr = r + d[0];
            int dc = c + d[1];

            if (dr >= 0 && dc >= 0 && dr < mat.length && dc < mat[0].length && mat[dr][dc] != Integer.MAX_VALUE) {
                int temp = mat[r][c];
                mat[r][c] = Integer.MAX_VALUE;
                min = Math.min(min, recursion(mat, dr, dc));
                mat[r][c] = temp;
            }

        }
        return min == Integer.MAX_VALUE ? min : min + mat[r][c];
    }

    static int[][] dp;
//    memoization wont work since i am also modofying the mat to store visited, i also have to pass
//    the mat to memoiztion func.
//    public static int memoization(int[][]mat, int r, int c){
//        if(r==mat.length-1&&c==mat[0].length-1){
//            return dp[r][c]= mat[r][c];
//        }
//        if(dp[r][c]!=-1) return dp[r][c];
//        int [][]dx =new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
//        int min = Integer.MAX_VALUE;
//        for (int [] d:dx) {
//            int dr =r+d[0];
//            int dc = c+d[1];
//
//            if(dr>=0&&dc>=0&&dr< mat.length&&dc<mat[0].length && mat[dr][dc]!=Integer.MAX_VALUE){
//                int temp =mat[r][c];
//                mat[r][c]= Integer.MAX_VALUE;
//                min = Math.min(min,memoization(mat, dr, dc));
//                mat[r][c] = temp;
//            }
//
//        }
//        return dp[r][c] = min==Integer.MAX_VALUE?min:min+mat[r][c];
//    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {2, 8, 4, 1, 6, 4, 2},
                {6, 0, 9, 5, 3, 8, 5},
                {1, 4, 3, 4, 0, 6, 5},
                {6, 4, 7, 2, 4, 6, 1},
                {1, 0, 3, 7, 1, 2, 7},
                {1, 5, 3, 2, 3, 0, 9},
                {2, 2, 5, 1, 9, 8, 2}
        };
        System.out.println(recursion(mat, 0, 0));
        int[][] t = new int[mat.length][mat[0].length];
        t[mat.length - 1][mat[0].length - 1] = mat[t.length - 1][t[0].length - 1];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (j == t[0].length - 1 && i == t.length - 1)
                    continue;
                else {
                    t[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dx = new int[][]{{0, 1}, {1, 0}};
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (i == mat.length - 1 && j == mat[0].length - 1) continue;
                else {
                    int di, dj, min = Integer.MAX_VALUE;
                    for (int[] d : dx) {
                        di = d[0] + i;
                        dj = d[1] + j;
                        if (di <= mat.length - 1 && dj <= mat[0].length - 1 && dj >= 0 && di >= 0) {
                            min = Math.min(t[di][dj], min);
                        }
                    }
                    t[i][j] = min == Integer.MAX_VALUE ? min : min + mat[i][j];
                }

            }
        }
        for(int[] arr: t){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(t[0][0]);
    }
}
