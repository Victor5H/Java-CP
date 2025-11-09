package arrays.tuf;

public class MaximumSubArraySum {
    public static void better(int [] nums){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+= nums[j];
            }
            max = Math.max(sum,max);
        }
        System.out.println(max);
    }
    public static void optimal(int []nums){
//        kadane's algo
        int sum=0,max=Integer.MIN_VALUE;
        int start=0,ansStart=-1,ansEnd=-1;
        for (int i = 0; i < nums.length; i++) {
            if(sum==0){
                start=i;
            }
            sum+=nums[i];
            if (sum>max){
                max=sum;
                ansStart=start;
                ansEnd=i;
            }
            if(sum<0){ sum=0; continue;}
        }
        System.out.println(max);
        System.out.println(ansStart+" -> "+ansEnd);
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,2-3,-4,5,6,1};
        better(nums);
        optimal(nums);
    }
}
