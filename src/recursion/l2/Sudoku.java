package recursion.l2;

import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {

    }
    public static void displayBoard(int [][]arr){
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void solve(int i, int j, int [][] board){
        if(i==board.length){
            displayBoard(board);
        }

        int ni=0;
        int nj=0;
        if(j== board[0].length-1){
            ni = i+1;
            nj=0;
        }
        else {
            ni=i;
            nj=j+1;
        }
        if(board[i][j]!=0)
            solve(ni,nj,board);
        for (int k = 1; k <= 9; k++) {
                if(checkIfMoveValid(board,i,j,k)){
                    board[i][j] = k;
                    solve(ni,nj,board);
                    board[i][j]=0;
                }

        }
    }

    private static boolean checkIfMoveValid(int[][] board, int i, int j, int val) {
        for (int l = 0; l < board.length; l++) {
            return board[l][j] != val;
        }
        for (int l = 0; l < board[0].length; l++) {
            return  board[i][l] != val;
        }
        int smi = (i/3)*3;
        int smj = (j/3)*3;
        for (int k = smi; k < smi+3; k++) {
            for (int l = smj; l < smj+3; l++) {
                return board[k][l] != val;
            }
        }
        return false;
    }
}
