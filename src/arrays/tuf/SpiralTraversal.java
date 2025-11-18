package arrays.tuf;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralTraversal {
    public static int[] print(int [][]matrix){
        ArrayList<Integer> list = new ArrayList<>();
        int n = matrix.length,m = matrix[0].length;
        int top = 0,bottom= n-1,left = 0,right=m-1;

        while (top<=bottom && left<=right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
//            check if there is something to print
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int [][]mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}} ;
        System.out.println(Arrays.toString(print(mat)));
    }
}
