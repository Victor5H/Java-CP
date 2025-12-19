package stackProblems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementToRight {
    public static int [] ngetr(int[] nums){
        int [] ret = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >=0 ; i--) {
            int curr = nums[i];
            if(stack.isEmpty()) {ret[i]=-1;}
            else {
                while (!stack.isEmpty()&&stack.peek()<curr){
                    stack.pop();
                }
                if(stack.isEmpty()){ret[i]=-1;}
                else ret[i] = stack.peek();
            }
            stack.push(curr);
        }
        return ret;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(ngetr(new int[]{1,2,34,65,3,2,34,45,6})));

    }
}
