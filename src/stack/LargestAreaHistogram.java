package stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestAreaHistogram {
    public static int lah(int [] nums){
        int[] smallestOnLeft = new int [nums.length];
        int []smallestOnRight = new int [nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i]<= nums[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()) smallestOnLeft[i] = -1;
            else  smallestOnLeft[i] = stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(smallestOnLeft));
        stack.clear();
        for (int i = nums.length-1; i >=0; i--) {
            while (!stack.isEmpty() && nums[i]<= nums[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()) smallestOnRight[i] = nums.length;
            else  smallestOnRight[i] = stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(smallestOnRight));
        int maxArea = 0;
        for (int i = 0; i < nums.length; i++) {
            int width = smallestOnRight[i]-smallestOnLeft[i]-1;
            int area = nums[i]*width;
            if(area>maxArea) maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(lah(new int[]{1,4,5,3,5,3,2}));
    }
}
