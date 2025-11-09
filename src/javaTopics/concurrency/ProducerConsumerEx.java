package javaTopics.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProducerConsumer {
    int size;
    Queue<Integer> q;
    ProducerConsumer( int size) {
        this.q = new LinkedList<>();
        this.size = size;
    }
    public void consume(int num){
        while (true){
            try {
                synchronized (this) {
                    while (q.isEmpty()) {
                        System.out.println("Consumer is waiting for q tp be filled");
                        wait();
                    }
                    int got = q.poll();
                    System.out.println(num+" Consumer got "+got);
                    notifyAll();
                }
                Thread.sleep(5000);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void produce(){
        int value=0;
        while (true){
            try {
                synchronized (this) {
                    while (size == q.size()) {
                        System.out.println("Producer is waiting for Q to be empty");
                        wait();

                    }
                    System.out.println("Producer produced "+value);
                    q.offer(value++);
                    notifyAll();
                }
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

public class ProducerConsumerEx {
    Queue<Integer> q;
    int size;
    public static void consume(){

    }
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Queue<Integer> q = new LinkedList<>();
        int size=5;
        ProducerConsumer pc = new ProducerConsumer(size);
        es.submit(pc::produce);
        es.submit(()->pc.consume(1));
        es.submit(()->pc.consume(2));

    }

}
