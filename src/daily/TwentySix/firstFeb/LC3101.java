package daily.TwentySix.firstFeb;

public class LC3101 {
    public int minimumCost(int[] nums) {
        int min = Integer.MAX_VALUE;
        int smin = min;
        for(int i=1;i<nums.length;i++){
            int v = nums[i];
            if(v<min){
                smin = min;
                min = v;
            }
            else if(v<smin) smin = v;
        }
        return nums[0]+min+smin;
    }
}
