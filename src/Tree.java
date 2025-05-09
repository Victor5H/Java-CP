import leetcode.interview150.TreeNode;

public class Tree {
    public static void main(String[] args) {
//                              0 1 2 3 4 5 6
        int [] nums = new int[]{1,2,3,4,5,6,7};
        TreeNode root = build(nums,0);
        preOrder(root);
        System.out.println("");
        postOrder(root);
        System.out.println("");
        inOrder(root);
        System.out.println();
        System.out.println(maxHeight(root));
        System.out.println(SumOfTree.sumOfTree(root));
    }
    public static TreeNode build(int [] arr, int index){
        if(index>= arr.length)
            return null;
        TreeNode root = new TreeNode(arr[index],null,null );
        root.left = build(arr, 2*index+1);
        root.right = build(arr,2*index+2);
        return root;
    }
    public static void preOrder(TreeNode node){
        if(node==null) return;
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void postOrder(TreeNode node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }
    public static void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);

    }
    public static int maxHeight(TreeNode node){
        if(node==null) return 0;
        return Math.max(maxHeight(node.left)+1,maxHeight(node.right)+1);

    }
}
