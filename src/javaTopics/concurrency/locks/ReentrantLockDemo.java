package javaTopics.concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    Lock rLock;
    int count;
    ReentrantLockDemo(){
        rLock = new ReentrantLock();
        count=0;
    }
    public void increment(){
        rLock.lock();
        try {
            System.out.println("Lock Acquired by "+Thread.currentThread().getName());
            count++;
            System.out.println("Counter inc to "+count);
        }
        finally {
            System.out.println("Lock released by "+Thread.currentThread().getName());
            rLock.unlock();
//            in finally to make sure it is called to release lock

        }
    }
    public int getCount() {return count;}
    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.execute(reentrantLockDemo::increment);
        }
        try {
            Thread.sleep(5000);
            service.shutdown();
        }
        catch (Exception e){}
        System.out.println(reentrantLockDemo.getCount());
    }
}
