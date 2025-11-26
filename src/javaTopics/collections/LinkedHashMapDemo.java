package javaTopics.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> linked = new LinkedHashMap<>();
        Map<String, Integer> hash = new HashMap<>();
        hash.put("Apple",5);
        hash.put("Olive",7);
        hash.put("Banana",6);
//        no order
        for (Map.Entry<String,Integer> e: hash.entrySet()){
            System.out.println(e.getKey()+" : "+e.getValue());
        }
        linked.put("Apple",5);
        linked.put("Olive",7);
        linked.put("Banana",6);
//         order of insertion is maintained
        for (Map.Entry<String,Integer> e: linked.entrySet()){
            System.out.println(e.getKey()+" : "+e.getValue());
        }
    }
}
