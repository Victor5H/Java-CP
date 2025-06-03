package linkedList;

import dsComponents.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
//        l1.addLast(2);
//        l1.addLast(4);
        l1.addLast(9);
        l1.addLast(2);
        l1.addLast(2);
        l1.addLast(3);
        l2.addLast(9);
        l2.addLast(5);
        l2.addLast(9);
        l1.printList();
        l2.printList();
        LinkedList add = LinkedList.add(l1,l2);
        add.printList();

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
        Node reverseLP;
        private void reverseHelper(Node rightP, int ind){
            if(rightP==null) return;
            reverseHelper(rightP.next,ind+1);
            if(size/2<ind){
                int temp = rightP.val;
                rightP.val = reverseLP.val;
                reverseLP.val = temp;
                reverseLP = reverseLP.next;
                reverseLP = reverseLP.next;
            }
        }
        public void reverseLLRec(){
            // reversing a linked list by swapping value with recursion
            reverseLP = head;
            reverseHelper(head,0);
        }
        private boolean palindromeHelper(Node rightP){
            if(rightP==null) return true;
            boolean res =  palindromeHelper(rightP.next);
            if(!res) return false;
            if(rightP.val==reverseLP.val)
                    reverseLP = reverseLP.next;
            else return false;
            return res;
        }

        public boolean isPalindrome(){
            reverseLP = head;
            return palindromeHelper(head);
        }
        private void foldHelper(Node rightP, int ind){
            if(rightP==null) return ;
            foldHelper(rightP.next, ind+1);
            if(ind >size/2) {
                Node next = reverseLP.next;
                reverseLP.next = rightP;
                rightP.next = next;
                reverseLP = next;
            } else if (ind == size / 2) {
                tail = rightP;
                tail.next = null;
            }
        }
        public void fold(){
            reverseLP = head;
            foldHelper(head,0);
        }
        private static LinkedList addRes;
        public static int addHelper(Node n1, int pv1, Node n2, int pv2){
            if (pv1==0 || pv2==0) return 0;

            int carry = 0,sum=0;
            if (pv1>pv2) {
                carry = addHelper(n1.next, pv1 - 1, n2, pv2);
                sum = carry+n1.val;
                carry=0;
                if(sum>9){
                    addRes.addFirst(sum%10);
                    carry = sum/10;
                }
                else addRes.addFirst(sum);
                return carry;
            }
            else if (pv2>pv1) {
                carry = addHelper(n1, pv1, n2.next, pv2 - 1);
                sum = carry+n2.val;
                carry=0;
                if(sum>9){
                    addRes.addFirst(sum%10);
                    carry = sum/10;
                }
                else addRes.addFirst(sum);
                return carry;
            }
            else
                carry= addHelper(n1.next,pv1-1,n2.next,pv2-1);

            sum = n1.val+n2.val+carry;
            carry=0;
            if(sum>9){
                addRes.addFirst(sum%10);
                carry = sum/10;
            }
            else addRes.addFirst(sum);
            return carry;
        }
        public static LinkedList add(LinkedList l1, LinkedList l2){
            addRes =  new LinkedList();
            int carry = addHelper(l1.head,l1.size,l2.head,l2.size);
            System.out.println(carry);
            if(carry!=0) addRes.addFirst(carry);
            return addRes;
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
