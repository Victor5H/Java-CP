package javaTopics.concurrency.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ReadWriteLockUsingSemaphore {
    private final Semaphore wrtLock;
    private final ReentrantLock mutex;
    int countReaders;

    public ReadWriteLockUsingSemaphore() {
        wrtLock = new Semaphore(1);
        mutex = new ReentrantLock();
        countReaders=0;
    }

    public void readLock() throws InterruptedException {
        mutex.lock();
        countReaders++;
        if (countReaders == 1)
//            acquiring the lock once, since other readers dont need to
            wrtLock.acquire();
        mutex.unlock();

    }

    public void readUnlock() {
        mutex.lock();
        countReaders--;
        if (countReaders == 0)
            wrtLock.release();
        mutex.unlock();

    }

    public void writeLock() throws InterruptedException {
        wrtLock.acquire();
//        writer would not be able to acquire the lock until all readers
//        have left the CS
    }

    public void writeUnlock() {
        wrtLock.release();
    }

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLockUsingSemaphore rwLock = new ReadWriteLockUsingSemaphore();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable r = () -> {
            try {
                rwLock.readLock();
                System.out.println("Reading count");
                Thread.sleep(500);
                System.out.println("Read count");
                rwLock.readUnlock();

            } catch (Exception e) {
            }
        };
        Runnable w = () -> {
            try {
                rwLock.writeLock();
                System.out.println("Writing count");
                Thread.sleep(1000);
                System.out.println("Wrote count");
                rwLock.writeUnlock();

            } catch (Exception e) {
            }
        };

        for (int i = 0; i < 5; i++) {
            Thread.sleep(100);
            if (i == 2) {
                executorService.submit(w);
            } else executorService.submit(r);
        }
        executorService.shutdown();
    }


}
