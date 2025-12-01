package javaTopics.collections;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Producer implements Runnable{
    BlockingQueue<Integer> q;
    int value;
    Producer(BlockingQueue<Integer> bq){
        q = bq;
        value=0;
    }
    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Producer produced "+value);
                q.put(value++);
                Thread.sleep(1000);
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println(e);
            }
        }

    }
}

class Consumer implements Runnable{
    BlockingQueue<Integer> q;

    Consumer(BlockingQueue<Integer> bq){
        q = bq;
    }
    @Override
    public void run() {
        while (true){
            try {
                Integer got = q.poll();
                System.out.println("Consumer consumed "+got);
                Thread.sleep(3000);
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println(e);
            }
        }

    }
}
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(1);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Thread p = new Thread(new Producer(bq));
        Thread c = new Thread(new Consumer(bq));
        executorService.submit(p);
        try {
            Thread.sleep(100);
        }
        catch (Exception e){}
        executorService.submit(c);
        executorService.shutdown();
    }
}
