package leetcode.interview150;


import java.util.ArrayList;

public class SumRootToLeafNumbers {

    ArrayList<Integer> nums = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        getSum(root,0);
        return nums.stream().reduce(0, Integer::sum);
    }
    public void getSum(TreeNode root, int num){
        num = num*10;
        num+=root.val;
        if(root.left == null && root.right==null){
            nums.add(num);
            return;
        }
        if(root.left != null)
            getSum(root.left,num);

        if(root.right != null)
            getSum(root.right,num);

    }
}
