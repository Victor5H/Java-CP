package javaTopics.concurrency;

class Shared {
    public synchronized void example() {
        System.out.println("Entering wait " + Thread.currentThread().getName());
        try {
            System.out.println("thread waiting " + Thread.currentThread().getName());
            wait();
            System.out.println("Thread resumed " + Thread.currentThread().getName());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Thread finished " + Thread.currentThread().getName());

    }

    public synchronized void notifyOne() {

        System.out.println("Notifying one thread");
        notify();
    }

}

public class DemoWait {
    public static void main(String[] args) throws InterruptedException {
        Shared s = new Shared();
        Thread t = new Thread(() -> s.example(), "th1");
        Thread t2 = new Thread(() -> s.example(), "th2");
        t.start();
        t2.start();
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            s.notifyOne();
        }, "th3");
        t3.start();
    }

}
