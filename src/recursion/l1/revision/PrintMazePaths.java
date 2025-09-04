package recursion.l1.revision;

public class PrintMazePaths {
    public static void levelOrder(int mat[][],int r, int c, String ansSF){
        if(r> mat.length || c>mat[0].length) return;
        if(r== mat.length&&c==mat[0].length){ System.out.println(ansSF); return;}
        levelOrder(mat, r+1, c, ansSF+ "D ");
        levelOrder(mat, r, c+1, ansSF+ "R ");
    }

    public static void main(String[] args) {
        levelOrder(new int[3][3],0,0,"");
    }
}
