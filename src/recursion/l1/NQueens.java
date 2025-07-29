package recursion.l1;

public class NQueens {
    public static void solve(int[][] chess, String qsf, int row) {
        if (row == chess.length) {
            System.out.print(qsf);
            return;
        }
        for (int col = 0; col < chess[0].length; col++) {
            if (isQueenSafe(chess, row, col)) {
                chess[row][col] = 1;
                int num = row + 1;
                solve(chess, qsf + " " + num + " queen on " + row + " - " + col + "\n", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean isQueenSafe(int[][] chess, int row, int col) {
//        check for same column
        for (int i = 0; i < row; i++)
            if (chess[i][col] == 1) return false;

//      check for same diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        solve(new int[n][n], "", 0);

    }
}
