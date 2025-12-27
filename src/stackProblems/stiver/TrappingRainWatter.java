package stackProblems.stiver;

import java.util.Arrays;

public class TrappingRainWatter {
    public int totalTrappedWater(int [] nums){
        int total =0;
        int []rightMax = suffixMax(nums);
        int [] leftMax = prefixMax(nums);
        System.out.println(Arrays.toString(rightMax));
        System.out.println(Arrays.toString(leftMax));
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<leftMax[i] && nums[i]<rightMax[i]){
                total += Math.min(leftMax[i],rightMax[i]) - nums[i];
            }
        }
        return total;
    }
    public int totalTrappedWaterOptimized(int [] nums){
        int l=0,r= nums.length-1,rMax=0,lMax=0,total=0;
        while (l<r){
            if(nums[l]<nums[r]){
                if(lMax==0)
                    lMax=nums[l++];

                else {
                    total+=lMax-nums[l];

                }
                lMax = Math.max(lMax,nums[l]);

            } else if (nums[l] == nums[r]) {
                lMax=nums[l++];
            } else {
                if(rMax==0)
                    rMax = nums[r++];
                else {

                }
                rMax = Math.max(rMax,nums[r]);

            }
        }
        return 7;
    }

    private int[] suffixMax(int[] nums) {
        int [] ret = new int[nums.length];
        ret[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >=0 ; i--) {
            ret[i] = Math.max(nums[i],ret[i+1]);
        }
        return ret;
    }

    private int[] prefixMax(int[] nums) {
        int [] ret = new int[nums.length];
        ret[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret[i] = Math.max(nums[i],ret[i-1]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int [] arr= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWatter().totalTrappedWater(arr));
    }
}
