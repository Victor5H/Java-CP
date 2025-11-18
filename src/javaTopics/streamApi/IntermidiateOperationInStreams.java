package javaTopics.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class IntermidiateOperationInStreams {
    public static void main(String[] args) {
//        1) Filter: applies a predicate over each eleemnt of a collection
//        adds to the result if true
//        they are lazy, will not invoke until followed by some terminal operation
        List<String> names = Arrays.asList("Harshit","Yash","Shubham","Ekansh");
        names.stream().filter(x-> x.endsWith("h"));

//        2) Map: it takes funciton as s param, applies it over each element
//        adds it to result
        names.stream().map(x->x.toUpperCase());
        names.stream().map(String::toUpperCase);// method reference

//        3) sorted: Sorts the collection in natural order, or according to comparator passed
        names.stream().sorted();
        names.stream().sorted((a,b)-> b.length()-a.length());// sorting by length of string

//        4) Distinct: removes duplicates
        names.stream().filter(x->x.startsWith("a")).distinct();

//        5)limit: controls the size of output stream
        Stream.iterate(1,x->x+1).limit(20);

//        6) skip(n): skips first n elements from collection
        Stream.iterate(1,x->x+1).limit(20).skip(10);

//       7) peek(): performs action on each element and it is consumed
//        accepts a consumer
        Stream.iterate(1,x->x+1).limit(5).peek(System.out::println).count();

//        8) flatMap(): processes stream on collections of collections
//        flattens the structure
        List<List<String>> fruits = List.of(
                List.of("Apple","Banana"),
                List.of("Kiwi","Orange"),
                List.of("Mango","Grapes")
        );
        System.out.println(fruits.stream().flatMap(x->x.stream()).map(String::toUpperCase));

        List<String> sentences = List.of("Hello World","I love Java","Backend");
        System.out.println(sentences.stream()
                .flatMap(x->Arrays.stream(x.split(" ")))
                .map(String::toUpperCase).toList());

    }
}
