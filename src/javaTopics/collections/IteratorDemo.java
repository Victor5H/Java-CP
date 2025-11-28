package javaTopics.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>(Stream.iterate(1,x->x+1).limit(10).toList());
        System.out.println(list);
        Iterator<?> i = list.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        Iterator<Integer> i1 = list.iterator();
        while (i1.hasNext()){
            if(i1.next()%2==0) i1.remove();
        }
        System.out.println(list);

        Iterator<Integer> i2 = list.iterator();
        i2.forEachRemaining(System.out::println);

    }
}
