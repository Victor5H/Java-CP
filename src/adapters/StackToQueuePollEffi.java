package adapters;

import java.util.Stack;

public class StackToQueuePollEffi {
    Stack<Integer> mainStack = new Stack<>();
    Stack <Integer> helper = new Stack<>();
    public int size(){
        return mainStack.size();
    }
    public int poll(){
        if(size()==0) return -1;
        return mainStack.pop();
    }
    public void offer(int val){
        while (!mainStack.isEmpty()){
            helper.push(mainStack.pop());
        }
        mainStack.push(val);
        while (!helper.isEmpty()){
            mainStack.push(helper.pop());
        }
    }

    public static void main(String[] args) {
        StackToQueuePollEffi queue = new StackToQueuePollEffi();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
