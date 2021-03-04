package LeetCode;

import java.util.Stack;

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

public class RangeSumOfBST_938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int rangeSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.val >= low && node.val <= high) {
                    rangeSum += node.val;
                }
                if (node.val > low) {
                    stack.push(node.left);
                }
                if (node.val < high) {
                    stack.push(node.right);
                }
            }
        }

        return rangeSum;
    }

    int rangeSum = 0;
    public int rangeSumBST_2(TreeNode root, int low, int high) {
        getRangeSum(root, low, high);
        return rangeSum;
    }

    public void getRangeSum(TreeNode node, int low, int high){
        if (node != null) {
            if (node.val >= low && node.val <= high) {
                rangeSum += node.val;
            }
            if (node.val > low && node.left != null) {
                getRangeSum(node.left, low, high);
            }
            if (node.val < high && node.right != null) {
                getRangeSum(node.right, low, high);
            }
        }
    }
}
