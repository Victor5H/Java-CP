package javaTopics.concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTryLockDemo {
    ReentrantLock lock ;
    ReentrantLockTryLockDemo(){
        lock = new ReentrantLock();
    }
    public void longTask(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" acquired lock");
            System.out.println(Thread.currentThread().getName()+" is waiting ");
            Thread.sleep(2100);
            System.out.println(Thread.currentThread().getName()+" finished waiting ");
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName()+" was interrupted ");
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" released the lock");
            lock.unlock();
        }
    }
    public void tryLockTask(){
        try {
//            will wait for 2 second to acquire the lock
            if(lock.tryLock(2, TimeUnit.SECONDS)){
                try {
                    System.out.println(Thread.currentThread().getName()+" acquired lock");
                }finally {
                    System.out.println(Thread.currentThread().getName()+" released the lock");
                    lock.unlock();
                }
            }
            else System.out.println(Thread.currentThread().getName()+" was not able to acquire the lock");
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName()+" was interrupted ");
        }
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        ReentrantLockTryLockDemo demo = new ReentrantLockTryLockDemo();
        service.submit(demo::longTask);
        try {
            Thread.sleep(100);
        }catch (Exception e){}
        service.submit(demo::tryLockTask);
        try {
            Thread.sleep(4000);
        }catch (Exception e){}
        service.shutdown();
    }
}
