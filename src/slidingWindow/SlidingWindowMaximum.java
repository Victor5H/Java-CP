package slidingWindow;

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static int [] swm(int [] nums, int window){
        int left = 0, right = window-1;
        int[] ret  = new int [nums.length-window+1];
        int [] nler = new int [nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >=0 ;i--) {
            while (!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                nler[i] = nums.length;
            }
            else nler[i] = stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(nler));
        int j = 0;
        for (int i = 0; i <= nums.length - window; i++) {
            j=i;
            System.out.println(nums[i]);
            while (nler[j]<i+window){
                j=nler[j];
            }
            ret[i]=nums[j];
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(swm(new int[]{5,3,1,4,6,2,1,0,7},4)));
    }
}
