package genericTree;

import java.util.*;

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
    public static void traversal(Node root){
        System.out.println("Node pre "+root.val);
        for (Node c: root.children){
            System.out.println("Edge pre "+root.val+" -- "+ c.val);
            traversal(c);
            System.out.println("Edge post "+root.val+" -- "+ c.val);
        }
        System.out.println("Node post "+root.val);
    }
    public static void levelOrderTraversal(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node n = queue.remove();
            System.out.println(n.val);
            for (Node c: n.children){
                queue.add(c);
            }
        }
    }
    public static void levelOrderTraversalLinewise(Node root){
        Queue<Node> bQueue = new ArrayDeque<>();
        bQueue.add(root);
        Queue<Node> cQueue = new ArrayDeque<>();
        while (!bQueue.isEmpty() || !cQueue.isEmpty()){
            Node n = bQueue.remove();

            System.out.print(n.val+" ");
            for (Node c: n.children){
                cQueue.add(c);
            }
            if(bQueue.isEmpty()){
                System.out.println();
                bQueue = cQueue;
                cQueue = new ArrayDeque<>();
            }
        }
    }
    public static void levelOrderTraversalLinewiseZZ(Node root){
        Queue<Node> bQueue = new ArrayDeque<>();
        bQueue.add(root);
        Queue<Node> cQueue = new ArrayDeque<>();
        int count =2;
        while (!bQueue.isEmpty() || !cQueue.isEmpty()){
            Node n = bQueue.remove();
            System.out.print(n.val+" ");
            if (count%2==0){
                for (int i = n.children.size()-1; i >= 0; i--) {
                    cQueue.add(n.children.get(i));
                }
            }else {
                for (Node c : n.children) {
                    cQueue.add(c);
                }
            }
            count++;
            if(bQueue.isEmpty()){
                System.out.println();
                bQueue = cQueue;
                cQueue = new ArrayDeque<>();
            }
        }
    }
    public static void mirror(Node n){
//        Collections.reverse(n.children);
        for(Node child: n.children){
            mirror(child);
        }
        Collections.reverse(n.children);// having reverse here or above both works

    }
    public static void removeLeaves(Node root){
//      Deleting leaves in pre-order since, if tried post order, whole
//        tree will be deleted
        for (int i = root.children.size()-1; i >=0; i--) {
            Node child = root.children.get(i);
            if (child.children.isEmpty()){
                root.children.remove(child);
            }
        }
        for (Node child: root.children){
            removeLeaves(child);
        }
    }
    public static void linearize(Node root){
        for (Node child: root.children){
            linearize(child);
        }
        while (root.children.size()>1){
            Node last = root.children.remove(root.children.size()-1);
            Node lastSecond = root.children.get(root.children.size()-1);
            Node tail = getTail(lastSecond);
            tail.children.add(last);
        }
    }
    public static Node linearize2(Node root){
        if (root.children.isEmpty())
            return root;
        Node lastTail = linearize2(root.children.get(root.children.size()-1));
        while (root.children.size()>1){
            Node last  = root.children.remove(root.children.size()-1);
            Node secondLast = root.children.get(root.children.size()-1);
            Node secondLastTail = linearize2(secondLast);
            secondLastTail.children.add(last);
        }
        return lastTail;

    }

    private static Node getTail(Node node) {
        while (node.children.size()==1) {
            node = node.children.get(0);
        }
        return node;
    }
    public static boolean find(Node root, int val){
//        System.out.println("val: "+root.val);
        if(root.val==val) return true;
        for (Node child: root.children){
            if (find(child,val)) return true;
        }
        return false;

    }
    public static ArrayList<Integer> pathNodeToRoot(Node root, int val){
        if (root.val==val) {
            ArrayList<Integer> li = new ArrayList<>();
            li.add(root.val);
            return li;
        }
        for (Node child: root.children){
            ArrayList<Integer> res = pathNodeToRoot(child, val);
            if(!res.isEmpty()) {
                res.add(root.val);
                return res;
            }
        }
        return new ArrayList<>();

    }
    int succ;
    int pred;
    public static void findPredSucc(Node root,int val){

    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        display(root);
        System.out.println("Size is: "+size(root));
        System.out.println("Max of tree is: "+max(root));
        System.out.println("Max height of tree is: "+height(root));
        //traversal(root);
        //levelOrderTraversal(root);
        levelOrderTraversalLinewise(root);
        System.out.println();
        levelOrderTraversalLinewiseZZ(root);
        System.out.println("---display---");
        display(root);
        mirror(root);
        System.out.println("---Mirrored");
        display(root);
//        System.out.println("removing leaves");
//        removeLeaves(root);
//        display(root);
//
        System.out.println(find(root,10));
        System.out.println(pathNodeToRoot(root,110));

    }
}
