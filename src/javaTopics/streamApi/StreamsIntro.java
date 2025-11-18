package javaTopics.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsIntro {
    public static void main(String[] args) {
//        source, intermediate operations , terminal operation
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println("Number of even numbers in "+nums);
        System.out.println(nums.stream().filter(x->x%2==0).count());
//        here nums is source, filter is intermediate operation and count is terminal operation
//        Creating streams
//        1) form Lists
        Stream<Integer> i = nums.stream();
//        2) from arrays
        Integer [] arr  = new Integer[]{1,2,3,4,5,6};
        Stream<Integer> sr = Arrays.stream(arr);
//        3) Stream.of(T...a) direct method
        Stream<String> st = Stream.of("2","4","3","1");
//        4) Infinite Stream
        Stream<Integer> gen = Stream.generate(()->4).limit(5);
//        generate takes a supplier as param, and creates a stream
//        with infinite lenght of that element
//        limit() limits the size

    }
}
