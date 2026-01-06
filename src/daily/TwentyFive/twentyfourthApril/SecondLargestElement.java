package daily.TwentyFive.twentyfourthApril;

public class SecondLargestElement {
    public static int secondLargest(int [] nums){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE+1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max2 && nums[i]>max1){
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i]>max2 && nums[i]<max1){
                max2 = nums[i];
            }
        }
        return max2;
    }
    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{5, 5, 5, 3, 2}));
    }
}
