package sorts;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort implements Sort{
    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
           int key = nums[i];
           int j=i-1;
           while (j>=0&&    nums[j]>key){
               nums[j+1] = nums[j];
               j--;
           }
           nums[j+1] = key;
        }
    }
    public static void main(String[] args) {
        int [] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(nums));
        new InsertionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}