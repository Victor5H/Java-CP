package daily.seventeenApril;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static int find(String input){
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length() ; i++) {
            if(map.containsKey(input.charAt(i))){
                map.put(input.charAt(i),map.get(input.charAt(i))+1);
            }
            else map.put(input.charAt(i),1);
        }
        Character c = map.entrySet().stream().filter(n-> n.getValue()==1).findFirst().get().getKey();
        return input.indexOf(c);
    }
//    chat gpt optimized
//    public static int find(String input) {
//        Map<Character, Integer> map = new LinkedHashMap<>();
//
//        // Count frequency of each character
//        for (int i = 0; i < input.length(); i++) {
//            char ch = input.charAt(i);
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//
//        // Find the first character with frequency 1
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                return input.indexOf(entry.getKey());
//            }
//        }
//
//        return -1; // No non-repeating character found
//    }

    public static void main(String[] args) {
        System.out.println(find("loveleetcode"));
    }
}
