import dsComponents.Node;

public class LinkedList {
    public static void main(String[] args) {
        int [] nums = new int[]{1,4,3,5,3,3,67,3};
        Node head  = new Node(nums[0]);
        Node temp = head;
        for (int i = 1; i < nums.length; i++) {
            Node n = new Node(nums[i]);
            temp.next = n;
            temp = n;
        }
        temp = head;
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static Node reverse(Node n){
        Node temp = n,curr = null;
        while (temp.next!=null){
            curr = n.next;

        }
        return null;
    }
}
