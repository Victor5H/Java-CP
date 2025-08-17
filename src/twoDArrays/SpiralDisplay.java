package twoDArrays;

import java.util.Scanner;

public class SpiralDisplay {
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
//    https://www.youtube.com/watch?v=SVFXEqn3Ceo
    public static void main(String[] args) {
        int [][]mat = inputMat();
        int r = mat.length;
        int c = mat[0].length;
//        int i = 0,j=0;
        for (int j = 0;j<mat[0].length;j++){
            for (int i = 0; i < mat.length; i++) {

            }
        }
    }

}
