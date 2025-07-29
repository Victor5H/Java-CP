package recursion.l2;

import java.util.ArrayList;
import java.util.List;

public class GoldMine2 {
    public static void travelAndCollect(int[][]arr, boolean[][]visited, List<Integer> bag,int i, int j){
        if(i< 0|| i>= arr.length || j>=arr[0].length || j<0|| visited[i][j] ||arr[i][j]==0)
            return;
        bag.add(arr[i][j]);
        travelAndCollect(arr,visited,bag,i-1,j);
        travelAndCollect(arr,visited,bag,i,j+1);
        travelAndCollect(arr,visited,bag,i,j-1);
        travelAndCollect(arr,visited,bag,i+1,j);
    }
    public static int start(int [][] arr){
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int num=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j]!=0 && !visited[i][j]){
                    ArrayList<Integer> bag = new ArrayList<>();
                    travelAndCollect(arr,visited,bag,i,j);
                    int sum=0;
                    for(Integer ele:bag){
                        sum+=ele;
                    }
                    if(sum>num) num = sum;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {

    }
}
