package LeetCode;

import java.util.*;

public class SumRootToLeafNumbers_129 {
    public int sumNumbers(TreeNode root) {
        int total = 0;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> valueQueue = new LinkedList<Integer>();

        if (root != null) {
            nodeQueue.offer(root);
            valueQueue.offer(root.val);
        }

        while (!nodeQueue.isEmpty()) {
            TreeNode curr = nodeQueue.poll();
            int currSum = valueQueue.poll();

            if (curr.left == null && curr.right == null) {
                total += currSum;
            } else {
                if (curr.left != null) {
                    nodeQueue.offer(curr.left);
                    valueQueue.offer(currSum * 10 + curr.left.val);
                }
                if (curr.right != null) {
                    nodeQueue.offer(curr.right);
                    valueQueue.offer(currSum * 10 + curr.right.val);
                }
            }
        }

        return total;
    }
}
