package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree_958 {
    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode == null) {
                end = true;
            } else {
                if (end) return false;
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }
        }

        return true;
    }
}
