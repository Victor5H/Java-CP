package daily.TwentyFive.thirdDec;
class ListNode {
    int val;
       ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveKthFromEndOfLL {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode last = head;
        for(int i=0;i<n;i++){
            last = last.next;
        }
        ListNode trav = head,prev=null;
        while(last!=null){
            last = last.next;
            prev = trav;
            trav = trav.next;

        }
        if(trav == head) return head.next;
        if(prev == null) return null;
        prev.next = trav.next;
        return head;
    }
}
