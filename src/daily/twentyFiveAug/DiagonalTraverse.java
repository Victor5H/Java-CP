package daily.twentyFiveAug;

import java.util.ArrayList;
//https://leetcode.com/problems/diagonal-traverse
public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        ArrayList<Integer> list = new ArrayList<>();
        int i=0,j=0;
        int m =mat.length,n = mat[0].length;
        boolean flag = false;
        while(list.size()!=m*n){
            System.out.println(list);
            if(!flag){//go up
                    list.add(mat[i][j]);
                    if(i==0)
                        flag = true;
                    i--;
                    j++;
            }
            else{// go down
                while(j>=0 || i<m){
                    list.add(mat[i][j]);
                    if(j==0)
                        flag = false;
                    else
                        i++;
                    j--;
                }
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue) // Map Integer objects to int primitives
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
