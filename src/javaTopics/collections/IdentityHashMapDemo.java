package javaTopics.collections;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        Map<String,Integer> idMap = new IdentityHashMap<>();
        Map<String,Integer> map = new HashMap<>();
        String s1 = new String("new");
        String s2 = new String("new");
//        since content of both strings are same hascode will be same
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
//        But since both are 2 different objects their identity hashcode will be different
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
         idMap.put(s1,4);
         idMap.put(s2,5);
         map.put(s1,4);
         map.put(s2,4);
        System.out.println(idMap);
        System.out.println(map);


    }
}
