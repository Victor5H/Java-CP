package recursion.l1.revision;

import java.util.ArrayList;
import java.util.List;

public class GetSubsequence {
    static List<String> list = new ArrayList<>();
    public static void levelOrder(String input,int ind, String ansSF){
        if (ind==input.length()){ list.add(ansSF); return;}
        levelOrder(input,ind+1,ansSF+input.charAt(ind));
        levelOrder(input,ind+1,ansSF);
    }
    public static List<String> fandE(String inp, int ind){
        if (ind==inp.length()){ List<String> l = new ArrayList<>();l.add("");return l;}
        List<String> got = fandE(inp,ind+1);
        List<String> ret = new ArrayList<>();
        for (String o:got){
            ret.add(inp.charAt(ind)+o);
        }
//        or can put it in same loop as above
        for (String o:got){
            ret.add("-"+o);
        }
        return ret;
    }
    public static void main(String[] args) {
        String f = "abc";
        levelOrder(f,0,"");
        System.out.println(list);
        System.out.println(fandE(f,0));
    }
}
