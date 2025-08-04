package csesProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GridPathDescription {
    public static int count = 0;
    public static int steps=0;
    public static void main(String[] args) {
        String inp = new Scanner(System.in).next();
//        String inp = "??????R??????U??????????????????????????LD????D?";
        boolean [][]visited = new boolean[7][7];
//        System.out.println(Arrays.deepToString(visited));
        solve(inp,0,0,0,visited);
        System.out.println(count);
//        System.out.println(steps    );

    }
    public static void solve(String inp, int ind, int i, int j, boolean[][]visited){
        if(i==6 && j==0 && ind==48){count++; return;}
        if(i<0 || j<0 ||i>=7|| j>=7 || ind>=inp.length() || visited[i][j] || steps==48) return;
        char curr = inp.charAt(ind);
        visited[i][j] =true;
        List<List<Integer>> next = new ArrayList<>();
        if(curr=='?'){
            next.add(Arrays.asList(i+1,j));
            next.add(Arrays.asList(i-1,j));
            next.add(Arrays.asList(i,j+1));
            next.add(Arrays.asList(i,j-1));
        } else if (curr == 'R') {
            next.add(Arrays.asList(i,j+1));
        }
        else if (curr == 'L') {
            next.add(Arrays.asList(i,j-1));
        }
        else if (curr == 'U') {
            next.add(Arrays.asList(i-1,j));
        }
        else if (curr == 'D') {
            next.add(Arrays.asList(i+1,j));
        }
        for (int k = 0; k < next.size(); k++) {
            int ni = next.get(k).get(0);
            int nj = next.get(k).get(1);
            if(ni<7 && nj<7 && ni>=0&& nj>=0) {
                if (!visited[ni][nj]) {
                    steps++;
                    solve(inp, ind + 1, ni, nj, visited);
                    steps--;
                }
            }
        }
        visited[i][j] =false;
    }
}
