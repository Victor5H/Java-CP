package dsComponents;

public class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}