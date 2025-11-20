package javaTopics.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hehe boi");
        list.add(56);
        list.add(5.24);

        String st =(String) list.get(0);
//        above code is not type safe, list is returning type object, and
//        we need to type cast everytime
//        but that's not possible to know which type of data will be in the above list
//        to tackle this, Generics was introduced
        List<String> strs = new ArrayList<>();
        strs.add("kdj");
//        strs.add(67); wont compile
        Box<Integer> bi = new Box<>();
//        it will only accept integer
        bi.setValue(67);
        Box<String> bs = new Box<>();
//       it will only accept string
        bs.setValue("rtr");
        Pair<String, Integer> pair = new Pair<>("sd",23);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
        BoundedBox<Double> bd = new BoundedBox<>();
        BoundedBox<Integer> br = new BoundedBox<>();
//        BoundedBox<String>
//        Error:
//        Type parameter 'java.lang.String' is not within its bound; should extend 'java.lang.Number

        List<? super Integer> l = new ArrayList<>();
        l.add(12);
//        l.add(1.2);

    }
}
