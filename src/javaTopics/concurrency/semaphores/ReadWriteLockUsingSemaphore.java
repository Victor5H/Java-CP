package javaTopics.concurrency.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadWriteLockUsingSemaphore {
    private final Semaphore semaphore;
    //    private final ReentrantLock mutex;
    int countReaders;

    public ReadWriteLockUsingSemaphore(int readers) {
        semaphore = new Semaphore(readers);
        countReaders = readers;
    }

    public void readLock() throws InterruptedException {
        semaphore.acquire();
    }

    public void readUnlock() throws InterruptedException {
        semaphore.release();
    }

    public void writeLock() throws InterruptedException {
        semaphore.acquire(countReaders);
    }

    public void writeUnlock() throws InterruptedException {
//        mutex.lock();
        semaphore.release(countReaders);
//        mutex.unlock();
    }

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();
        ReadWriteLockUsingSemaphore rwLock = new ReadWriteLockUsingSemaphore(4);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable r = ()->{
            try {
                rwLock.readLock();
                System.out.println(counter.get());
                rwLock.readUnlock();

            } catch (Exception e) {
            }
        };
        Runnable w = ()->{
            try {
                rwLock.writeLock();
                counter.set(5);
                rwLock.readUnlock();

            } catch (Exception e) {
            }
        };

        for (int i = 0; i < 5; i++) {
            if(i==2){
                executorService.submit(w);
            }
            else executorService.submit(r);
        }
    }

}
