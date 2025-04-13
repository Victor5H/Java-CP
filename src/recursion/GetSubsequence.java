package recursion;

import java.util.ArrayList;

public class GetSubsequence {
    public static ArrayList<String> gss(String str){
        if(str.length()==0){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char c = str.charAt(0);
        ArrayList<String> res =gss(str.substring(1));
        ArrayList<String> sub = new ArrayList<>();
        for(String s:res){
            sub.add(""+s);
            sub.add(c+s);
        }
        return sub;
    }

    public static void main(String[] args) {
        System.out.println(gss("abc"));
    }
}
