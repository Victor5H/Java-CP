package daily.TwentyFive.twentythOct;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/summary-ranges/
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0) return new ArrayList<>();
        int c = 0;
        List<String> ans  = new ArrayList<>();
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1){
                c++;
            }
            else {

                StringBuilder sb =  new StringBuilder();
                if(c==0){
                    sb.append(nums[i-1]);
                }
                else{
                    int prev = nums[i-1]-c;
                    sb.append(prev);
                    sb.append("->");
                    sb.append(nums[i-1]);
                }

                ans.add(sb.toString());
                c=0;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(c==0){
            sb.append(nums[nums.length-1]);
        }
        else{
            int prev = nums[nums.length-1]-c;
            sb.append(prev);
            sb.append("->");
            sb.append(nums[nums.length-1]);
        }
        ans.add(sb.toString());
        return ans;
    }
}
