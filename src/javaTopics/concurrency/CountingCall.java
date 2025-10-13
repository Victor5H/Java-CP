package javaTopics.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CountingCall implements Callable<List<Integer>> {
    @Override
    public List<Integer> call() throws Exception {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            li.add(i);
        }
        return li;
    }
}
