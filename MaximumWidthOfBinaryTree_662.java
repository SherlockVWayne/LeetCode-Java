package LeetCode;

import java.util.HashMap;

public class MaximumWidthOfBinaryTree_662 {
    int maxWidth;
    HashMap<Integer, Integer> leftMostPosition;

    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        leftMostPosition = new HashMap<>();
        getWidth(root, 0, 0);
        return maxWidth;
    }

    public void getWidth(TreeNode root, int depth, int position) {
        if (root == null) return;
        leftMostPosition.computeIfAbsent(depth, x->position);
        maxWidth = Math.max(maxWidth, position - leftMostPosition.get(depth) + 1);
        getWidth(root.left, depth + 1, position * 2);
        getWidth(root.right, depth + 1, position * 2 + 1);
    }
}
