package daily.TwentySix.twelvethJan;
//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
public class LC1493 {
    public int mySol(int[] nums) {
        int zIW = 0, zI=-1,n=nums.length,l=0,maxLen=0;
        for(int r=0;r<n;r++){
            if(nums[r]== 0){
                if(zIW==0){
                    zIW++;
                }
                else{
                    l=zI+1;
                }
                zI=r;
            }
            else if(nums[r]==1){
                int len = (r-l+1);
                if(zIW!=0) len--;
                maxLen = Math.max(len,maxLen);
            }
        }
        if(zI==-1) return n-1;
        return maxLen;
    }
}
