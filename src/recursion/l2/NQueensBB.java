package recursion.l2;

import java.util.Scanner;

public class NQueensBB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        solve(new int[n][n], new boolean[n], new boolean[2*n-1], new boolean[2*n-1],0, "");
    }

    private static void solve(int[][] board, boolean[] cols, boolean[] diag1, boolean[] diag2, int row, String ansSF) {
        if(row>= board.length){
            System.out.println(ansSF);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            int d1 = row+i;
            int d2 = (row-i)+ board.length-1;
            if(!cols[i] && !diag1[d1] && !diag2[d2]) {
                cols[i] = true;
                diag1[d1] = true;
                diag2[d2] = true;
                String ans = row + 1 + " queen on " + row + " - " + i + "\n";
                solve(board, cols, diag1, diag2, row + 1, ansSF + ans);
                cols[i] = false;
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }
}
