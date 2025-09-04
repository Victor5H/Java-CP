package recursion.l1.revision;

public class KnightsTour {
    public static void display(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void solve(int[][] mat,int r, int c, int n){
        if(r<0||c<0||r>=mat.length||c>=mat[0].length||mat[r][c]!=0) return;
        if(n==mat.length*mat[0].length){
            mat[r][c]=n;
            display(mat);
            mat[r][c]=0;
            return;
        }
        int [][] dx = new  int[][]{{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
        for (int[] d : dx) {
            mat[r][c] = n;
            solve(mat, r + d[0], c + d[1], n + 1);
            mat[r][c] = 0;
        }
    }

    public static void main(String[] args) {
        solve(new int[5][5],4,4,1);
    }
}
