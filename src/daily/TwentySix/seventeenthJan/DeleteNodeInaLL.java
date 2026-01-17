package daily.TwentySix.seventeenthJan;

import daily.TwentyFive.seventeenAug.ListNode;
//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNodeInaLL {
    public void deleteNode(ListNode node) {
        // instead of bypassing the current node, like we r used to
        // override this node's value with next one and delete next one
        // since it is guaranteed that node to be deleted is not last node, it works IG
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
