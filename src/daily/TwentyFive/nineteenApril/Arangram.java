package daily.TwentyFive.nineteenApril;

import java.util.HashMap;

public class Arangram {
    public static boolean checkAnagram(String first, String second){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            char  curr = first.charAt(i);
            map1.put(curr,map1.getOrDefault(curr,0)+1);
        }
        for (int i = 0; i < second.length(); i++) {
            char  curr = second.charAt(i);
            map2.put(curr,map2.getOrDefault(curr,0)+1);
        }
        return map1.equals(map2);
    }

    public static void main(String[] args) {
        System.out.println(checkAnagram("listen","silent"));
    }
}
