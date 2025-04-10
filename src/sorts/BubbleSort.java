package sorts;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort implements Sort{
    @Override
    public void sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length -i-1; j++) {
                int next = j+1;
                if(nums[j]>nums[next]){
                    int swap = nums[j];
                    nums[j] = nums[next];
                    nums[next]=swap;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Random().nextInt(3000);
        }
        System.out.println(Arrays.toString(nums));
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
