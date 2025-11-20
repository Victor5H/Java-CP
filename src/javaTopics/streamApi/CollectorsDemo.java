package javaTopics.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
//        Collectors is a utility class
//        provides a set of methods to create common collectors
//        1) Collectors.toList()
        List<String> names = Arrays.asList("Harshit","Yash","Shubham","Ekansh");
        List<String>cap = names.stream().map(String::toUpperCase).collect(Collectors.toList());

//        2) Collectors.toSet()
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,2,4,6,2);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
       set = new HashSet<>(nums);

//        3) collecting to a specific collection, Collectors.toCollection() takes a supplier
        LinkedList<String> ll = names.stream().collect(Collectors.toCollection(LinkedList::new));
        ll = new LinkedList<>(names);

//        4) joining strings, Collectors.joining, concatenates the string in stream
//        into a single string, with a separator specified
        String concatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(concatedNames);

//        5) summarizing data: generates statistical summary(count, sum, avg, min, max)


    }
}
