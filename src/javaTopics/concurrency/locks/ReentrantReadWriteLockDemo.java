package javaTopics.concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    ReentrantReadWriteLock rwLock;
    int counter;
    ReentrantReadWriteLockDemo(){
        rwLock = new ReentrantReadWriteLock();
        counter=0;
    }
    public void simulateWork(){
        try {
            Thread.sleep(1000);
        }catch (Exception ignore){}
    }
    public void readCounter(){
        try {
            rwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+" acquired read lock");
            System.out.println("Value of counter "+counter);
            simulateWork();
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" released read lock");
            rwLock.readLock().unlock();
        }
    }

    public void writeCounter(int val){
        try {
            rwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+" acquired write lock");
            counter=val;
            simulateWork();
            System.out.println("Value of counter "+counter);
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" released write lock");
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo rwDemo = new ReentrantReadWriteLockDemo();
        Runnable r = rwDemo::readCounter;
        Runnable w = ()->{
          rwDemo.writeCounter(60);
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            if(i==1) executorService.submit(w);
            else executorService.submit(r);
        }
        try {
            Thread.sleep(5000);
        }
        catch (Exception e){}
        executorService.shutdown();

    }
}
