package arrays.tuf;

public class RotateMatrixBy90Deg {
    public void bruteForce(int[][] matrix){
        int[][] ans = new int[matrix.length][matrix[0].length];
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans[j][(n-1)-i] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
        /*time and space complexity is O(n^2)*/
    }
    public void best(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int l=0,h= matrix.length-1;
            while (l<h){
                int temp= matrix[i][l];
                matrix[i][l] = matrix[i][h];
                matrix[i][h] = temp;
                l++;h--;
            }
        }
    }
}
