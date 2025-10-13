package javaTopics.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static Runnable run (int task){
        return ()->{
            try{
                System.out.println(task+" running");
                Thread.sleep(1000);
            }catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(task+" finished");
        };
    }

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(500);
        for (int i = 0; i< 1000; i++) {
            ex.submit(new Thread(run(i)));
        }
        ex.shutdown();
    }

}
