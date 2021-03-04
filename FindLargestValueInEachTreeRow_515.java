package LeetCode;

import java.util.ArrayList;
import java.util.List;

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

public class FindLargestValueInEachTreeRow_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestVal = new ArrayList<>();
        dfs(root, largestVal, 0);
        return largestVal;
    }

    public void dfs(TreeNode root, List<Integer> largestVal, int level) {
        if (root == null) return ;

        if (level == largestVal.size()) {
            largestVal.add(root.val);
        } else {
            largestVal.set(level, Math.max(largestVal.get(level), root.val));
        }

        dfs(root.left, largestVal, level + 1);
        dfs(root.right, largestVal, level + 1);
    }
}
