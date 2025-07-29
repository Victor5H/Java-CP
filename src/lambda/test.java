package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Thread.sleep;

public class test {
    public static void printAryWithFilter(FilterInterface filterInterface,List<Integer> list) {
        for (int j : list) {
            if (filterInterface.test(j)) {
                System.out.print(j+" ");
            }
        }
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 2, 7, 2, 1, 15, 1));
//        only print values greater than 2
        printAryWithFilter((val) -> {return val > 2;}, list);
        System.out.println();
//        print evens only
        FilterInterface evenFilterLambda = val -> val%2==0;
        FilterInterface complexLambda = val -> {if(val>2) return true;else if (val<7) return true; else  return false;};
        printAryWithFilter(evenFilterLambda, list);
        System.out.println();
        printAryWithFilter(complexLambda, list);
        System.out.println();
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
//        out implementation of comparator
        Collections.sort(list,(Integer a,Integer b)-> b-a);
        System.out.println(list);
        Thread t1 = new Thread(()->{
            for (int i = 0; i <= 10; i++) {
                System.out.println(i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        System.out.println("main is here");
//        initial syntax
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return 0;
            }
        });
//        reduction
        Collections.sort(list, (Integer a, Integer b)->{return  a-b;});
//        removal of return stmt and brackets, if one liner, else both are needed
        Collections.sort(list,(Integer a, Integer b)-> a-b);
// not necessary to give type of parameters, compiler will infer the type: Collections.sort(list,(a,b)-> b-a);
        Collections.sort(list,( a, b)-> b-a);
        int num = 700;
        FilterInterface filterGreater = a->{
//            num = 500; this stmt is invalid, the value to local varibale cannot be chanegd inside a lambda
//            and the local variable would prefferabley declared final, cause of value capture
            if(a>num) return true;
            else return false;
        };
    }
}
