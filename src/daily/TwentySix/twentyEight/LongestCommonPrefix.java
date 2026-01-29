package daily.TwentySix.twentyEight;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Trie t = new Trie();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals("")) return "";
            t.insert(strs[i]);
        }
        Trie.TrieNode trav = t.root;
        // System.out.println(trav.children);
        while(trav.children.size()==1 && !trav.eow){ //to check if this is the end of the word
            char c = trav.children.keySet().iterator().next();
            sb.append(c);
            trav = trav.children.get(c);
        }
        return sb.toString();
    }
}
