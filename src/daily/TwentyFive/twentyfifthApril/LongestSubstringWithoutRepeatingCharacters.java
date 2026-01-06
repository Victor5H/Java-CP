package daily.TwentyFive.twentyfifthApril;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lswrc(String str){
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, maxCounter = 0;

        while (right < str.length()) {
            char curr = str.charAt(right);

            if (!set.contains(curr)) {
                set.add(curr);
                maxCounter = Math.max(maxCounter, right - left + 1);
                right++;
            } else {
                set.remove(str.charAt(left));
                left++;
            }
        }

        return maxCounter;
    }

    public static void main(String[] args) {
        System.out.println(lswrc("abcdefgabcdef"));
    }
}
