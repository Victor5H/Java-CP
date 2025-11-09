package arrays.tuf;

import java.util.HashMap;

public class TwoSum {
    public static void bruteforce(int []nums, int sum){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i==j) continue;
                if(nums[i]+nums[j]==sum){
                    System.out.println(i+" "+j);
                    return;
                }
            }
        }
    }
    public static void optimal(int[]nums, int sum){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = sum-nums[i];
            if(map.containsKey(diff)){
                System.out.println(map.get(diff)+" "+i);
                return;
            }
            else map.put(nums[i],i);
        }
    }

    public static void main(String[] args) {
        int[]nums = new int[]{1,2,3,4,5,6,7,8,9};
        int sum = 7;
        bruteforce(nums,sum);
        optimal(nums,sum);
    }
}
