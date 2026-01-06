package daily.TwentyFive.nineteenthDec;

import java.util.Stack;
//https://leetcode.com/problems/next-greater-element-ii/
public class NGE2 {
    public int[] nextGreaterElements(int[] nums) {
        int []ret = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            int curr = nums[i];
            while(!s.isEmpty() && s.peek()<=curr){
                s.pop();
            }
            s.push(curr);
        }
        for(int i=nums.length-1;i>=0;i--){

            int curr = nums[i];
            while(!s.isEmpty() && s.peek()<=curr){
                s.pop();
            }
            if(s.isEmpty()){ret[i]=-1;}
            else ret[i] = s.peek();
            s.push(curr);
        }
        return ret;

    }
//    preferred
    public int[] nextGreaterElements2(int[] nums) {
        int []ret = new int[nums.length];
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            int curr = nums[i%n];
            while(!s.isEmpty() && s.peek()<=curr){
                s.pop();
            }
            if(i<n){
                ret[i] = s.isEmpty()?-1:s.peek();
            }
            s.push(curr);
        }
        return ret;

    }
}
