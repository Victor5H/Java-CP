package genericTree;

import java.util.ArrayList;
import java.util.Stack;

class Node {
    int val;
    ArrayList<Node> children = new ArrayList<>();

    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}

public class Main {
    public static Node construct(int [] arr){
        Stack<Node> stack = new Stack<>();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1)
                stack.pop();
            else {
                Node node = new Node(arr[i]);
                if (stack.isEmpty())
                    root = node;
                else {
                    Node parent = stack.peek();
                    parent.children.add(node);
                }
                stack.push(node);
            }
        }
        return root;
    }
    public static void display(Node root){
        System.out.println(root.val+" -> "+root.children);
        for(Node c : root.children){
            display(c);
        }
    }
    public static int size(Node root){
        int sum=0;
        for (Node c: root.children){
            sum+=size(c);
        }
        return sum+1;
    }
    public static int max(Node root){
        int max=Integer.MIN_VALUE;
        for (Node c: root.children){
            int maxc = max(c);
            if(maxc>max)
                max =maxc;
        }
        return Math.max(root.val, max);
    }
    public static int height(Node root){
        int max=-1; // for height in terns of edges
        // max should be 0 if height in terms of nodes
        for (Node c: root.children){
            int maxc = height(c);
            if(maxc>max)
                max =maxc;
        }
        return max+1;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        display(root);
        System.out.println("Size is: "+size(root));
        System.out.println("Max of tree is: "+max(root));
        System.out.println("Max height of tree is: "+height(root));
    }
}
