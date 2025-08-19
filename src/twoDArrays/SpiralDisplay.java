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
        int [][]mat = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        int r = mat.length;
        int c = mat[0].length;
        for (int i = 0; i < c/2; i++) {
            for (int j = 0; j < r / 2; j++) {
                System.out.print(mat[j][i]+" ");
            }
            System.out.println();
        }
    }

}
