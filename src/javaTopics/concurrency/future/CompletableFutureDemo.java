package javaTopics.concurrency.future;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        Callable<String> c = ()->{
            try{
                Thread.sleep(2000);
            }catch (Exception e){}
            return "Harshit";
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        CompletableFuture<String> cf = CompletableFuture.
    }
}
