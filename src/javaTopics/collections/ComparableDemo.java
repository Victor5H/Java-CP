package javaTopics.collections;

import java.util.ArrayList;
import java.util.List;


public class ComparableDemo {
    public static void main(String[] args) {
        List<ComparablePerson> list = new ArrayList<>();
        list.add(new ComparablePerson("Harshit",4));
        list.add(new ComparablePerson("Aditya",4));
        list.add(new ComparablePerson("Yash",5));
        list.add(new ComparablePerson("Ashish",5));
        System.out.println(list);
        list.sort(null);
        System.out.println(list);
    }

}
