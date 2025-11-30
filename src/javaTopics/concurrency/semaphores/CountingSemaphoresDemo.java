package javaTopics.concurrency.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CountingSemaphoresDemo {
    public static Semaphore s = new Semaphore(3);
    public static void cs(){
        try {
            System.out.println(Thread.currentThread().getName()+" attempting to access CS");
            s.acquire();
            System.out.println(Thread.currentThread().getName()+" Accessing CS");
            Thread.sleep(1500);
        }catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" Out of CS");
            s.release();
        }
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(CountingSemaphoresDemo::cs);
        service.submit(CountingSemaphoresDemo::cs);
        service.submit(CountingSemaphoresDemo::cs);
        service.submit(CountingSemaphoresDemo::cs);
        try {
//            Thread.sleep(5000);
            service.shutdown();
        }catch (Exception e){}

    }
}
