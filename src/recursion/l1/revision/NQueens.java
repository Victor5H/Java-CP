package recursion.l1.revision;

public class NQueens {
    public static void solve(int [][]mat,int r, String ansSF){
        if(r< mat.length){
            for (int i = 0; i < mat.length; i++) {
                if(mat[r][i]==1) return;
            }
        }
        if(r==mat.length){
//            for (int i = 0; i < mat.length; i++) {
//                if(mat[r][i]==1) return;
//            }
            System.out.println(ansSF);
            return;
        }
        for (int i = 0; i < mat.length; i++) {
            mat[r][i]=1;
            solve(mat,r+1,ansSF+"-"+r+""+i);
            mat[r][i]=0;
        }
    }

    public static void main(String[] args) {
        solve(new int[2][2],0,"");
    }
}
