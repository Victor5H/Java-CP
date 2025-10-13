package javaTopics.concurrency;

public class Main {
    public static void main(String[] args) {
//        not the best way to create thread
        Thread t = new CountingThread();
        t.start();
//        best way to create thread, since you can extend classes in counting run class
        Runnable r = new CountingRun();
        Thread tr1 = new Thread(r);
        Thread tr2 = new Thread(r);
        tr1.start();
        tr2.start();
//        difference between callable and runnable
        try {
            System.out.println(new CountingCall().call());
        }catch (Exception e){ System.out.println(e);}
    }
}
