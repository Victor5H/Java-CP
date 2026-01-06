package daily.TwentyFive.nineteenApril;

import java.util.Arrays;

public class RotateArray {
    public static void rotateArray(int [] nums){
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i-1] = nums[i];
        }
        nums[nums.length-1] = temp;
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        rotateArray(new int[]{1,2,3,4,5,6,7,8});
    }

}
