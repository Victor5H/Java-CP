package daily.TwentySix.twentyTwo;

import java.util.HashMap;
//https://leetcode.com/problems/lru-cache/
public class LRUCache {
    private HashMap<Integer, Node> map=null;
    int size=0;
    int capacity=0;
    Node head=null;
    Node tail = null;
    public void delete(Node del){
        Node p = del.prev;
        Node n = del.next;
        p.next = n;
        n.prev = p;
    }
    public void insertAfterHead(Node ins){
        Node n = head.next;
        head.next = ins;
        ins.prev = head;
        ins.next = n;
        n.prev = ins;
    }
    class Node{
        Node next;
        Node prev;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node g =map.get(key);
        if(g==null) return -1;
        delete(g);
        insertAfterHead(g);
        return g.value;
    }

    public void put(int key, int value) {
        if(capacity==0) return;
        Node got =map.get(key);
        if(got ==null){
            //insert new
            Node ins  = new Node(key,value);
            if(size==capacity){
                //delete
                Node del = tail.prev;
                map.remove(del.key);
                delete(del);
            }
            else{
                size++;
            }
            insertAfterHead(ins);
            map.put(key,ins);
        }
        else{
            get(key);
            //to bring it to front
            got.value = value;
        }
    }
}
