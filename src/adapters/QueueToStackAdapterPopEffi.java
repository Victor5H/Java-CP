package adapters;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapterPopEffi {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;
    QueueToStackAdapterPopEffi(){
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }
    public int size(){
        return mainQ.size();
    }
    public void push(int val){
        if(mainQ.isEmpty())
            mainQ.offer(val);

        else {
            while (!mainQ.isEmpty()) {
                helperQ.offer(mainQ.poll());
            }
            mainQ.offer(val);
            while (!helperQ.isEmpty()){
                mainQ.offer(helperQ.poll());
            }
        }
    }
    public int pop(){
        if (size()==0){
            return -1;
        }
        return mainQ.poll();
    }
    public int peak(){
        if (size()==0){
            return -1;
        }
        return mainQ.peek();
    }

    public static void main(String[] args) {
        QueueToStackAdapterPopEffi stack = new QueueToStackAdapterPopEffi();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
