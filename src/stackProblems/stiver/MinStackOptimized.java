package stackProblems.stiver;

import java.util.Stack;

public class MinStackOptimized {
    Stack<Integer> stack = new Stack<>();
    int min  = Integer.MAX_VALUE;

    public void push(int ele){
        if(stack.isEmpty()){
            min = ele;
            stack.push(ele);
        }
        else{
            if(ele>=min){
                stack.push(ele);
            }
            else {
                stack.push(2*ele-min);
                min = ele;
            }
        }
    }
    public Integer pop(){
        if(!stack.isEmpty()){
            if(stack.peek()<min){
                int ret = min;
                min = 2*min - stack.pop();
                return ret;
            }
            else return stack.pop();
        }
        return null;
    }
    public Integer peek(){
        if(!stack.isEmpty()){
            if(stack.peek()<min){
                return min;
            }
            else return stack.peek();
        }
        return null;
    }
    public int getMin(){
        return min;
    }
}

