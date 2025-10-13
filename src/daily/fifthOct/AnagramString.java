package daily.fifthOct;

import java.util.HashMap;

public class AnagramString {
    public static boolean isAnagram(String f, String s){
        HashMap<Character,Integer> firstMap = new HashMap<>();
        HashMap<Character,Integer> secondMap = new HashMap<>();
        for (int i = 0; i < f.length(); i++) {
            firstMap.put(f.charAt(i),firstMap.getOrDefault(f.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            secondMap.put(s.charAt(i),secondMap.getOrDefault(s.charAt(i),0)+1);
        }
        return firstMap.equals(secondMap);
    }
    public static void main(String[] args) {
        String s1 = "act";
        String s2 = "tac";
        System.out.println(isAnagram(s1,s2));
    }
}
