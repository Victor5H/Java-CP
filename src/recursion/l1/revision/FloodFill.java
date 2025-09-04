package recursion.l1.revision;

public class FloodFill {
    static String [] dir = new String[]{"U","R","D","L"};
    public static void levelOrder(int[][] mat, int r, int c, String ansSF){
        if(r== mat.length-1&&c==mat[0].length-1){
            System.out.println(ansSF);
            return;
        }
        if(r>=mat.length||c>=mat[0].length||r<0||c<0)
            return;
        if(mat[r][c]==1) return;

        int[][] dx = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        for (int i = 0; i < dx.length; i++) {
            int []dif = dx[i];
            mat[r][c] = 1;
            levelOrder(mat,r+dif[0],c+dif[1],ansSF+dir[i]+" ");
            mat[r][c]=0;
        }
    }

    public static void main(String[] args) {
        int [][]mat = new int[][]{
                {0,0,0,0},
                {0,1,0,0},
                {0,0,0,0}
        };
        levelOrder(mat,0,0,"");
    }

}
