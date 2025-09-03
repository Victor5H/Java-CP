package recursion.l1.revision;

import java.util.ArrayList;
import java.util.List;

public class GetStairsPath {
    public static List<String> my (int n){
        if(n==0){
            ArrayList<String> li = new ArrayList<>();
            li.add("");
            return li;
        }
        if(n<0) return new ArrayList<>();
        List<String> one = my(n-1);
        List<String> two = my(n-2);
        List<String> three = my(n-3);
        List<String> ret = new ArrayList<>();
        for (String o:one){
            ret.add("1"+o);
        }
        for (String o:two){
            ret.add("2"+o);
        }
        for (String o:three){
            ret.add("3"+o);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println((my(5)));
    }
}
