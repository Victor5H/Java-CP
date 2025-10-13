package javaTopics.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorService {
    public static Runnable getCron() {
        return () -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(500);
                    System.out.println(i);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        };
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println("Run Every 2 sec"),
                0,2, TimeUnit.SECONDS);

    }
}
