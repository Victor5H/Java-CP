package daily.TwentySix.seventeenth;

import dsComponents.TreeNode;

public class LCA {
    TreeNode q;
    TreeNode p;
    public TreeNode dfs(TreeNode root){
        if(root==null) return null;
        if(root.left!=null & root.right !=null){
            if(p.val>root.val && q.val>root.val)
                return dfs(root.right);
            if(p.val<root.val && q.val<root.val)
                return dfs(root.left);
            return root; // splitting means this is the LCA
        }
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // this.q=q;
        // this.p=p;
        // return dfs(root);
        while(root!=null){
            if(p.val>root.val && q.val>root.val)
                root = root.right;
            else if(p.val<root.val && q.val<root.val)
                root = root.left;
            else return root;
        }
        return null;
    }
}
