package binaryTree;

import java.util.*;

public class Main {
    public static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
        TreeNode(Integer val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public static class Pair{
        TreeNode treeNode;
        int state;
        Pair(TreeNode treeNode, int state){
            this.treeNode = treeNode;
            this.state = state;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + treeNode +
                    ", state=" + state +
                    '}';
        }
    }
    public static void display(TreeNode root){
        if (root==null) return;
        String str="";
        str+=root.left==null? ".":root.left.val +"";
        str+="<- "+root.val +" ->";
        str+=root.right==null? ".":root.right.val +"";
        System.out.println(str);
        display(root.left);
        display(root.right);
    }
    public static TreeNode construct(Integer [] arr){
        Stack<Pair> stack = new Stack<>();
        TreeNode root = new TreeNode(arr[0],null,null);
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
                    TreeNode right = new TreeNode(arr[idx], null, null);
                    top.treeNode.right = right;
                    Pair np = new Pair(right,1);
                    stack.push(np);
                }
                top.state++;
            }
            else {
                idx++;
                if(arr[idx]!=null) {
                    TreeNode left = new TreeNode(arr[idx], null, null);
                    top.treeNode.left = left;
                    Pair np = new Pair(left,1);
                    stack.push(np);
                }
                top.state++;
            }

        }
        return root;
    }
    public static int max(TreeNode root){
        if (root==null) return Integer.MIN_VALUE; // min value being the identity of max
        int left = max(root.left);
        int right = max(root.right);
        int m = Math.max(left,right);
        return Math.max(m,root.val);
    }
    public static Integer min(TreeNode root){
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
        return Math.min(m,root.val);
    }
    public static int sum(TreeNode root){
        if (root==null) return 0;
        return root.val +sum(root.left)+sum(root.right);
    }
    public static Integer product(TreeNode root){
        if (root==null) return 1;
        return root.val +product(root.left)*product(root.right);
    }
    public static int size(TreeNode root){
        if (root==null) return 0; // 0 for nodes, -1 for edges
        return size(root.right)+size(root.left)+1;
    }
    public static int height(TreeNode root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static void preOrder(TreeNode root){
        if (root==null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(TreeNode root){
        if (root==null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
    public static void postOrder(TreeNode root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
    public static void levelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode n = q.poll();
                System.out.print(n.val +" ");
                if(n.left!=null)
                    q.add(n.left);
                if (n.right!=null)
                    q.add(n.right);
            }
            System.out.println();
        }
    }
    public static void iterativeOrders(TreeNode root){

        Stack<Pair> stack = new Stack<>();
        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();
        StringBuilder in = new StringBuilder();
        stack.push(new Pair(root,1));
        while (!stack.isEmpty()) {
            Pair peek = stack.peek();
            if(peek.state==1){
                pre.append(" ").append(peek.treeNode.val);
                if(peek.treeNode.left!=null)
                    stack.add(new Pair(peek.treeNode.left,1));
                peek.state++;
            }
            else if(peek.state==2){
                in.append(" ").append(peek.treeNode.val);
                if(peek.treeNode.right!=null)
                    stack.add(new Pair(peek.treeNode.right,1));
                peek.state++;
            }
            else{
                post.append(" ").append(peek.treeNode.val);
                stack.pop();
            }
        }
        System.out.println("pre order: "+pre);
        System.out.println("in order: "+in);
        System.out.println("post order: "+post);
    }
    public static List<TreeNode> treeNodeToRootPath =new ArrayList<>();
    public static boolean nodeToRootPath(TreeNode root, int find){
        boolean left=false,right=false;
        if(root.val ==find){ treeNodeToRootPath.add(root); return true;}
        if(root.left!=null){
            left = nodeToRootPath(root.left,find);
        }
        if(root.right!=null){
            right = nodeToRootPath(root.right,find);
        }
        if(left|| right) {
            treeNodeToRootPath.add(root);
            return true;
        }
        return false;

    }
    public static void kLevelsDown(TreeNode root, int k){
        if(root==null|| k<0) return;
        if(k==0){
            System.out.println(root.val);
        }
        kLevelsDown(root.left,k-1);
        kLevelsDown(root.right,k-1);
    }
    public static void kLevelsDownWithBlocker(TreeNode root, int k, TreeNode blocker){
        if(root==null || k<0 || root==blocker) return;
        if(k==0){
            System.out.println(root.val);
        }
        kLevelsDown(root.left,k-1);
        kLevelsDown(root.right,k-1);
    }
//    https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
    public static void kNodesFar(TreeNode root, int target, int k){
        treeNodeToRootPath = new ArrayList<>();
        nodeToRootPath(root,target);
        if(treeNodeToRootPath.isEmpty()) return;
        for (int i = 0; i < treeNodeToRootPath.size(); i++) {
//            using blocker to block from printing the same nodes again
            kLevelsDownWithBlocker(treeNodeToRootPath.get(i),k-i,i==0?null: treeNodeToRootPath.get(i-1));
        }
    }
    public static void pathToLeafFromRoot(TreeNode root, String path, int sum, int low, int high){
        if (root==null) return;
        if(root.left==null&& root.right==null){
            if(sum>=low && sum<=high)
                System.out.println(path);
            return;
        }
        pathToLeafFromRoot(root.left,path+" "+root.val,sum+root.val,low,high);
        pathToLeafFromRoot(root.right,path+" "+root.val,sum+root.val,low,high);
    }
    public static void transformToLeftClonedTree(TreeNode root){
        if (root==null)return;
        TreeNode n = new TreeNode(root.val,root.left,null);
        root.left = n;
        transformToLeftClonedTree(n.left);
        transformToLeftClonedTree(root.right);
    }
    public static void transformBackFromLeftClonedTree(TreeNode root){
        if (root==null)return;
        root.left = root.left.left;
        transformBackFromLeftClonedTree(root.left);
        transformBackFromLeftClonedTree(root.right);
    }
    public static void printSingleChild(TreeNode root){
        if (root==null) return;
        if(root.right==null && root.left!=null){
            System.out.println(root.left.val);
        }
        if(root.left==null&& root.right!=null){
            System.out.println(root.right.val);
        }
        printSingleChild(root.left);
        printSingleChild(root.right);
    }
    public static TreeNode removeLeaves(TreeNode root){
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
    public static int isBalanced(TreeNode root){
        if(root==null) return 0;
        int l = isBalanced(root.left);
        int r = isBalanced(root.right);
        if(l==-1 || r==-1) return -1;
        if(Math.abs(l-r)<=1)
            return Math.max(l,r)+1;
        return -1;
    }
//    https://leetcode.com/problems/same-tree/
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(q==null && p==null) return true;
        if(q==null || p==null) return false;
        return p.val==q.val && isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
//    https://leetcode.com/problems/minimum-depth-of-binary-tree/
    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(root.left!=null)
            left = minDepth(root.left);
        if(root.right!=null)
            right = minDepth(root.right);
        return Math.min(left,right)+1;
    }
//    https://leetcode.com/problems/path-sum
    public boolean toRootPathSum(TreeNode root, int targetSum, int sumSF){
        if(root!=null && root.left==null && root.right==null){
            sumSF+=root.val;
            if(sumSF==targetSum) return true;
            return false;
        }
        if(root==null) return false;
        sumSF+=root.val;
        return toRootPathSum(root.left,targetSum,sumSF)||toRootPathSum(root.right,targetSum,sumSF);
    }
    public static void main(String[] args) {
        Integer [] arr ={50,25,12,null,null,27,30,null,null,null,75,62,null,70,null,null,87,null,null};
        TreeNode root = construct(arr);
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
        for(TreeNode n: treeNodeToRootPath){
            System.out.print(n.val +" ");
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
