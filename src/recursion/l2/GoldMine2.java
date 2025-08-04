package recursion.l2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoldMine2 {
    public static int travelAndCollect(int[][]arr, boolean[][]visited,int i, int j){
        if(i< 0|| i>= arr.length || j>=arr[0].length || j<0|| visited[i][j] || arr[i][j]==0) {
            System.out.println(Arrays.deepToString(visited));
            return 0;
        }
        visited[i][j] = true;
        int res = arr[i][j];
        List<List<Integer>> neighbours = new ArrayList<>();
        neighbours.add(Arrays.asList(i-1,j));
        neighbours.add(Arrays.asList(i,j+1));
        neighbours.add(Arrays.asList(i,j-1));
        neighbours.add(Arrays.asList(i+1,j));
        for (List<Integer> next :neighbours){
            res = Math.max(res,arr[i][j]+travelAndCollect(arr,visited,next.get(0),next.get(1)));
            System.out.println(res);
        }
        visited [i][j] = false;
        return res;
    }
    public static int start(int [][] arr){

        int num=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j]!=0){
                    boolean[][] visited = new boolean[arr.length][arr[0].length];
                     num=Math.max(num,travelAndCollect(arr,visited,i,j));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(start(arr));

    }
}
