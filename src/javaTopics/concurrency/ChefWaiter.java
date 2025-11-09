package javaTopics.concurrency;

import javax.management.ObjectName;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Waiter extends Thread{
    final Object lock;
    Waiter(Object lock, String name){
        this.lock = lock;
        this.setName(name);
    }
    @Override
    public void run() {
        synchronized (lock){
            try{
                System.out.println(getName()+" waiter is waiting for food to be ready");
                lock.wait();
                System.out.println(getName()+" waiter got food, ready to be served");
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println(e);
            }
            System.out.println(getName()+" waiter served and died");
        }
    }
}

class Chef extends Thread{
    final Object lock;
    Chef(Object lock){
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock){
            try{
                System.out.println("Chef is Preparing food");
                Thread.sleep(3000);
                lock.notifyAll();
                System.out.println("Food is prepared, notifying waiter");
                Thread.sleep(2000);
                System.out.println("Chef resumed");
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
public class ChefWaiter {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Object j = new Object();
        Chef c = new Chef(j);
        Waiter [] w = new Waiter[2];
        for (int i = 0; i < 2; i++) {
            w[i] = new Waiter(j,String.valueOf(i+1));
            es.submit(w[i]);
        }
        Thread.sleep(1000);
        es.submit(c);
        es.shutdown();


    }
}
