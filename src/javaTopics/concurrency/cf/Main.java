package javaTopics.concurrency.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<String> f = CompletableFuture.supplyAsync(()->"Harshit");
        System.out.println(f.join());System.out.println(f.join());
    }
}
