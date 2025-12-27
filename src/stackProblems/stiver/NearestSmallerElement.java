package stackProblems.stiver;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
//    next smaller element on the left
// tc: o(2n) for travering and for popping elements
//    sc: 0(n) +O(n) for arr and for stack
    public static int[] find(int [] nums){
        int [] ret = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while (!stack.isEmpty() && stack.peek()>=curr){
                stack.pop();
            }
            ret[i] = stack.isEmpty()?-1:stack.peek();
            stack.add(curr);
        }
        return ret;
    }

    public static void main(String[] args) {
        int [] arr= {4,5,2,10,8};
        System.out.println(Arrays.toString(find(arr)));
    }
}
