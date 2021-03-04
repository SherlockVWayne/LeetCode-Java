package LeetCode;

import java.util.*;

public class MaximumDepthOfN_aryTree_559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        int depth = 0;

        Queue<Node> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Node current = queue.poll();
                for(Node child: current.children) queue.offer(child);
            }

            depth++;
        }

        return depth;
    }


    private int maxDepth;
    public int maxDepthII(Node root) {
        if (root == null) return 0;
        getMaxDepth(root, 1);
        return maxDepth;
    }

    public void getMaxDepth(Node node, int depth) {
        if (node == null) return;
        maxDepth = Math.max(maxDepth, depth);
        for (Node child : node.children) {
            getMaxDepth(child, depth + 1);
        }
    }
}
