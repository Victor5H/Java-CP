package twoDArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int [][]one = new int [r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                one[i][j] = sc.nextInt();
            }
        }
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int [][]two = new int [r1][c1];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                two[i][j] = sc.nextInt();
            }
        }
        if(r1!=c2){ System.out.println("Invalid"); return;}
        int [][] prod = new int [r1][c2];
        for (int i = 0; i < prod.length; i++) {
            for (int j = 0; j < prod[0].length; j++) {
                for (int k = 0; k < r1; k++) {
                    prod[i][j] +=one[i][k]+two[k][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(prod));
    }
}