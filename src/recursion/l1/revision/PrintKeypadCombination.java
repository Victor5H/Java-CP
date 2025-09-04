package recursion.l1.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintKeypadCombination {
    static List<String> words = new ArrayList<>(Arrays.asList(".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"));
    public static void levelOrder(String inp, int ind, String ansSF){
        if (ind==inp.length()) {
            System.out.println(ansSF);
            return;
        }
        String word = words.get(inp.charAt(ind)-'0');
        for (char c:word.toCharArray()) {
            levelOrder(inp,ind+1,ansSF+c);
        }
    }

    public static void main(String[] args) {
        levelOrder("12",0,"");
    }
}
