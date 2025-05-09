package stackProblems;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static int [] ss(int nums[]){
        Stack<Integer> stack = new Stack<>();
        int [] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()]<=curr){
                stack.pop();
            }
            if (stack.empty()){
                ret[i] = i+1;
            }
            else ret[i] = i-stack.peek();
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ss(new int[]{1,2,3,44,2,1,3,5,429,67})));
    }
}
