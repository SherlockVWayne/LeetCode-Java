package LeetCode;

public class UnivaluedBinaryTree_965 {
    public boolean isUnivalTree(TreeNode root) {
        boolean leftUnivalued = root.left == null || root.left.val == root.val && isUnivalTree(root.left);
        boolean rightUnivalued = root.right == null || root.right.val == root.val && isUnivalTree(root.right);
        return leftUnivalued && rightUnivalued;
    }
}
