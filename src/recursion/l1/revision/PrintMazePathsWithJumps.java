package recursion.l1.revision;

public class PrintMazePathsWithJumps {
    public static void levelOrder(int mat[][],int r, int c, String ansSF){
        if(r> mat.length || c>mat[0].length) return;
        if(r== mat.length&&c==mat[0].length){ System.out.println(ansSF); return;}
        for (int i = 1; i <= 3; i++) {
            levelOrder(mat, r+i, c, ansSF+i+ "Down ");
        }
        for (int i = 1; i <= 3; i++) {
            levelOrder(mat, r, c+i, ansSF+i+ "Right ");
        }
    }

    public static void main(String[] args) {
        levelOrder(new int[3][3],0,0,"");
    }
}
