package stackProblems.stiver;

import java.util.Stack;

class Pair{
    int ele;
    int min;

    public Pair(int ele, int min) {
        this.ele = ele;
        this.min = min;
    }
}
public class MinStack {
    Stack<Pair> stack = new Stack<>();
    public void push(int push){
        if(stack.isEmpty()){
            stack.push(new Pair(push,push));
        }
        else {
            int min = getMin();
            stack.push(new Pair(push, Math.min(push, min)));
        }
    }
    public Pair peek(){
        return stack.peek();
    }
    public int getMin(){
        return peek().min;
    }
    public int pop(){
        return stack.pop().ele;
    }
    public int top(){
        return peek().ele;
    }

    public static void main(String[] args) {
        MinStack stack1 = new MinStack();
        stack1.push(12);
        stack1.push(15);
        stack1.push(10);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.top());
        System.out.println(stack1.getMin());
    }
}
