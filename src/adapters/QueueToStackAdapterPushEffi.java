package adapters;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapterPushEffi {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;
    QueueToStackAdapterPushEffi(){
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }
    public int size(){
        return mainQ.size();
    }
    public void push(int val){
        mainQ.offer(val);
    }
    public int pop(){
        if (size()==0) return -1;
       while (size()!=1){
           helperQ.offer(mainQ.poll());
       }
       int ret = mainQ.poll();
       while (!helperQ.isEmpty()){
           mainQ.offer(helperQ.poll());
       }
       return ret;
    }

    public static void main(String[] args) {
        QueueToStackAdapterPushEffi stack = new QueueToStackAdapterPushEffi();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
