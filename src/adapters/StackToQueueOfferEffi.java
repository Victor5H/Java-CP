package adapters;

import java.util.Stack;

public class StackToQueueOfferEffi {
    Stack<Integer> mainStack = new Stack<>();
    Stack <Integer> helper = new Stack<>();
    public int size(){
        return mainStack.size();
    }
    public int poll(){
        if (mainStack.isEmpty()) return -1;
        while (size()!=1){
            helper.push(mainStack.pop());
        }
        int ret = mainStack.pop();
        while (!helper.isEmpty()){
            mainStack.push(helper.pop());
        }
        return ret;
    }
    public void offer(int val){
       mainStack.push(val);
    }

    public static void main(String[] args) {
        StackToQueueOfferEffi queue = new StackToQueueOfferEffi();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
