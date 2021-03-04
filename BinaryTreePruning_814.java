package LeetCode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BinaryTreePruning_814 {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne (TreeNode root) {
        if (root == null) return false;
        boolean leftContainsOne = containsOne(root.left);
        boolean rightContainsOne = containsOne(root.right);
        if (!leftContainsOne) {
            root.left = null;
        }
        if (!rightContainsOne) {
            root.right = null;
        }
        return root.val == 1 || leftContainsOne || rightContainsOne;
    }
}
