package daily.TwentySix.eleventhJan;

import java.util.Arrays;
import java.util.Stack;

public class PSE {
    public static int [] pse(int [] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int [] ans = new int[n];
        for (int i =0; i <n ; i++) {
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()) ans[i]=-1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] n = {3,4,2,2,5,7};
        pse(n);
    }
}
