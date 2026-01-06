package daily.TwentyFive.fifteenthDec;

public class WordSearch {
    boolean[][] visited = null;
    private boolean dfs(int ind, String str, int m, int n, char[][] board) {
//        if(ind==str.length()) return true;
        if (str.charAt(ind) == board[m][n] && !visited[m][n]) {
            if(ind==str.length()-1) return true;
            visited[m][n]=true;
            boolean res = false;
            int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int[] dx : d) {
                int dr = m + dx[0];
                int dc = n + dx[1];
                if (dr < board.length && dc < board[0].length && dr >= 0 && dc >= 0 && !visited[dr][dc]) {
                    res = res || dfs(ind + 1, str, dr, dc, board);
                }
            }
            visited[m][n]=false;
            return res;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        if(board.length==1 && board[0].length==1 && word.length()==1 && word.charAt(0)==board[0][0]) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean res = dfs(0, word, i, j, board);
                if (res) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
//        char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
        char board[][] = {{'a','a'}};
        String word = "aa";
        System.out.println(ws.exist(board,word));

    }
}
