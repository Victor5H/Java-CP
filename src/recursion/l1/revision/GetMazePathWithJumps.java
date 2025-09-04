package recursion.l1.revision;

import java.util.ArrayList;
import java.util.List;

public class GetMazePathWithJumps {
    public static List<String> my(int[][]mat, int r,int c){
        if(r== mat.length&&c==mat[0].length){
            ArrayList<String> ret = new ArrayList<>();
            ret.add("");
            return ret;
        }
        if(r> mat.length|| c>mat[0].length){
            return new ArrayList<>();
        }
        List<String> ret= new ArrayList<>();
        for (int i=1;i<=3;i++){
            List<String> downi = my(mat,r+i,c);
            for (String d:downi) {
                ret.add(String.valueOf(i)+" down "+d);
            }
        }
        for (int i=1;i<=3;i++){
            List<String> lefti = my(mat,r,c+i);
            for (String d: lefti) {
                ret.add(String.valueOf(i)+" left "+d);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(my(new int[3][3],0,0));
    }
}
