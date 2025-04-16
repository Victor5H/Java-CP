package recursion;

import java.util.ArrayList;

public class GetMazePaths {
    public static ArrayList<String> getMazePath(int sr,int sc,int dr,int dc){
        if(sr>dr||sc>dc){return new ArrayList<>();}
        if (sr==dr && sc==dc){
            ArrayList<String> ret = new ArrayList<>();
            ret.add("");
            return ret;
        }
       // ArrayList<String> up = getMazePath(sr-1,sc,dr,dc);
        ArrayList<String> down = getMazePath(sr+1,sc,dr,dc);
//        ArrayList<String> left = getMazePath(sr,sc-1,dr,dc);
        ArrayList<String> right = getMazePath(sr,sc+1,dr,dc);
        ArrayList<String> res = new ArrayList<>();
//        for (String s:up){
//            res.add("up "+s);
//        }
        for (String s:down){
            res.add("down "+s);
        }
//        for (String s:left){
//            res.add("left "+s);
//        }
        for (String s:right){
            res.add("right "+s);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getMazePath(0,0,2,2));
    }
}
