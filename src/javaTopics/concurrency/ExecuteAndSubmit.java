package javaTopics.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class ExecuteAndSubmit {
    public static Runnable getTask(){
        return ()->{
            System.out.println("My task");
        };
    }
    public static Callable<String> getCallableTask(){
        return ()->{
            System.out.println("in callable returning string");
            return "harshit";
        };
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(getTask());
        Future<String> futurerun = (Future<String>) es.submit(getTask());
        Future<String> futurerun2 = (Future<String>) es.submit(getCallableTask());
        System.out.println(futurerun.get());
        System.out.println(futurerun2.get());
        es.shutdown();
    }
}
