package javaTopics.streamApi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//        6) calculating avg
        Double avg = nums.stream().collect(Collectors.averagingInt(x->x));

//        7)counting elements
        Long count = nums.stream().collect(Collectors.counting());

//        8) grouping elements, based on some criteria
         Map<Integer,List<String>> map = names.stream().collect(Collectors.groupingBy(x-> x.length()));
//         groups string form lenght and returns map of lenght and list of same lenght string
         Map<Integer,String> map2 = names.stream().
                collect(Collectors.groupingBy(x-> x.length(),Collectors.joining(",")));
//         another param, downstream collector, it is a function that will be applied on each element of group
//        this return strings grouped by lenght and combine all strings of a group by ','
         TreeMap<Integer,String> map3 = names.stream().
                 collect(Collectors.groupingBy(x-> x.length(),TreeMap::new,Collectors.joining(",")));
//         another param is specific type of Map, like treemap and linked hashmap..
//        this returns a tree map of string of same length grouped in one, joined by ','
        System.out.println(map);
        System.out.println(map2);
        System.out.println(map3);

//        9) partitioning elements: partition element based on predicate, true in one, false in another
        Map<Boolean,List<String>> parti =names.stream().collect(Collectors.partitioningBy(x->x.length()<5));
        System.out.println(parti);

//        collecting names by length
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length)));

//        counting word occurrences
        String word = "hello world hello word java";
        System.out.println(Arrays.stream(word.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));

//        partinioning even and odd nums
        List<Integer> demo = Stream.iterate(1,x->x+1).limit(15).toList();
        System.out.println(demo.stream().collect(Collectors.partitioningBy(x->x%2==0)));

//        summing values in a map
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Apple",20);
        prices.put("MAngo",523);
        System.out.println(prices.values().stream().collect(Collectors.summingInt(c->c)));
        System.out.println(prices.values().stream().reduce(Integer::sum));
        System.out.println(prices.values().stream().mapToInt(Integer::intValue).sum());

//        Creating map of words with lenght of respective word
        List<String> fruits = Arrays.asList("Apple","Mango","Pear","Apple");
        System.out.println(fruits.stream().distinct().collect(Collectors.toMap(String::toUpperCase,String::length)));
//        when streams need to be converted to straight forward maps,
//        toMAp(f1,f2), f1 function applied on keys, f2 function applied on values

//        count occurences of word in list
        List<String> h = List.of("apple","apple","bonana","hehe boi","hehe boi");
        System.out.println(h.stream().collect(Collectors.groupingBy(x->x,Collectors.counting())));
//        System.out.println(h.stream().collect(Collectors.toMap(x->x,))

//        i like java to java like i
        String il = "I like Java";
        System.out.println(Arrays.stream(il.split(" ")).collect(Collectors.collectingAndThen(Collectors.toList(),x->{
            Collections.reverse(x);
            return x.stream();
        })).collect(Collectors.joining(" ")));

//        14.How do you generate an infinite stream of random numbers
//        Random r = new Random(4);
//        System.out.println(Stream.iterate(r.nextInt(),x->{
//            Random r = new Random();
//            return r.nextInt(x*786);
//        }).limit(5).toList());

    }
}
