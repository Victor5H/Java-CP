package dp.pepCoding;

import java.util.HashMap;

public class DecodeWays {
    static HashMap<Integer, Character> map= new HashMap<>();
    public static void main(String[] args) {
        for (int i = 1; i <=26; i++) {
            map.put(i, (char) (96+i));
        }
        String input = "231011";
        System.out.println(map);
        int [] t = new int[input.length()];
        t[0]=1;
        for (int i = 1; i < t.length; i++) {

        }
    }
}
