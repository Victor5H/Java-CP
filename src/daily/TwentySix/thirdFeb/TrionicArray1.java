package daily.TwentySix.thirdFeb;
//https://leetcode.com/problems/trionic-array-i/
public class TrionicArray1 {
    public boolean isTrionic(int[] nums) {
        int i=1,n=nums.length;
        int p1=-1,q=-1,p2=-1;
        while(i<n && nums[i]>nums[i-1]){
            p1=i;
            i++;
        }
        if(p1==n-1) return false;

        while(i<n && nums[i]<nums[i-1]){
            q=i;
            i++;
        }
        if(q==n-1) return false;

        while(i<n && nums[i]>nums[i-1]){
            if(p1==-1) return false;
            p2=i;
            i++;
        }
        if(p2!=n-1) return false;
        return true;
    }
}
