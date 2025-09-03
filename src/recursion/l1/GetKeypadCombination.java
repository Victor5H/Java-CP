package recursion.l1;

import java.util.ArrayList;
import java.util.List;

public class GetKeypadCombination {
    public static String [] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static List<String> getCombination(String input){
        if(input.isEmpty()){
            ArrayList<String > s = new ArrayList<>();
            s.add("");
            return s;
        }
        List<String> res = getCombination(input.substring(1));
        int ch = input.charAt(0)-'0';
        List<String> out = new ArrayList<>();
        String code = codes[ch];
        for (int i = 0;i<code.length();i++){
            char gc = code.charAt(i);
            for (String s: res){
                out.add(gc+s);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        List<String > res = getCombination("678");
        System.out.println(res);
        System.out.println(res.size());
    }
}
