package javaTopics.streamApi;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> nums = Stream.iterate(1,x->x+1).limit(40000).toList();
        Function<Integer,Long> factorial = x->{
            Long res = 1L;
            for (int i = 2; i <= x; i++) {
                res*=i;
            }
            return  res;
        };
        long st = System.currentTimeMillis();
        List<Long> facts = nums.stream().map(factorial).toList();
        long ed = System.currentTimeMillis();
        System.out.println(ed-st);
        st = System.currentTimeMillis();
        facts = nums.parallelStream().map(factorial).toList();
        ed = System.currentTimeMillis();
        System.out.println(ed-st);

//        Example of when parallel stream wont work
        List<Integer> to = List.of(1,2,3,4,5,6);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cuSum = to.stream().map(sum::addAndGet).toList();
        sum = new AtomicInteger(0);
        List<Integer> cuSumParallel = to.parallelStream().map(sum::addAndGet).toList();
        cuSumParallel = to.parallelStream().sequential().map(sum::addAndGet).toList();
        System.out.println("With stream: "+cuSum);
        System.out.println("With parallel stream: "+cuSumParallel);
    }
}
