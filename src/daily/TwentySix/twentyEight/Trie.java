package daily.TwentySix.twentyEight;

import java.util.HashMap;
//https://leetcode.com/problems/implement-trie-prefix-tree/

public class Trie {
    class TrieNode{
        HashMap<Character,TrieNode> children;
        boolean eow;
        public TrieNode(){
            children = new HashMap<>();
            eow=false;
        }
    }

    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode trav = root;
        // int n = word.length();
        for(char c:word.toCharArray()){
            if(!trav.children.containsKey(c)){
                TrieNode n = new TrieNode();
                trav.children.put(c,n);
                trav = n;
            }
            else{
                trav = trav.children.get(c);
            }
        }
        trav.eow=true;
    }

    public boolean search(String word) {
        TrieNode trav = root;
        for(char c: word.toCharArray()){
            if(!trav.children.containsKey(c)){
                return false;
            }
            else{
                trav = trav.children.get(c);
            }
        }
        return trav.eow;
    }

    public boolean startsWith(String word) {
        TrieNode trav = root;
        for(char c: word.toCharArray()){
            if(!trav.children.containsKey(c)){
                return false;
            }
            else{
                trav = trav.children.get(c);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
