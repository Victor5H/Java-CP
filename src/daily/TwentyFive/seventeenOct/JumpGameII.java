package daily.TwentyFive.seventeenOct;

import java.util.Arrays;

public class JumpGameII {
    public static int recursion(int []arr, int i){
        if(i==arr[arr.length-1]) return 0;
        int min =Integer.MAX_VALUE;
        for (int j = 1; j <= arr[i]; j++) {
            if(i+j<= arr.length-1){
                min = Math.min(min,recursion(arr, i+j));
            }
        }
        if(min==Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else return min+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        System.out.println(recursion(nums,0));
        int [] t= new int [nums.length];
        Arrays.fill(t,Integer.MAX_VALUE);
        t[t.length-1]=0;
        for(int i=t.length-2;i>=0;i--){
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=nums[i];j++){
                if(i+j<nums.length){
                    min = Math.min(min,t[i+j]);
                }
            }
            if(min==Integer.MAX_VALUE) t[i]= Integer.MAX_VALUE;
            else t[i]=min+1;
        }
        System.out.println(t[0]);
    }
}
