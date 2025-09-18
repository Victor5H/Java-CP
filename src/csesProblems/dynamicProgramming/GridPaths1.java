package csesProblems.dynamicProgramming;

import java.util.Scanner;

public class GridPaths1 {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        long [][]mat = new long[n][n];
        String in = "";
//        converting string into int mat, 1:block, 0:way
        for (int i = 0; i < n; i++) {
             in = s.next();
            for (int j = 0; j < in.length(); j++) {
                if(in.charAt(j)=='.'){
                    mat[i][j] = 0;
                }
                else {
                    mat[i][j] = 1;
                }
            }
        }
        int [][]t = new int[n][n];
        t[0][0]=1;
//        in case the size is one and that is also blocked
        if(n==1&&mat[0][0]==1){
            t[0][0]=0;
        }
        for (int i = 0; i<n ; i++) {
            for (int j = 0; j<n ; j++) {
                if(i==0&&j==0) continue;
                else if(mat[i][j]!=1) {
                    int [][]dx = new int[][]{{-1,0},{0,-1}};
                    for (int []d:dx){
                        int dr = i+d[0];
                        int dc = j+d[1];
                        if(dr>=0&&dc>=0 && mat[dr][dc]!=1){
                            t[i][j] = (t[i][j]+t[dr][dc])%mod;
                        }
                    }
                }
            }
        }

        System.out.println(t[n-1][n-1]);
    }
}
