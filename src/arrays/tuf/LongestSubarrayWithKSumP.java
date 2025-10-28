package arrays.tuf;

import java.util.HashMap;

public class LongestSubarrayWithKSumP {
    public static void bruteForce(int []nums, int k){
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if(sum==k){
                    max = Math.max(max,j-i+1);
                    System.out.println(i+" -> "+j);
                }
            }
        }
        System.out.println(max);
    }
    public static void better(int []nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0,length=0;
        for (int i = 0; i <nums.length; i++) {
            sum+=nums[i];
            map.put(sum,i);
            if(sum==k){
                length = Math.max(length,i+1);
            }
            Integer check =map.get(sum-k);
            if(check!=null){
                System.out.println(check+" -> "+i);
                length = Math.max(length,i-check);
            }
        }
        System.out.println(length);

    }
    public static void optimal(int[] nums,int k){
        int l=0,h=0,sum=nums[0],length=0;
        while (h< nums.length){
            while (l<=h && sum>k){
                sum-=nums[l++];
            }
            if(sum == k){
                length = Math.max(length,h-l+1);
            }
            h++;
            if(h< nums.length) sum+=nums[h];
        }
        System.out.println(length);
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4,1,1,1,1,4,2,3};
        int k =3;
        bruteForce(nums,k);
        better(nums,k);
        optimal(nums,k);
    }
}
