package daily.TwentySix.sixthJan;

import dsComponents.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree
public class MaxLevelSumOfBTree {
    public int maxLevelSum(TreeNode root) {
        int level=1,ansLevel=0,max=Integer.MIN_VALUE, levelSum=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int qLen = q.size();
            for(int i=0;i<qLen;i++){
                TreeNode top = q.poll();
                levelSum+=top.val;
                if(top.left!=null)
                    q.offer(top.left);
                if(top.right!=null)
                    q.offer(top.right);
            }
            if(levelSum>max){
                max = levelSum;
                ansLevel=level;
            }
            levelSum=0;
            level++;
        }
        return ansLevel;
    }
}
