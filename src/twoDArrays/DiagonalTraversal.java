package twoDArrays;

import sorts.InsertionSort;

import java.util.ArrayList;

public class DiagonalTraversal {
    public static void main(String[] args) {
        int [][]mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> list = new ArrayList<>();
        int i=0,j=0;
        for (int k = 0; k < mat[0].length; k++) {// for number of diagonals
            i=0;
            j=k;
            while (j< mat[0].length){
                list.add(mat[i++][j++]);
            }
        }
        System.out.println(list);
    }
}
