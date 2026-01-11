package daily.TwentySix.eleventhJan;

import java.util.Stack;

public class NSE {
    public static int [] nse(int [] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int [] ans = new int[n];
        for (int i = n-1; i >=0 ; i--) {
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()) ans[i]=n;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] n = {3,4,2,2,5,7};
        nse(n);
    }
}
