package daily.TwentySix.twelvethJan;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
public class LC1239 {
    List<String> l = null;
    int max=0;
    public boolean hasRepeatingChars(String str) {
        Set<Character> characters = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!characters.add(c)) {
                // Character already exists in the set, so it's a duplicate
                return true;
            }
        }
        // No duplicates found after checking all characters
        return false;
    }
    public void dfs(int ind, String ansSF){
        if(ind>=l.size()){
            max = Math.max(ansSF.length(),max);
            return;
        }

        String curr = l.get(ind);
        boolean skip=false;
        for(int i=0;i<curr.length();i++){
            if(ansSF.contains(String.valueOf(curr.charAt(i)))){skip=true ; break;}
        }
        dfs(ind+1,ansSF);
        if(!skip)
            dfs(ind+1,ansSF+curr);

    }
    public int maxLength(List<String> arr) {
        l = arr.stream().filter(e->!hasRepeatingChars(e)).toList();
        dfs(0,"");
        return max;
    }
}
