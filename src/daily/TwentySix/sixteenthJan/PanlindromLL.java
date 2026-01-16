package daily.TwentySix.sixteenthJan;
//https://leetcode.com/problems/palindrome-linked-list/
import daily.TwentyFive.seventeenAug.ListNode;

public class PanlindromLL {
    ListNode t = null;
    public boolean dfs(ListNode n){
        if(n==null) return true;
        if(!dfs(n.next)) return false;
        if(t.val != n.val) return false;
        t = t.next;
        return true;

    }
    public boolean isPalindrome(ListNode head) {
        this.t = head;
        return dfs(head);
    }
}
