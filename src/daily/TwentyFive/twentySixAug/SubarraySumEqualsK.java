package daily.TwentyFive.twentySixAug;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int l =0,r=0,countS=0,sum=0;
        while (r< nums.length){
            sum+=nums[r];
            while(sum>k){
                sum-=nums[l++];
            }
            if(sum==k){
                countS++;
                sum=nums[r];
                l=r;
            }
            r++;
        }
        return countS;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3},3));
    }
}
