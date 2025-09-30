package dp.tuf;

import java.util.Arrays;

public class MazeObstacles {
    /// /kind of similar to grid unique paths
    public static int recursion(int[][] maze, int row, int col) {
        if(row<0||col<0) return 0;
        if(maze[row][col]==-1) return 0;
        if (row == 0 && col == 0)
            return 1;
        int up = row-1;
        int left = col-1;
        up = recursion(maze,up,col);
        left = recursion(maze, row, left);
        return up+left;

    }
    static int [][]dp;
    public static int memoization(int[][] maze, int row, int col) {
        if(row<0||col<0) return 0;
        if(maze[row][col]==-1) return 0;
        if (row == 0 && col == 0)
            return 1;
        if (dp[row][col]!=-1) return dp[row][col];
        int up = row-1;
        int left = col-1;
        up = memoization(maze,up,col);
        left = recursion(maze, row, left);
        return up+left;

    }

    public static void main(String[] args) {
        int [][]maze = new int[][]{
                {0,0,0},
                {0,0,0},
                {0,-1,0}
        };
        if(maze[0][0]==-1){ System.out.println(0); return;}
        System.out.println(recursion(maze, maze.length-1, maze[0].length-1));
        dp = new int[maze.length][maze[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(memoization(maze, maze.length-1,maze[0].length-1));
        int [][]t = new int[maze.length][maze[0].length];
        t[0][0] = 1;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if(i==0&&j==0) continue;
                else if(maze[i][j]!=-1) {
                    int up = 0;
                    int left = 0;
                    if(i>=1) up = t[i-1][j];
                    if(j>=1)left = t[i][j-1];
                    t[i][j] = up+left;
                }
            }
        }
        System.out.println(t[t.length-1][t[0].length-1]);
        int [] prev = new int[maze[0].length];
        prev[0] = 1;
        for (int i = 0; i < maze.length; i++) {
            int []curr = new int [prev.length];
            for (int j = 0; j < maze[0].length; j++) {
                if(i==0&&j==0) curr[j]=1;
                else if(maze[i][j]!=-1) {
                    int up = 0;
                    int left = 0;
                    if(i>=1) up = prev[j];
                    if(j>=1)left = curr[j-1];
                    curr[j] = up+left;
                }
                prev = curr;
            }

        }
        System.out.println(prev[prev.length-1]);
    }
}
