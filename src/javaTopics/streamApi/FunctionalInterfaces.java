package javaTopics.streamApi;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
//    predicate is a functional interface
//    a boolean value function
    public static void main(String[] args) {
        Predicate<Integer> isEven = x-> x%2==0;
        System.out.println(isEven.test(7));
        Predicate<String> startWithA = str-> str.startsWith("a");
        Predicate<String> endsWithA = str-> str.endsWith("a");
        Predicate<String> aAndA = startWithA.and(endsWithA);
//        chaining predicates
        System.out.println(startWithA.test("harshit"));
        System.out.println(startWithA.test("abc"));
        System.out.println("\"anda\" starts and ends with a: "+ aAndA.test("anda"));
        System.out.println("\"and\" starts and ends with a: "+ aAndA.test("and"));

//        Funtion<T,R> this works for you, it accepts and return something
        Function<Integer,Double> square = a-> Math.pow(a,2);
        Function<Double,Integer> toInteger = a-> a.intValue();
//        above function can be chained with another function
        System.out.println("Square or 5 is: "+square.apply(5));
        System.out.println("Square or 5 is in int: "+square.andThen(toInteger).apply(5));
//        square and then toInteger
        System.out.println("Square or 5.5 is in int: "+square.compose(toInteger).apply(5.5));
//        compose is reverse of andThen

//        Consumer consume but does not return anything, can be used for printing
        Consumer<int[]> consume = x-> System.out.println(Arrays.toString(x));
        int [] arr = new int[]{1,4,21,34,1};
        consume.accept(arr);
        Consumer<List<Integer>> printList = x->{
            for(int n:x){
                System.out.print(n+" ");
            }
            System.out.println();
        };
        List<Integer> e = Arrays.asList(1,3,2,4,6,2,32);
        printList.accept(e);
//        Supplier, it returns something doesn't accept anything
        Supplier<List<Integer>> evenNums = ()->{
            List<Integer> ret = new ArrayList<>();
            for (int i = 2; i <= 10; i+=2) {
                ret.add(i);
            }
            return ret;
        };
        System.out.println("Got even numbers from supplier: "+evenNums.get());

//        example with all of them
//        supplier gets the data, predicate filters it, function transforms it, consumer prints it
        Supplier<List<Integer>> nums = ()->{
            List<Integer> ret = new ArrayList<>();
            Random r = new Random();
            for (int i = 1; i < 10; i++) {
                ret.add(r.nextInt(i*57));
            }
            return ret;
        };
        Predicate<Integer> isPrime = x->{
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if(x%i==0) return false;
            }
            return true;
        };
        Function<List<Integer>,List<Integer>> filter = (a)->{
            List<Integer> ret = new ArrayList<>();
            for(int n:a){
                if(isPrime.test(n)) ret.add(n);
            }
            return ret;
        };
        System.out.println("printing some prime numbers: ");
        printList.accept(filter.apply(nums.get()));

//        All of the above only take one thing as an argument
//        there are different Interfaces that takes 2 argument as an input
//        BiConsumer, BiFunction, BiPredicate
        BiPredicate<Integer,Integer> isSumEven = (x,y)-> (x+y)%2==0;
        System.out.println("is 6+7 even? "+isSumEven.test(6,7));

        BiConsumer<List<Integer>,List<Integer>> crisCrossPrint = (a,b)->{
            Iterator<Integer> f = a.iterator();
            Iterator<Integer> s = b.iterator();
            while (f.hasNext()&&s.hasNext()){
                System.out.print(f.next()+"\n"+s.next()+"\n");
            }
            while ((f.hasNext())){
                System.out.println(f.next());
            }
            while ((s.hasNext())){
                System.out.println(s.next());
            }
        };
        Supplier<List<Integer>> oddNums = ()->{
            List<Integer> ret = new ArrayList<>();
            for (int i = 1; i < 10; i+=2) {
                ret.add(i);
            }
            return ret;
        };
        crisCrossPrint.accept(evenNums.get(),oddNums.get());
        BiFunction<Integer,Integer,Integer> hcf = (a,b)->{
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        };
        System.out.println("HCF of 4,8: "+hcf.apply(40,160));

//        Lets say a function accepts and return the same type of data
        Function<Integer,Integer> doubleThat = x-> x*2;
//        to save the double declaration we can use UnaryOperator
//        which extends Function and accepts and return same type of data
        UnaryOperator<Integer> twiceThat = x-> x*2;
//        It works the same
        System.out.println("Double of 565: "+doubleThat.apply(565));
        System.out.println("Twice of 565: "+twiceThat.apply(565));
//        same for BiFunction, there is BinaryOperator, ex hcf of 2 nums
        BinaryOperator<Integer> gcd = (a,b)->{
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        };
        System.out.println("GCD of 345 and 23415: "+gcd.apply(345,23415));
    }
}
