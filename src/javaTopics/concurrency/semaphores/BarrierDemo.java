package javaTopics.concurrency.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Supplier;

public class BarrierDemo {
    private final Semaphore semaphore;
    private final ReentrantLock mutex;
    int parties;
    int barrierCount;
    BarrierDemo(int count){
        semaphore = new Semaphore(0);
//        should be zero
        parties = this.barrierCount = count;
        mutex = new ReentrantLock();
//        for accessing barrier code
    }
    public void await() throws InterruptedException {

        mutex.lock();
//        System.out.println(semaphore.availablePermits());
        barrierCount--;
        if (barrierCount==0){
            barrierCount = parties;
//            restoring count
            semaphore.release(parties-1);
//            since this is the last thread,
//            other threads r waiting for semaphore to be
//            incremented, this will allow everyone else to go
//            since this is last it does not have to wait for semaphore
            mutex.unlock();

        }
        else {
            mutex.unlock();// should be first. if not all thread will wait for semaphore
//            and this will be deadlock
            semaphore.acquire();
//            System.out.println(semaphore.availablePermits());

        }
    }
    public static void main(String[] args) {
        Supplier<String> tName = ()-> Thread.currentThread().getName();
        BarrierDemo barrierDemo = new BarrierDemo(4);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executorService.submit(()->{
                try {
                    System.out.println(tName.get()+" In 1st section");
                    Thread.sleep((long) (Math.random()*2000));
                    System.out.println(tName.get()+" completed 1st section");

                    barrierDemo.await();

                    System.out.println(tName.get()+" In 2nd section");
                    Thread.sleep((long) (Math.random()*2000));
                    System.out.println(tName.get()+" completed 2nd section");

                    barrierDemo.await();

                    System.out.println(tName.get()+" In 3rd section");
                    Thread.sleep((long) (Math.random()*2000));
                    System.out.println(tName.get()+" completed 3rd section");
                    barrierDemo.await();

                }catch (Exception e){
                    System.out.println(tName.get()+ " Interrupted");
                }
            });
        }
        executorService.shutdown();
    }
}
