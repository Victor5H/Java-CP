package recursion.l1.revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetMazePaths {
    public static List<String> my(int[][]mat, int r, int c){
        if(r == mat.length&& c ==mat[0].length){
            List<String> li = new ArrayList<>();
            li.add("");
            return li;
        }
        if(r > mat.length|| c >mat[0].length){
            return new ArrayList<>();
        }
        List<String> down = my(mat,r+1,c);
        List<String> left = my(mat,r,c+1);
        List<String>ret = new ArrayList<>();
        for (String d:down){
            ret.add("down "+d);
        }
        for (String l:left){
            ret.add("left "+l);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(my(new int[3][3],0,0));
    }
}
