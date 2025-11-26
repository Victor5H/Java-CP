package javaTopics.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class CopyOnWriteListDemo {
    public static void main(String[] args) {
        List<Integer> cowl = new CopyOnWriteArrayList<>(Stream.iterate(1, x->x+1).limit(4).toList());
        cowl.forEach(e->{
            System.out.println(e);
            if(e==4){
                cowl.add(6);
                System.out.println("added 6");
            }
        });
        System.out.println(cowl);
        List<Integer> list = new ArrayList<>(Stream.iterate(1, x->x+1).limit(4).toList());
        list.forEach(e->{
            System.out.println(e);
            if(e==4){
                list.add(6);
                //will throw an exception
                System.out.println("added 6");
            }
        });
        System.out.println(list);


    }
}
