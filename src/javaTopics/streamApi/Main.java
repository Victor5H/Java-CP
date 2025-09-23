package javaTopics.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8);
        nums.forEach(n->System.out.print(n+" "));
        nums.stream().map(n-> n*2).forEach(System.out::print);
        System.out.println();
        System.out.println(nums.stream().count());
        System.out.println(nums.stream().filter(n-> n%2==0).collect(Collectors.toUnmodifiableList()));
        System.out.println(nums.stream().sorted((integer, t1) -> t1-integer).collect(Collectors.toUnmodifiableList()));
        String st = "I like Java";
        List<String> li = Arrays.asList(st.split("\\s+"));
        Collections.reverse(li);
        //Collections.shuffle(li);
        System.out.println(li);
        // sum of square of even numbers
        sum_of_square_of_even_numbers();

    }

    public static void  sum_of_square_of_even_numbers() {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(nums.stream().
                filter(n-> n%2==0).
                map(n->n*n).
                reduce((a,b)->a+b).get());
        //or
        int sum = nums.stream().filter(n->n%2==0).mapToInt(n->n*n).sum();

    }
    public static void longest_word_in_a_list(){
        List<String> li = Arrays.asList("Java","Streams","API");
        //li.stream().reduce());
    }
    public static void upper_case_starting_vowel(){
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi");
//        words.stream().map();
    }
}