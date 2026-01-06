package daily.TwentySix.sixthJan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n=nums.length;
        int[] arr = Arrays.stream(nums)
                .sorted()
                .toArray();
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j=i+1,k=n-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum==0){
                    List<Integer> toAdd = new ArrayList<>();
                    toAdd.add(arr[i]);
                    toAdd.add(arr[j]);
                    toAdd.add(arr[k]);
                    res.add(toAdd);
                    int prevJ=arr[j],prevK=arr[k];
                    while(j<n && arr[j]==prevJ){j++;}
                    while(k<=0 && arr[k]==prevK){k--;}
                }
                else if(sum>0){
                    k--;
                }
                else{
                    j++;
                }
            }

        }
        return res;
    }

}
