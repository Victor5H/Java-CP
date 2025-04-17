package leetcode.interview150;

import java.util.HashMap;

public class RomanToInteger {
    public static HashMap<String,Integer> map = new HashMap<>();
    static{
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
    }
    public static int romanToInt(String s) {
        int value=0,prev=0;
        for(int i=s.length()-1;i>=0;i--){
            String cs = s.charAt(i)+"";
            int curr = map.get(cs);
//            System.out.println(curr);
            if(curr<prev)value-=curr;
            else value+=curr;
            prev=curr;
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
