package linkedList;

import dsComponents.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
//        l1.addLast(2);
//        l1.addLast(4);
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);
        l1.printList();
        l1.kReverse(9);
        l1.printList();
        l1.displayReverse();


    }


    public static class LinkedList {
        Node head;
        Node tail;
        int size;
        public void kReverse(int k){
            if(size<k) return;
            int n = 0;
            LinkedList prev = new LinkedList();
            LinkedList curr = new LinkedList();
            int ex = size/k;
            while (ex>0){
                n=0;
                for (int i = 0; i < k; i++) {
                    int val = getFirst();
                    removeFirst();
                    curr.addFirst(val);
                    n++;
                }
                if(prev.head==null)
                    prev = curr;

                else {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
                curr = new LinkedList();
                ex--;
            }
            while (size!=0){

                int val = getFirst();
                removeFirst();
                prev.addLast(val);
            }
            size = prev.size;
            head = prev.head;
            tail = prev.tail;
        }
        public void displayReverse(){
            trav(head);
        }
        private void trav(Node n){
            if (n == null) return;
            trav(n.next);
            System.out.println(n);
        }
        public static Node getMidNode(Node head, Node tail) {
            Node slow = head, fast = head;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public static LinkedList mergeSort(Node head, Node tail) {
            if (head == tail) {
                LinkedList ll = new LinkedList();
                ll.addLast(head.val);
                return ll;
            }
            Node mid = LinkedList.getMidNode(head, tail);
            LinkedList first = mergeSort(head, mid);
            LinkedList second = mergeSort(mid.next, tail);
            return mergeSortedLists(first, second);

        }

        public static LinkedList mergeSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList ll = new LinkedList();
            Node temp1 = l1.head;
            Node temp2 = l2.head;
            while (temp1 != null && temp2 != null) {
                if (temp1.val < temp2.val) {
                    ll.addLast(temp1.val);
                    temp1 = temp1.next;
                } else {
                    ll.addLast(temp2.val);
                    temp2 = temp2.next;
                }
            }
            while (temp1 != null) {
                ll.addLast(temp1.val);
                temp1 = temp1.next;
            }
            while (temp2 != null) {
                ll.addLast(temp2.val);
                temp2 = temp2.next;
            }
            return ll;
        }

        public void printList() {
            Node temp = this.head;
            System.out.print("size:" + size + " ");
            while (temp != null) {
                if (temp == head)
                    System.out.print("head");
                if (temp == tail)
                    System.out.print("tail");
                System.out.print("[" + temp.val + "]->");

                temp = temp.next;
            }
            System.out.println();

        }

        public void addLast(int val) {
            Node n = new Node(val);
            if (size == 0) {
                head = n;
                tail = n;
                size++;
            } else {
                tail.next = n;
                tail = n;
                size++;
            }
        }

        public void addFirst(int val) {
            Node n = new Node(val);
            if (size == 0) {
                head = n;
                tail = n;
                size++;
            } else {
                n.next = head;
                head = n;
                size++;
            }
        }

        public void removeFirst() {
            if (size == 0) return;
            head = head.next;
            size--;
        }

        public void removeLast() {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        }

        public int getFirst() {
            return head.val;
        }

        public int getLast() {
            return tail.val;
        }

        public Node getNodeAt(int i) {
            if (i >= size) return null;
            int t = 0;
            Node temp = head;
            while (t < i) {
                t++;
                temp = temp.next;
            }
            return temp;
        }

        public void insertAt(int val, int index) {
            if (index >= size) return;
            if (index == 0) {
                addFirst(val);
                return;
            }
            if (index == size - 1) {
                addLast(val);
                return;
            }
            Node n = new Node(val);
            Node temp = head;
            int i = 0;
            while (i < index - 1) {
                i++;
                temp = temp.next;
            }
            n.next = temp.next.next;
            temp.next = n;
            size++;
        }

        public void removeAt(int index) {
            if (index >= size) return;
            if (index == 0) {
                removeFirst();
                return;
            }
            if (index == size - 1) {
                removeLast();
                return;
            }
            Node temp = head;
            int i = 0;
            while (i < index - 1) {
                i++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }

        public void reverse() {
            int l = 0;
            int r = size - 1;
            while (l < r) {
                Node lval = getNodeAt(l++);
                Node rval = getNodeAt(r--);
                int temp = lval.val;
                lval.val = rval.val;
                rval.val = temp;
            }
        }

        public void reverseP() {
            Node curr = head, prev = null;
            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }

        public int kFromLast(int k) {
            Node slow = head, fast = head;
            while (k >= 0) {
                k--;
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.val;
        }

        public int getMidIndex() {
            int count = 0;
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                count++;
                slow = slow.next;
                fast = fast.next.next;
            }
            return count;
        }

        public LinkedList removeDuplicatedFromSortedList() {
            LinkedList l1 = new LinkedList();
            while (size != 0) {
                int val = getFirst();
                removeFirst();
                if (l1.size != 0) {
                    if (val != l1.tail.val) l1.addLast(val);
                } else {
                    l1.addLast(val);
                }
            }
            return l1;
        }

        public void oddEvenList() {
            LinkedList even = new LinkedList();
            LinkedList odd = new LinkedList();
            while (size != 0) {
                int val = getFirst();
                if (val % 2 == 0) even.addLast(val);
                else odd.addLast(val);
                removeFirst();
            }
            if(odd.size!=0 && even.size!=0){
                size =even.size+odd.size;
                odd.tail.next = even.head;
                head = odd.head;
                tail = even.tail;
            }
            else if(odd.size>0){
                size = odd.size;
                head = odd.head;
                tail = odd.tail;
            }
            else {
                size = even.size;
                head = even.head;
                tail = even.tail;
            }

        }

        public void mergeSort() {

        }
    }
}
