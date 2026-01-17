package daily.TwentySix.seventeenthJan;

import dsComponents.TreeNode;

public class LCAOfBT {
    TreeNode p,q,ans;
    public boolean dfs(TreeNode root){
        if(root==null) return false;
        if(root.val== q.val || root.val==p.val){
            boolean l = dfs(root.left);
            boolean r = dfs(root.right);
            if(l||r){
                ans = root;
            }
            return true;
        }
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if(l && r){
            this.ans = root;
            return true;
        }
        if(l||r) return true;
        return false;

    }
// my code
    public TreeNode lowestCommonAncestorMy(TreeNode root, TreeNode p, TreeNode q) {
        this.q = q;
        this.p = p;
        dfs(root);
        return ans;
    }
//    chat gpt
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
