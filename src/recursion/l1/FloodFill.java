package recursion.l1;

import java.util.Arrays;

public class FloodFill {
    public static void floodFill(int [][] maze, int row, int col, String pathSF, int [][] visited){
        if(row<0 || col<0 || row== maze.length || col== maze[0].length || maze[row][col]==1|| visited[row][col]==1)
            return;

        if((row== maze.length-1) && (col== maze[0].length-1)){
            System.out.println(pathSF);
            return;
        }
//        if(visited[row][col]==1) return;
        //tldr
        visited[row][col] = 1;
        System.out.println();
        for (int i = 0; i < maze.length; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }

        floodFill(maze,row-1,col,pathSF+"T ",visited);
        floodFill(maze,row,col-1,pathSF+"L ",visited);
        floodFill(maze,row+1,col,pathSF+"D ",visited);
        floodFill(maze,row,col+1,pathSF+"R ",visited);
        visited[row][col] =0;
    }

    public static void main(String[] args) {
        int [] [] maze = {{0,0,0},{0,0,0},{1,0,0}};
        for (int i = 0; i < maze.length; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }
        int[][] visited = new int [3][3];

        floodFill(maze,0,0,"",visited);

    }
}
