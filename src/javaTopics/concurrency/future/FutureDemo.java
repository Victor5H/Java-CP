package javaTopics.concurrency.future;

import java.util.Random;
import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Callable<Integer> c = ()->{
            int i=0;
            try{
                System.out.println("Task started");
                Long r = new Random().nextInt(4)* 1000L;
                Thread.sleep(r);
                System.out.println("Task completed");
                i = 10 * new Random().nextInt(67);

            }catch (Exception e){}
            return i;
        };
        Future<Integer> f = service.submit(c);
        System.out.println("task submitted");
        System.out.println("task completed?: "+f.isDone());//non blocking call
        System.out.println(f.get());// a blocking call, until the result is processed
        System.out.println("task completed?: "+f.isDone());
        Callable<?> c1=()->{
            Integer i=34;
            try{
                System.out.println(Thread.currentThread().getName()+" is interrupted "+Thread.currentThread().interrupted());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" is interrupted "+Thread.currentThread().interrupted());
            }catch (InterruptedException e){
                System.out.println("Thread interrupted "+e);
            }
            return i;
        };
        Future<?> i=service.submit(c1);
        System.out.println("is task cancelled?: "+i.isCancelled());
//        i.cancel(true);
        System.out.println("is task cancelled?: "+i.isCancelled());
        System.out.println(i.get());
        service.shutdown();

    }
}
