package twoDArrays;

public class SaddlePoint {
    public static void main(String[] args) {
        int [][]mat = {{11,12,13,14},{21,22,23,24},{34,33,31,34}};
        for (int i = 0; i < mat.length; i++) {
            int sj = 0;
            for (int j = 1; j < mat[0].length; j++) {
                if(mat[i][j]<mat[i][sj]){
                    sj = j;
                }
            }
            boolean flag=true;
            for (int k  = 0; k <mat.length ; k++) {
                if(mat[k][sj]>mat[i][sj]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(mat[i][sj]);
                return;
            }
        }
        System.out.println("No saddle point");

    }
}
