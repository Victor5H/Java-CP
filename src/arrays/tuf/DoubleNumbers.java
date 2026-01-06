package arrays.tuf;

import java.util.HashMap;

public class DoubleNumbers {
    public static int findXor(int []nums){
        int xor = 0;
        for (int n:nums){
            xor = xor^n;
        }
        return xor;
    }
    public static int findMap(int []nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int ans=0;
        for(int n:map.keySet()){
            if(map.get(n)==1) ans = n;
        }
        return ans;
    }
    public static int findBruteForce(int []nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans=0;
        for (int n:nums){
            int count=0;
            for (int c:nums) {
                if(c==n) count++;
            }
            if(count==1) ans=n;
        }

        return ans;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,1,2,3,3,4,4,5,5};
        System.out.println(findXor(nums));
        System.out.println(findMap(nums));
        System.out.println(findBruteForce(nums));
    }
}
