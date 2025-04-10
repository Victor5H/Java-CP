package sorts;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int mini=i;
            for (int j = i; j < nums.length; j++) {
                if(nums[mini]>nums[j]) mini = j;
            }
            int temp = nums[i];
            nums[i] = nums[mini];
            nums[mini] = temp;
        }
    }
    public static void main(String[] args) {
        int [] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Random().nextInt(3000);
        }
        System.out.println(Arrays.toString(nums));
        new SelectionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
