package daily.TwentySix.seventeenthJan;
//https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,m= matrix[0].length;
        int i=0,j=n-1,k=0,l=m-1;
        while(i<=j){
            int midr = (i+j)/2;
//            System.out.println("i: "+i+" j: "+j);
            if(matrix[midr][k]<= target && matrix[midr][l]>=target){
                while(k<=l){
//                    System.out.println("k: "+k+" l: "+l);
                    int mid = (k+l)/2;
                    if(matrix[midr][mid]==target) return true;
                    else if(matrix[midr][mid]>target) l=mid-1;
                    else k=mid+1;
                }
                k=0;l=m-1;
                return false;
            }
            else if(target<matrix[midr][k]){
                j=midr-1;
            }
            else if(target>matrix[midr][l]){
                i=midr+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]mat = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int k =13;
        System.out.println(searchMatrix(mat,k));
    }

}
