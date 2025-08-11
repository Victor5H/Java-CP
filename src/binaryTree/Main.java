package binaryTree;

import java.util.*;

public class Main {
    public static class Node{
        Integer data;
        Node left;
        Node right;
        Node(Integer data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node=node;
            this.state = state;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", state=" + state +
                    '}';
        }
    }
    public static void display(Node root){
        if (root==null) return;
        String str="";
        str+=root.left==null? ".":root.left.data+"";
        str+="<- "+root.data+" ->";
        str+=root.right==null? ".":root.right.data+"";
        System.out.println(str);
        display(root.left);
        display(root.right);
    }
    public static Node construct(Integer [] arr){
        Stack<Pair> stack = new Stack<>();
        Node root = new Node(arr[0],null,null);
        Pair rootP = new Pair(root,1);
        stack.push(rootP);
        int idx = 0;
        while (!stack.isEmpty()){
            Pair top = stack.peek();

            if(top.state==3) stack.pop();
            else if (top.state==2) {
                idx++;
                // right child
                if(arr[idx]!=null) {
                    Node right = new Node(arr[idx], null, null);
                    top.node.right = right;
                    Pair np = new Pair(right,1);
                    stack.push(np);
                }
                top.state++;
            }
            else {
                idx++;
                if(arr[idx]!=null) {
                    Node left = new Node(arr[idx], null, null);
                    top.node.left = left;
                    Pair np = new Pair(left,1);
                    stack.push(np);
                }
                top.state++;
            }

        }
        return root;
    }
    public static int max(Node root){
        if (root==null) return Integer.MIN_VALUE; // min value being the identity of max
        int left = max(root.left);
        int right = max(root.right);
        int m = Math.max(left,right);
        return Math.max(m,root.data);
    }
    public static Integer min(Node root){
//        if (root==null) return null;
//        if(root.left==null && root.right==null)
//            return root.data;
//        if (root.left!=null) {
//            int left = min(root.left);
//            return Math.min(root.data, left);
//        }
//        if (root.right!=null) {
//            int right = min(root.right);
//           return Math.min(root.data, right);
//        }
//        int m= Math.min(min(root.left),root.data);
//        return Math.min(m,min(root.right));
        if (root==null) return Integer.MAX_VALUE; // max value being the identity of min
        int left = min(root.left);
        int right = min(root.right);
        int m = Math.min(left,right);
        return Math.min(m,root.data);
    }
    public static int sum(Node root){
        if (root==null) return 0;
        return root.data+sum(root.left)+sum(root.right);
    }
    public static Integer product(Node root){
        if (root==null) return 1;
        return root.data+product(root.left)*product(root.right);
    }
    public static int size(Node root){
        if (root==null) return 0; // 0 for nodes, -1 for edges
        return size(root.right)+size(root.left)+1;
    }
    public static int height(Node root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static void preOrder(Node root){
        if (root==null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if (root==null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node n = q.poll();
                System.out.print(n.data+" ");
                if(n.left!=null)
                    q.add(n.left);
                if (n.right!=null)
                    q.add(n.right);
            }
            System.out.println();
        }
    }
    public static void iterativeOrders(Node root){

        Stack<Pair> stack = new Stack<>();
        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();
        StringBuilder in = new StringBuilder();
        stack.push(new Pair(root,1));
        while (!stack.isEmpty()) {
            Pair peek = stack.peek();
            if(peek.state==1){
                pre.append(" ").append(peek.node.data);
                if(peek.node.left!=null)
                    stack.add(new Pair(peek.node.left,1));
                peek.state++;
            }
            else if(peek.state==2){
                in.append(" ").append(peek.node.data);
                if(peek.node.right!=null)
                    stack.add(new Pair(peek.node.right,1));
                peek.state++;
            }
            else{
                post.append(" ").append(peek.node.data);
                stack.pop();
            }
        }
        System.out.println("pre order: "+pre);
        System.out.println("in order: "+in);
        System.out.println("post order: "+post);
    }
    public static List<Node> nodeToRootPath =new ArrayList<>();
    public static boolean nodeToRootPath(Node root, int find){
        boolean left=false,right=false;
        if(root.data==find){ nodeToRootPath.add(root); return true;}
        if(root.left!=null){
            left = nodeToRootPath(root.left,find);
        }
        if(root.right!=null){
            right = nodeToRootPath(root.right,find);
        }
        if(left|| right) {
            nodeToRootPath.add(root);
            return true;
        }
        return false;

    }
    public static void kLevelsDown(Node root, int k){
        if(root==null|| k<0) return;
        if(k==0){
            System.out.println(root.data);
        }
        kLevelsDown(root.left,k-1);
        kLevelsDown(root.right,k-1);
    }
    public static void kLevelsDownWithBlocker(Node root, int k, Node blocker){
        if(root==null || k<0 || root==blocker) return;
        if(k==0){
            System.out.println(root.data);
        }
        kLevelsDown(root.left,k-1);
        kLevelsDown(root.right,k-1);
    }
//    https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
    public static void kNodesFar(Node root, int target, int k){
        nodeToRootPath = new ArrayList<>();
        nodeToRootPath(root,target);
        if(nodeToRootPath.isEmpty()) return;
        for (int i = 0; i < nodeToRootPath.size(); i++) {
//            using blocker to block from printing the same nodes again
            kLevelsDownWithBlocker(nodeToRootPath.get(i),k-i,i==0?null:nodeToRootPath.get(i-1));
        }
    }
    public static void pathToLeafFromRoot(Node root, String path, int sum, int low, int high){
        if (root==null) return;
        if(root.left==null&& root.right==null){
            if(sum>=low && sum<=high)
                System.out.println(path);
            return;
        }
        pathToLeafFromRoot(root.left,path+" "+root.data,sum+root.data,low,high);
        pathToLeafFromRoot(root.right,path+" "+root.data,sum+root.data,low,high);
    }
    public static void transformToLeftClonedTree(Node root){
        if (root==null)return;
        Node n = new Node(root.data,root.left,null);
        root.left = n;
        transformToLeftClonedTree(n.left);
        transformToLeftClonedTree(root.right);
    }
    public static void transformBackFromLeftClonedTree(Node root){
        if (root==null)return;
        root.left = root.left.left;
        transformBackFromLeftClonedTree(root.left);
        transformBackFromLeftClonedTree(root.right);
    }
    public static void printSingleChild(Node root){
        if (root==null) return;
        if(root.right==null && root.left!=null){
            System.out.println(root.left.data);
        }
        if(root.left==null&& root.right!=null){
            System.out.println(root.right.data);
        }
        printSingleChild(root.left);
        printSingleChild(root.right);
    }
    public static Node removeLeaves(Node root){
//        if (root==null) return;
//        if(root.left!=null){
//            if(root.left.left==null && root.left.right==null)
//                root.left=null;
//        }
//        if(root.right!=null){
//            if(root.right.left==null && root.right.right==null)
//                root.right=null;
//        }
//        removeLeaves(root.left);
//        removeLeaves(root.right);

        if (root==null) return null;
        if (root.left==null&& root.right==null) return null;
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }
//    https://leetcode.com/problems/balanced-binary-tree/description/
    public static int isBalanced(Node root){
        if(root==null) return 0;
        int l = isBalanced(root.left);
        int r = isBalanced(root.right);
        if(l==-1 || r==-1) return -1;
        if(Math.abs(l-r)<=1)
            return Math.max(l,r)+1;
        return -1;
    }
    public static void main(String[] args) {
        Integer [] arr ={50,25,12,null,null,27,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = construct(arr);
        display(root);
//        System.out.println(root);
//        System.out.println(max(root));
//        System.out.println(min(root));
//        System.out.println(sum(root));
//        System.out.println(size(root));
//        System.out.println(height(root));
//        System.out.println("Produ"+product(root));
//        preOrder(root);
//        inOrder(root);
//        postOrder(root);
//        System.out.println("leverlorder");
//        levelOrder(root);
//        iterativeOrders(root);
//        nodeToRootPath(root,70);
//        System.out.println("Node to root path of 70");
        for(Node n: nodeToRootPath){
            System.out.print(n.data+" ");
        }
        System.out.println();
        System.out.println("2 level down from root");
        kLevelsDown(root,2);
        System.out.println("2 nodes far from root");
        kNodesFar(root,12,2);
        pathToLeafFromRoot(root,"",0,0,88);
        transformToLeftClonedTree(root);
        display(root);
        transformBackFromLeftClonedTree(root);
        System.out.println("original");
        display(root);
//        printSingleChild(root);
        System.out.println("removing leaves");
        removeLeaves(root);
        display(root);
        System.out.println(isBalanced(root));
    }

}
