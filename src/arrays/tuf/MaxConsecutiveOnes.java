package arrays.tuf;

public class MaxConsecutiveOnes {
    public static int max(int [] nums){
        int max = Integer.MIN_VALUE,count=0;
        for (int n: nums) {
            if(n==1){
                count++;
                max = Math.max(count,max);
            }
            else
                count=0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[]nums = new int[]{1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(max(nums));
    }
}
