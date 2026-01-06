package daily.TwentyFive.twentyTwoSep;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBST {
    public int max(TreeNode root) {
        if (root.left == null) return root.val;
        return max(root.left);
    }

    public int min(TreeNode root) {
        if (root.right == null) return root.val;
        return min(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        // if(root.left==null&& root.right==null) return true;
        // if(root.left!=null){
        //     int lMin = min(root.left);
        //     if(lMin>=root.val) return false;
        // }
        // if(root.right!=null){
        //     int rMax = max(root.right);
        //     if(rMax<=root.val) return false;
        // }
        // boolean r = true,l=true;
        // if(root.left!=null)
        //     l = isValidBST(root.left);
        // if(root.right!=null)
        //     r = isValidBST(root.right);
        // return r&&l;
        return checkBST(root).isBST;


    }

    private class Pair {
        boolean isBST;
        long min;
        long max;

        Pair(Boolean isBST, long min, long max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    private Pair checkBST(TreeNode node) {
        if (node == null) return new Pair(true, Long.MIN_VALUE, Long.MAX_VALUE);
        Pair left = checkBST(node.left);
        Pair right = checkBST(node.right);
        Pair notBST = new Pair(false, 0, 0);
        if (!left.isBST || !right.isBST) return notBST;
        if (left.min != Long.MIN_VALUE && left.min >= node.val) return notBST;
        if (left.max != Long.MAX_VALUE && left.max >= node.val) return notBST;
        if (right.min != Long.MIN_VALUE && right.min <= node.val) return notBST;
        if (right.max != Long.MAX_VALUE && right.max <= node.val) return notBST;
        long min = left.min == Long.MIN_VALUE ? node.val : left.min;
        long max = right.max == Long.MAX_VALUE ? node.val : right.max;
        return new Pair(true, min, max);
    }
}
