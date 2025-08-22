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
        int [][]mat = {{11,12,13,14,15,16,17},{21,22,23,24,25,26,27},{31,32,33,34,35,36,37},{41,42,43,44,45,46,47},{51,52,53,54,55,56,57}};
        int r = mat.length;
        int c = mat[0].length;
//        while ()
        int minRow=0,maxRow=r-1;
        int minCol = 0,maxCol=c-1;
        int tn=r*c,n=0;
        while (n<tn) {
//        left wall
            for (int i = minRow,j=minCol; i <=maxRow && n<tn; i++) {
                System.out.print(mat[i][j]+" ");
                n++;
            }
            minCol++;
//            bottom wall
            for (int i = minRow,j=minCol; j <=maxCol&& n<tn; j++) {
                System.out.print(mat[i][j]+" ");
                n++;
            }
//            && n<tn for checking every time in for loop if all element has been printed
            maxRow--;
            for (int i =maxRow,j=maxCol; i >=minRow && n<tn; i--) {
                System.out.print(mat[i][j]+" ");
                n++;
            }
            maxCol--;
            for (int i = minRow,j=maxCol; j >=minCol && n<tn; j--) {
                System.out.print(mat[i][j]+" ");
                n++;
            }
            minRow++;
        }
    }

}
