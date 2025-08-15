package genericTree;

import java.util.*;

class TreeNode {
    int val;
    ArrayList<TreeNode> children = new ArrayList<>();

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}

public class Main {
    public static TreeNode construct(int[] arr) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1)
                stack.pop();
            else {
                TreeNode treeNode = new TreeNode(arr[i]);
                if (stack.isEmpty())
                    root = treeNode;
                else {
                    TreeNode parent = stack.peek();
                    parent.children.add(treeNode);
                }
                stack.push(treeNode);
            }
        }
        return root;
    }

    public static void display(TreeNode root) {
        System.out.println(root.val + " -> " + root.children);
        for (TreeNode c : root.children) {
            display(c);
        }
    }

    public static int size(TreeNode root) {
        int sum = 0;
        for (TreeNode c : root.children) {
            sum += size(c);
        }
        return sum + 1;
    }

    public static int max(TreeNode root) {
        int max = Integer.MIN_VALUE;
        for (TreeNode c : root.children) {
            int maxc = max(c);
            if (maxc > max)
                max = maxc;
        }
        return Math.max(root.val, max);
    }

    public static int height(TreeNode root) {
        int max = -1; // for height in terns of edges
        // max should be 0 if height in terms of nodes
        for (TreeNode c : root.children) {
            int maxc = height(c);
            if (maxc > max)
                max = maxc;
        }
        return max + 1;
    }

    public static void traversal(TreeNode root) {
        System.out.println("TreeNode pre " + root.val);
        for (TreeNode c : root.children) {
            System.out.println("Edge pre " + root.val + " -- " + c.val);
            traversal(c);
            System.out.println("Edge post " + root.val + " -- " + c.val);
        }
        System.out.println("TreeNode post " + root.val);
    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.remove();
            System.out.println(n.val);
            for (TreeNode c : n.children) {
                queue.add(c);
            }
        }
    }

    public static void levelOrderTraversalLinewise(TreeNode root) {
        Queue<TreeNode> bQueue = new ArrayDeque<>();
        bQueue.add(root);
        Queue<TreeNode> cQueue = new ArrayDeque<>();
        while (!bQueue.isEmpty() || !cQueue.isEmpty()) {
            TreeNode n = bQueue.remove();

            System.out.print(n.val + " ");
            for (TreeNode c : n.children) {
                cQueue.add(c);
            }
            if (bQueue.isEmpty()) {
                System.out.println();
                bQueue = cQueue;
                cQueue = new ArrayDeque<>();
            }
        }
    }

    public static void levelOrderTraversalLinewiseZZ(TreeNode root) {
        Queue<TreeNode> bQueue = new ArrayDeque<>();
        bQueue.add(root);
        Queue<TreeNode> cQueue = new ArrayDeque<>();
        int count = 2;
        while (!bQueue.isEmpty() || !cQueue.isEmpty()) {
            TreeNode n = bQueue.remove();
            System.out.print(n.val + " ");
            if (count % 2 == 0) {
                for (int i = n.children.size() - 1; i >= 0; i--) {
                    cQueue.add(n.children.get(i));
                }
            } else {
                for (TreeNode c : n.children) {
                    cQueue.add(c);
                }
            }
            count++;
            if (bQueue.isEmpty()) {
                System.out.println();
                bQueue = cQueue;
                cQueue = new ArrayDeque<>();
            }
        }
    }

    public static void mirror(TreeNode n) {
//        Collections.reverse(n.children);
        for (TreeNode child : n.children) {
            mirror(child);
        }
        Collections.reverse(n.children);// having reverse here or above both works

    }

    public static void removeLeaves(TreeNode root) {
//      Deleting leaves in pre-order since, if tried post order, whole
//        tree will be deleted
        for (int i = root.children.size() - 1; i >= 0; i--) {
            TreeNode child = root.children.get(i);
            if (child.children.isEmpty()) {
                root.children.remove(child);
            }
        }
        for (TreeNode child : root.children) {
            removeLeaves(child);
        }
    }

    public static void linearize(TreeNode root) {
        for (TreeNode child : root.children) {
            linearize(child);
        }
        while (root.children.size() > 1) {
            TreeNode last = root.children.remove(root.children.size() - 1);
            TreeNode lastSecond = root.children.get(root.children.size() - 1);
            TreeNode tail = getTail(lastSecond);
            tail.children.add(last);
        }
    }

    public static TreeNode linearize2(TreeNode root) {
        if (root.children.isEmpty())
            return root;
        TreeNode lastTail = linearize2(root.children.get(root.children.size() - 1));
        while (root.children.size() > 1) {
            TreeNode last = root.children.remove(root.children.size() - 1);
            TreeNode secondLast = root.children.get(root.children.size() - 1);
            TreeNode secondLastTail = linearize2(secondLast);
            secondLastTail.children.add(last);
        }
        return lastTail;

    }

    private static TreeNode getTail(TreeNode treeNode) {
        while (treeNode.children.size() == 1) {
            treeNode = treeNode.children.get(0);
        }
        return treeNode;
    }

    public static boolean find(TreeNode root, int val) {
//        System.out.println("val: "+root.val);
        if (root.val == val) return true;
        for (TreeNode child : root.children) {
            if (find(child, val)) return true;
        }
        return false;

    }

    public static ArrayList<Integer> pathNodeToRoot(TreeNode root, int val) {
        if (root.val == val) {
            ArrayList<Integer> li = new ArrayList<>();
            li.add(root.val);
            return li;
        }
        for (TreeNode child : root.children) {
            ArrayList<Integer> res = pathNodeToRoot(child, val);
            if (!res.isEmpty()) {
                res.add(root.val);
                return res;
            }
        }
        return new ArrayList<>();

    }

    static int succ;
    static int pred;
    static int status = 0;

    public static void findPredSucc(TreeNode root, int val) {
        if (status == 0) {
            if (root.val == val) status++;
            else pred = root.val;
        } else if (status == 1) {
            succ = root.val;
            status++;
        }
        for (TreeNode child : root.children) {
            findPredSucc(child, val);
        }

    }

    public static int maxSubHelper = Integer.MIN_VALUE;
    public static TreeNode maxSumSubTreeTreeNode = null;

    public static int findMaxSumSubTree(TreeNode root) {
        int sum = root.val;
        for (TreeNode child : root.children) {
            sum += findMaxSumSubTree(child);
        }
        if (sum > maxSubHelper) {
            maxSubHelper = sum;
            maxSumSubTreeTreeNode = root;
        }
        return sum;
    }

    //    diameter is the max no. of edges between 2 nodes in a tree
