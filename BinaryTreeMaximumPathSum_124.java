package LeetCode;

public class BinaryTreeMaximumPathSum_124 {
    int maxSum;
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;
        System.out.println(new BinaryTreeMaximumPathSum_124().maxPathSum(root));
    }
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxSum;
    }
    
    public int pathSum(TreeNode node) {
        if (node == null) return 0;
        System.out.println();
        System.out.println("current root: " + node.val);
        int left = Math.max(0, pathSum(node.left));
        System.out.println("current left: " + left);
        
        int right = Math.max(0, pathSum(node.right));
        System.out.println("current right: " + right);
        
        maxSum = Math.max(maxSum, left + right + node.val);
        System.out.println("current maxSum: " + maxSum);
        System.out.println("current out: " + (Math.max(left, right) + node.val));
        System.out.println();
        return Math.max(left, right) + node.val;
    }
    
    private int recursive(TreeNode root, int maxSum) {
        // base case
        if (root == null) return 0;
        
        // recursing through left and right subtree
        int leftMax = recursive(root.left, maxSum);
        int rightMax = recursive(root.right, maxSum);
        
        // finding all the four paths and the maximum between all of them
        int maxRightLeft = Math.max(leftMax, rightMax);
        int maxOneNodeRoot = Math.max(root.val, (root.val + maxRightLeft));
        int maxAll = Math.max(maxOneNodeRoot, leftMax + rightMax + root.val);
        
        // Storing the result in the maxSum holder
        maxSum = Math.max(maxSum, maxAll);
        
        // returning the value if root was part of the answer
        return maxOneNodeRoot;
        
    }
    
    public int maxPathSum_II(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        recursive(root, maxSum);
        return maxSum; // as maxSum will always store the result
    }
}