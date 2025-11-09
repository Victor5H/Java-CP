package arrays.tuf;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static List<Integer> bruteForce(int [] nums){
        List<Integer> ans  = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean leader = true;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]>nums[i]){ leader=false; break;}
            }
            if(leader) ans.add(nums[i]);
        }
        return ans;
    }
    public static List<Integer> optimal(int[] nums){
        List<Integer> ans  = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = nums.length-1; i >=0; i--) {
            if(nums[i]>max){
                max = nums[i];
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int []arr = new int[]{10,22,12,3,0,6};
        System.out.println(optimal(arr));
    }
}