//    public static int diameter()
//    https://leetcode.com/problems/time-needed-to-inform-all-employees/
    public static TreeNode managerTreeBuilder(int headID, int[] manager) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(headID);
        map.put(headID, root);
        for (int i = 0; i < manager.length; i++) {
            TreeNode baap, beta;
            if (manager[i] == -1)
                continue;
            if (map.containsKey(i)) {
                beta = map.get(i);
                if (map.containsKey(manager[i])) {
                    baap = map.get(manager[i]);
                } else {
                    baap = new TreeNode(manager[i]);
                    map.put(manager[i], baap);
                }
                baap.children.add(beta);
            } else {
                beta = new TreeNode(i);
                if (map.containsKey(manager[i])) {
                    baap = map.get(manager[i]);
                } else {
                    baap = new TreeNode(manager[i]);
                    map.put(manager[i], baap);
                }
                baap.children.add(beta);
                map.put(i, beta);
            }

        }
        return root;
    }

    public static int findTime(TreeNode root, int[] time) {
        int tTime = 0;
        int max = 0;
        for (TreeNode child : root.children) {
            int t = findTime(child, time);
            if (t > max) max = t;
        }
        return max + time[root.val];
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) return informTime[0];
        TreeNode root = managerTreeBuilder(headID, manager);
        display(root);
        return findTime(root, informTime);

    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        TreeNode root = construct(arr);
        display(root);

        System.out.println("Size is: " + size(root));
        System.out.println("Max of tree is: " + max(root));
        System.out.println("Max height of tree is: " + height(root));
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
        System.out.println(find(root, 10));
        System.out.println(pathNodeToRoot(root, 110));
        findPredSucc(root, 70);
        System.out.println("predecessor= " + pred);
        System.out.println("successor= " + succ);
        System.out.println(findMaxSumSubTree(root));
        System.out.println(maxSumSubTreeTreeNode);
        System.out.println("---");
//        display(managerTreeBuilder(6, new int[]{1, 2, 3, 4, 5, 6,-1}));
        System.out.println(numOfMinutes(7, 6, new int[]{1, 2, 3, 4, 5, 6, -1}, new int[]{0, 6, 5, 4, 3, 2, 1}));

    }
}
