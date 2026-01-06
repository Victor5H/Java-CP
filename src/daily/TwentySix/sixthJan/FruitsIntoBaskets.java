package daily.TwentySix.sixthJan;

import java.util.HashMap;
//https://leetcode.com/problems/fruit-into-baskets/
public class FruitsIntoBaskets {
    public int totalFruit(int[] fruits) {
        if(fruits.length<=2) return fruits.length;
        int maxLen = Integer.MIN_VALUE,n=fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int l=0,r=0;
        while(r<n){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            while(map.size()>2){
                int pop = fruits[l];
                map.put(pop,map.get(pop)-1);
                if(map.get(pop)==0) map.remove(pop);
                l++;
            }
            int length = (r-l)+1;
            if(length>maxLen) maxLen = length;
            r++;
        }
        return maxLen;
    }
}
