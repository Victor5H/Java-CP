package javaTopics.streamApi;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStream {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,6,7};
//        primitive streams, deigned to work with primitive datatype instead of wrapper classes
        IntStream is = Arrays.stream(nums);
//        this will return stream of respective wrapper class
        is.boxed();
//        range(start, exclusive end)
        IntStream.range(1,5).forEach(System.out::println);
//        range(start, inclusive end
        IntStream.rangeClosed(1,5).forEach(System.out::println);

//        Creating a stream of rendom ints
        IntStream intStream = new Random().ints(5,0,10);
        System.out.println(intStream.boxed().toList());

//        Creating a stream of random doubles
        DoubleStream doubleStream = new Random().doubles(5,0,10);
        System.out.println(doubleStream.boxed().toList());

        IntStream seq = IntStream.rangeClosed(1,78);
        System.out.println(seq.sum());
        seq = IntStream.rangeClosed(0,-1);
        System.out.println(seq.max());
        seq = IntStream.rangeClosed(1,78);
        System.out.println(seq.average());
    }
}
