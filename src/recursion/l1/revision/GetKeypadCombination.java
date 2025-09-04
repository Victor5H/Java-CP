package recursion.l1.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetKeypadCombination {
    static List<String> words = new ArrayList<>(Arrays.asList(".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"));
    public static List<String> fandE(String inp, int ind){
        if (ind==inp.length()){
            List<String> li = new ArrayList<>();
            li.add("");
            return li;
        }
        String word = words.get(inp.charAt(ind)-'0');
        List<String> ret = new ArrayList<>();
        List<String> got = fandE(inp,ind+1);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (String o : got){
                ret.add(c+o);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(fandE("0",0));
    }
}
