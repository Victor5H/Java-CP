package dp.pepCoding;

public class GoldMine {
    public static int recursion(int[][] mat, int r, int c){
        if(c==mat[0].length-1){
            return mat[r][c];
        }
        int [][]dx = new int[][]{{-1,1},{0,1},{1,1}};
        int max = Integer.MIN_VALUE;
        for(int[] d:dx){
            int dr = r+d[0];
            int dc = c+d[1];
            if(dr>=0&&dr< mat.length){
                max = Math.max(max,recursion(mat, dr, dc));
            }
        }
        return max==Integer.MIN_VALUE?max:max+mat[r][c];
    }

    public static void main(String[] args) {
        int[][]mine = new int[][]{
                {0,1,4,2,8,2},
                {4,3,6,5,0,4},
                {1,2,4,1,4,6},
                {2,0,7,3,2,2},
                {3,1,5,9,2,4},
                {2,7,0,8,5,1}
        };
        int rmax = Integer.MIN_VALUE;
        for (int i = 0; i < mine.length; i++) {
            int res = recursion(mine,i,0);
            System.out.println(res);
            rmax = Math.max(rmax,res);
        }
        System.out.println("ANS: "+rmax);
        int [][]t = new int[mine.length][mine[0].length];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if(j==t[0].length-1){
                    t[i][j]=mine[i][j];
                }
                else t[i][j]=Integer.MIN_VALUE;
            }
        }
        int dx[][] = new  int[][]{{-1,1},{0,1},{1,1}};
        for (int i = t[0].length-2; i >=0 ; i--) {
            for (int j = 0; j <t.length; j++) {
                int max = Integer.MIN_VALUE;
                for (int[]d:dx){
                    int dj = j+d[0];
                    int di = i+d[1];
                    if(dj >=0&& dj <t.length){
                        max = Math.max(max,t[dj][di]);
                    }
                }
                t[j][i] = max==Integer.MIN_VALUE?max:max+mine[j][i];
            }
        }
        System.out.println("--t--");
        rmax = Integer.MIN_VALUE;
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i][0]);
            rmax = Math.max(rmax,t[i][0]);
        }
        System.out.println("ANS: "+rmax);
    }
}
