package daily.TwentySix.seventeenthJan;

import java.util.HashMap;

public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
//        too much space
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
//         return map1.equals(map2);

//        constant space;

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 97]--;
        }
        //checking if any char extra
        for (int i : arr) {
            if (i != 0) return false;
        }

        return true;
    }
}
