package stackProblems;

import java.util.Arrays;
import java.util.Stack;

public class CelebrityProblem {
    public static int solve(int matrix[][]){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < matrix[0].length; i++) {
            stack.push(i);
        }
        while (stack.size()!=1){
            int p2 = stack.pop();
            int p1 = stack.pop();
            if(matrix[p1][p2]==0){
                stack.push(p1);
            }
            else {
                stack.push(p2);
            }
        }
        System.out.println(stack.peek());
        int p =stack.peek();
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[p][i]!=0){
                return -1;
            }
            if(matrix[i][p]!=1 && i!=p){
                return -1;
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        int [][]mat = new int[][]{{0,0,1,0},{0,0,1,0},{0,0,0,0},{0,0,1,0}};
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        System.out.println(solve(mat));
    }
}
