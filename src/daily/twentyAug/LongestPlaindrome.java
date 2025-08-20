package daily.twentyAug;

import java.util.HashMap;
//https://leetcode.com/problems/longest-palindrome/
public class LongestPlaindrome {
    public int longestPalindrome(String s) {
        int count=0;
        HashMap<Character,Integer> map = new HashMap<>();
        char c = '4';
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        boolean odd= false;
        for(Integer i:map.values()){
            if(i%2==0) count+=i;
            else{
                count+=(i-1);
                odd=true;
            }
        }
        if(odd) count++;
        return count;
    }
}
