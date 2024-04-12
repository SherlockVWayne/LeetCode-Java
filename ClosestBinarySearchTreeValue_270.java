package LeetCode;

public class ClosestBinarySearchTreeValue_270 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        int minChildDiff = closestValue(target < root.val ? root.left : root.right, target);
        
        if (Math.abs(root.val - target) < Math.abs(minChildDiff - target)) {
            return root.val;
        } else if (Math.abs(root.val - target) > Math.abs(minChildDiff - target)) {
            return minChildDiff;
        } else {
            return Math.min(root.val, minChildDiff);
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */