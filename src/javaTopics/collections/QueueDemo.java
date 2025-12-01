package javaTopics.collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.offer(2));;
        System.out.println(queue.add(4));
        System.out.println(queue);
        System.out.println(queue.remove());
        queue.poll();
//        System.out.println(queue.poll());
//        System.out.println(queue.remove());

        Queue<Integer> fixedQueue = new ArrayBlockingQueue<>(2);
        System.out.println(fixedQueue.add(4));
        System.out.println(fixedQueue.add(5));
        System.out.println(fixedQueue.offer(6));
    }
}
