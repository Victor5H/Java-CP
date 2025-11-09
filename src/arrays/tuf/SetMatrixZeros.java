package arrays.tuf;

public class SetMatrixZeros {
    public static void bruteForceHelper(int [][]mat, int row, int col){
        for (int i = 0; i < mat.length; i++) {
            if(mat[i][col]!=0)
                mat[i][col]=-1;
        }
        for (int i = 0; i < mat[0].length; i++) {
            if(mat[i][col]!=0)
                mat[row][i]=-1;
        }
    }

    public static void bruteForce(int [][]mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==0) bruteForceHelper(mat,i,j);
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==-1) mat[i][j]=0;
            }
        }
    }
    public static void better(int[][]mat){
        int [] row = new int[mat.length];
        int []col = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==0) {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(row[i]==1||col[j]==1) {
                    mat[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
