package javaTopics.concurrency;

import javax.management.ObjectName;

class Waiter extends Thread{
    final Object lock;
    Waiter(Object lock){
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock){
            try{
                System.out.println("Waiter is waiting for food to be ready");
                lock.wait();
                System.out.println("Food is ready to be served");
            }catch (Exception e){
                System.out.println(e);
            }
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
                System.out.println("Food is prepared, notifying waiter");
                lock.notifyAll();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
public class ChefWaiter {
    public static void main(String[] args) {
        Object j = new Object();
        Chef c = new Chef(j);
        Waiter w = new Waiter(j);

        w.start();

        c.start();

    }
}
