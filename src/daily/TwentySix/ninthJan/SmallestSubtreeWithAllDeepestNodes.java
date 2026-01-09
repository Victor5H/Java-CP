package daily.TwentySix.ninthJan;

import dsComponents.TreeNode;

public class SmallestSubtreeWithAllDeepestNodes {
    class Pair{
        TreeNode node;
        long depth;
        Pair(TreeNode n, long d){
            depth = d;
            node = n;
        }
        public String toString(){
            return "{n: "+node.val+" d:"+depth+"}";
        }
    }
    public Pair dfs(int depth, TreeNode root){
        if(root.left==null && root.right==null) return new Pair(root,depth);
        Pair left = null,right=null;
        if(root.left!=null){
            left = dfs(depth+1,root.left);
        }
        if(root.right!=null){
            right = dfs(depth+1,root.right);
        }
        if(left!=null && right!=null){
            if(left.depth==right.depth)
                //return the max depth
                return new Pair(root,left.depth);

            else if(left.depth>right.depth)
                return left;

            else return right;
        }
        if(left!=null) return left;
        return right;

    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(0,root).node;
    }
}
