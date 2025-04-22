package recursion;

import java.util.Arrays;

public class KnightsTour {
    static int countT=0;
    public static void solve(int[][] board,int row, int col, int count){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]!=0){
            return;
        }
        if(count == (board.length* board[0].length)){
            board[row][col]=count;

            for (int i = 0; i < board.length; i++) {
                System.out.println(Arrays.toString(board[i]));

            }
            countT++;
            board[row][col]=0;
            return;
        }
        board[row][col]=count;
        solve(board,row-2,col+1,count+1);
        solve(board,row-1,col+2,count+1);
        solve(board,row+1,col+2,count+1);
        solve(board,row+2,col+1,count+1);

        solve(board,row+2,col-1,count+1);
        solve(board,row+1,col-2,count+1);
        solve(board,row-1,col-2,count+1);
        solve(board,row-2,col-1,count+1);
        board[row][col]=0;
    }

    public static void main(String[] args) {
        int n = 5;
        solve(new int[n][n],0,0,1);
        System.out.println(countT);
    }
}
