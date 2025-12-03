package daily.thirdDec;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    int []t;
    public int dfs(int []nums,int i){
        if(i>=nums.length) return 0;
        if(t[i]!=-1) return t[i];
        int with = dfs(nums,i+2)+nums[i];
        int without = dfs(nums,i+1);
        return t[i]=Math.max(with,without);
    }
    public int rob(int[] nums) {
        // t=new int[nums.length];
        // Arrays.fill(t,-1);
        // return dfs(nums,0);
        int []dp = new int[nums.length];
        dp[dp.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            int with=nums[i];
            int without = dp[i+1];
            if(i+2<nums.length){
                with +=dp[i+2];
            }
            dp[i] = Math.max(with,without);
        }
        return dp[0];
    }
}
