package twoDArrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateBy90Degree {
    public static void display(int [][]mat){
        for (int i = 0; i < mat[0].length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }
    public static void main(String[] args) {
//        mat needs to be square
        int [][]mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        display(mat);
        // first transpose the matrix and the reverse the columns
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat[0].length; j++) {
                int temp =mat[i][j];
                mat[i][j] =mat[j][i];
                mat[j][i]=temp;
            }
        }
        System.out.println("---");
        display(mat);
        for (int i = 0; i < mat.length; i++) {
            int l = 0,h= mat.length-1;
            while (l<h){
                int temp =mat[i][l];
                mat[i][l] =mat[i][h];
                mat[i][h] = temp;
                l++;
                h--;
            }
        }
        System.out.println("---");
        display(mat);
    }
}
