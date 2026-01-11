package daily.TwentySix.eleventhJan;

import java.util.Arrays;
import java.util.Stack;

public class NGE {
    public static void nge(int [] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int [] ans = new int[n];
        for (int i = n-1; i >=0 ; i--) {
            while (!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()) ans[i]=-1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        int [] n = {3,4,2,2,5,7};
        nge(n);
    }
}
