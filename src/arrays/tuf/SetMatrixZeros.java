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
    public static void best(int [][]mat){
        int corner = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==0){
                    mat[i][0] = 0;
                    if(j==0)
                        mat[0][j] = 0;
                    else
                        corner=0;
                }
            }
        }
        for (int i = mat.length-1; i >=1 ; i--) {
            for (int j = mat[0].length; j >= 1; j--) {

            }
        }
    }

    public static void main(String[] args) {

    }
}
