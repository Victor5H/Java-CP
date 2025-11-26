package javaTopics.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    private int capacity;
//    to compare later
    LRUCacheUsingLinkedHashMap(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

//    this methods runs every time we put or putAll
//    if this method returns true, it will remove the eldest (LRU) entry
//    we have to remove is size of our cache exceeds capacity
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>capacity;

    }

    public static void main(String[] args)
    {
        LRUCacheUsingLinkedHashMap<String,Integer> cache = new LRUCacheUsingLinkedHashMap<>(3);
        cache.put("Stranger Things S5",234);
        cache.put("MindHunters S3",4234);
        cache.put("Wednesday S2",23432);
//        insertion order is maintained
        System.out.println(cache);
        System.out.println(cache.put("Stranger Things S5",1234));
//        since value of st s5 is updated it will move to end of list.
        System.out.println(cache);
        cache.put("Squid Game S4",23498);
//        after adding squid game, LRU will be removed, ie mind hunters
        System.out.println(cache);
    }
}
