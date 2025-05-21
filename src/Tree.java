import dsComponents.TreeNode;

public class Tree {
    static int count=0;
    public static void main(String[] args) {
//                              0 1 2 3 4 5 6
        int[] nums = new int[]{4, 5, 2, 6, 7, 3, 1,8};
        TreeNode root = build(nums, 0);
        TreeNode bst = buildBST(nums);
        nthLargest(bst,8);
        System.out.println(maxHeight(bst));
    }
    public static TreeNode buildBST(int[] values) {
        TreeNode root = null;
        for (int val : values) {
            root = insertRecursive(root, val);
            System.out.println(root.val);
        }
        //System.out.println(root.val);
        return root;
    }
    private static TreeNode insertRecursive(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insertRecursive(node.left, val);
        } else if (val > node.val) {
            node.right = insertRecursive(node.right, val);
        }
        return node;
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
        return Math.max(maxHeight(node.left),maxHeight(node.right))+1;

    }
    public static void nthLargest(TreeNode node, int n){
        if(node==null || count>n) return;
        nthLargest(node.right,n);
        count++;
        if (count==n)
            System.out.print(node.val+" ");

        nthLargest(node.left,n);

    }
}
