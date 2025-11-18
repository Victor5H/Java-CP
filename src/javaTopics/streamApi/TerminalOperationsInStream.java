package javaTopics.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationsInStream {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,2,4,6,2);
        List<Integer> list  = List.of(1,2,3,54,6,1);

//        1) Collect: collects into given collection using Collectors interface
        list.stream().skip(3).collect(Collectors.toList());
        list.stream().skip(3).toList();

//        2) forEach: it accepts a consumer,
//        and applies operation over each element in collection
        list.stream().forEach(x->System.out.println(x));
        list.stream().forEach(System.out::println);
        list.forEach(System.out::println);

//        3) reduce: combines elements to a single result
//        accepts BinaryOperator
//        returns Optional<>
        list.stream().reduce((x,y)->x+y);
        Optional<Integer> i = list.stream().reduce(Integer::sum);
        i.get();

//        4) count: count the number of items in the stream
        list.stream().count();
        list.stream().filter(x->x>2).count();

//        5) anyMatch, allMatch, noneMatch: *short circuit methods
        boolean isAnyEven = nums.stream().anyMatch(x->x%2==0);
        boolean isAllPositive = nums.stream().allMatch(x->x>=0);
        boolean isLessThan100 = nums.stream().noneMatch(x->x>100);
        System.out.printf("%b %b %b\n",isAnyEven,isAllPositive,isLessThan100);

//        6) findFirst, findAny *short circuit methods
//        returns optional
//        returns first element, return any element
        nums.stream().findAny().get();
        nums.stream().findFirst().get();

//        Examples
        List<String> names = List.of("Bob","John","Charlie","Sam");
//        name with length gt 3
        System.out.println("name with length gt 3: ");
        System.out.println(names.stream().filter(x->x.length()>3).toList());

//        square and sort list of nums
        System.out.println("square and sort list of nums: ");
        System.out.println(nums.stream().map(x->Math.pow(x,2)).sorted().toList());

//        sum of nums list
        System.out.println(nums.stream().reduce(Integer::sum).get());

//        counting chars
        String h = "hello World";
        long c= Arrays.stream(h.split("")).filter(x-> x.equals("l")).count();
        System.out.printf("Number of l in %s are %d",h,c);
        h.chars().filter(x->x=='l').count();

//

    }
}
