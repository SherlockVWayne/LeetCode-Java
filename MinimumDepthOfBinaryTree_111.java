package LeetCode;

public class MinimumDepthOfBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return findMinDepth(root);
    }

    public int findMinDepth(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        return Math.min(findMinDepth(root.left), findMinDepth(root.right)) + 1;
    }
}
