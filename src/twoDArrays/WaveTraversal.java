package twoDArrays;

import java.util.Scanner;

public class WaveTraversal {
    public static int [][] inputMat(){
        Scanner sc  = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int [][]mat = new int [r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        return mat;
    }
    public static void main(String[] args) {
        int [][]mat = inputMat();
        int r = mat.length;
        int c = mat[0].length;
        for (int i = 0; i < c; i++) {
            if(i%2==0) {
                for (int j = 0; j < r; j++) {
                    System.out.println(mat[j][i]);
                }
            }
            else {
                for (int j = r-1; j >=0; j--) {
                    System.out.println(mat[j][i]);
                }
            }
        }
    }
}
