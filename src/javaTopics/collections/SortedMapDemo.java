package javaTopics.collections;

import java.util.SortedMap;
import java.util.TreeMap;


public class SortedMapDemo {
    public static void main(String[] args) {
        SortedMap<String,Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Harshit",4);
        sortedMap.put("Aditya",5);
        sortedMap.put("Yash",7);
        sortedMap.put("Ekansh",100);
        sortedMap.put("Chandana",60);
        System.out.println(sortedMap);


        SortedMap<ComparablePerson,Integer> personMap = new TreeMap<>();
        personMap.put(new ComparablePerson("Harshit",4),67);
        personMap.put(new ComparablePerson("Aditya",4),78);
        personMap.put(new ComparablePerson("Yash",5),45);
        personMap.put(new ComparablePerson("Ashish",5),34);
        System.out.println(personMap);

        SortedMap<Integer,String> map = new TreeMap<>();
        map.put(1,"eins");
        map.put(3,"drei");
        map.put(2,"drei");
        map.put(10,"zen");
        map.put(7,"seiben");
        map.put(5,"funf");
        System.out.println(map);
        System.out.println(map.headMap(5));
        System.out.println(map.tailMap(3));
        System.out.println(map.subMap(2,9));
        System.out.println("reversed");
        TreeMap<Integer,String> map2 = new TreeMap<>((a,b)-> b-a);
        map2.put(1,"eins");
        map2.put(3,"drei");
        map2.put(2,"drei");
        map2.put(10,"zen");
        map2.put(7,"seiben");
        map2.put(5,"funf");
        System.out.println(map2);
        System.out.println(map2.headMap(5));
        System.out.println(map2.tailMap(3));
        System.out.println(map2.subMap(9,2));

//        navigable map demo
        System.out.println(map2.lowerKey(3));
        System.out.println(map2.ceilingKey(8));

    }
}
