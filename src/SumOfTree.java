import leetcode.interview150.TreeNode;

public class SumOfTree {
    public static int sumOfTree(TreeNode node){
        int left = 0,right=0;
        if(node.left!=null)
            left = sumOfTree(node.left);
        if(node.right!=null)
            right = sumOfTree(node.right);
        return node.val+left+right;
    }
}
