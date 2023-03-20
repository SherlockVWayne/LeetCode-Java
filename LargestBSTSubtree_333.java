package LeetCode;

public class LargestBSTSubtree_333 {
    // return array for each node:
    //     [0] --> min of this subtree
    //     [1] --> max of this subtree
    //     [2] --> nodes num of largest BST in its subtree(inclusive)

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return -1;
        int[] result = largestBST(root);
        return result[2];
    }

    private int[] largestBST(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = largestBST(node.left);
        int[] right = largestBST(node.right);
        if (node.val > left[1] && node.val < right[0]) {
            return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), left[2] + right[2] + 1};
        } else {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }

    // Time complexity: O(n), each node is visited once
}
