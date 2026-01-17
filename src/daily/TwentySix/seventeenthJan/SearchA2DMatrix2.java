package daily.TwentySix.seventeenthJan;
//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,m= matrix[0].length;
        int i=0,j=m-1;
        while(i<n && j>=0){
            if(matrix[i][j]==target){
                return true;
            }
            else if(target>matrix[i][j]){
                i++;
            }
            else j--;
        }
        return false;
    }
}
