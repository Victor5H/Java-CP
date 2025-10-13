package javaTopics.concurrency;


class Shared1 {
    public synchronized void example() {
        System.out.println("Entering sleep " + Thread.currentThread().getName());
        try {
            System.out.println("thread sleeping " + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("Thread resumed " + Thread.currentThread().getName());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Thread finished " + Thread.currentThread().getName());

    }

}

public class DemoSleep {
    public static void main(String[] args) throws InterruptedException {
        Shared1 s = new Shared1();
        Thread t = new Thread(() -> s.example(), "th1");
        Thread t2 = new Thread(() -> s.example(), "th2");
        t.start();
        t2.start();
    }

}

