package linkedList;

import dsComponents.Node;

public class Main {
    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        public void printList(){
            Node temp = this.head;
            System.out.print("size:"+size+" ");
            while (temp!=null){
                if(temp == head)
                    System.out.print("head");
                if (temp==tail)
                    System.out.print("tail");
                System.out.print("["+temp.val+"]->");

                temp = temp.next;
            }
            System.out.println();

        }
        public void addLast(int val){
            Node n = new Node(val);
            if(size==0){
                head = n;
                tail = n;
                size++;
            }
            else {
                tail.next = n;
                tail = n;
                size++;
            }
        }
        public void addFirst(int val){
            Node n = new Node(val);
            if(size==0){
                head = n;
                tail=n;
                size++;
            }
            else {
                n.next = head;
                head = n;
                size++;
            }
        }
        public void removeFirst(){
            if(size==0) return;
            head = head.next;
            size--;
        }
        public void removeLast(){
            Node temp = head;
            while (temp.next!=tail){
                temp = temp.next;
            }
            temp.next=null;
            tail = temp;
            size--;
        }
        public int getFirst(){
            return head.val;
        }
        public int getLast(){
            return tail.val;
        }
        public Node getNodeAt(int i){
            if(i>=size) return null;
            int t = 0;
            Node temp = head;
            while (t<i){
                t++;
                temp = temp.next;
            }
            return temp;
        }
        public void insertAt(int val, int index){
            if(index>=size) return;
            if(index==0) {addFirst(val); return;}
            if(index==size-1) {addLast(val); return;}
            Node n = new Node(val);
            Node temp = head;
            int i =0;
            while (i<index-1){
                i++;
                temp = temp.next;
            }
            n.next = temp.next.next;
            temp.next = n;
            size++;
        }
        public void removeAt(int index){
            if(index>=size) return;
            if(index==0) {removeFirst(); return;}
            if(index==size-1) {removeLast(); return;}
            Node temp = head;
            int i =0;
            while (i<index-1){
                i++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
        public void reverse(){
            int l = 0;
            int r  = size-1;
            while (l<r){
                Node lval = getNodeAt(l++);
                Node rval = getNodeAt(r--);
                int temp = lval.val;
                lval.val = rval.val;
                rval.val = temp;
            }
        }
        public void reverseP(){
            Node curr = head, prev = null;
            while (curr!=null){
                Node next  = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }
        public int kFromLast(int k){
            Node slow = head, fast = head;
            while (k>=0){
                k--;
                fast = fast.next;
            }
            while (fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
            return slow.val;
        }
        public Node getMidNode(){
            Node slow = head, fast = head;
            while (fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        public int getMidValue(){
            return getMidNode().val;
        }
        public static LinkedList mergeSortedLists(LinkedList l1, LinkedList l2){
            LinkedList ll = new LinkedList();
            Node temp1 = l1.head;
            Node temp2= l2.head;
            while (temp1!=null && temp2!=null){
                if(temp1.val< temp2.val) {
                    ll.addLast(temp1.val);
                    temp1 = temp1.next;
                }
                else {
                    ll.addLast(temp2.val);
                    temp2 = temp2.next;
                }
            }
            while (temp1!=null){
                ll.addLast(temp1.val);
                temp1 = temp1.next;
            }
            while (temp2!=null){
                ll.addLast(temp2.val);
                temp2 = temp2.next;
            }
            return  ll;
        }
        public void mergeSort(){

        }
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        for (int i = 0; i <= 10; i++) {
            if (i%2==0) l1.addLast(i);
            else l2.addLast(i);
        }
        l1.printList();
        l2.printList();
        LinkedList.mergeSortedLists(l1,l2).printList();
    }
}
