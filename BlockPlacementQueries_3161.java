package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BlockPlacementQueries_3161 {
    public static void main(String[] args) {
        List<Boolean> result = new BlockPlacementQueries_3161().getResults(
            new int[][]{
                {1, 2},       // 在位置2添加障碍
                {1, 5},       // 在位置5添加障碍
                {2, 3, 2},    // 问：能否在位置3放一个大小为2的块？（块覆盖 [1, 3]）
                {2, 6, 1},    // 问：能否在位置6放一个大小为1的块？（块覆盖 [5, 6]）
                {2, 7, 2},    // 问：能否在位置7放一个大小为2的块？（块覆盖 [5, 7]）
            }
        );
        result.forEach(System.out::println);
    }
    
    public List<Boolean> getResults(int[][] queries) {
        int maxRange = 0;
        
        // Step 1: Find the maximum range of positions from all queries of type 1 (add obstacle).
        for (int[] query : queries) {
            if (query[0] == 1) { // Query type 1: Add obstacle
                maxRange = Math.max(maxRange, query[1]);
            }
        }
        
        // Step 2: Initialize the segment tree with the maximum range.
        SegmentTreeNode root = new SegmentTreeNode(0, maxRange, Integer.MAX_VALUE);
        List<Boolean> results = new ArrayList<>();
        
        // Step 3: Process each query
        for (int[] query : queries) {
            if (query[0] == 1) {
                // Add an obstacle at the given position.
                addObstacle(root, query[1]);
            } else {
                // Check if a block of the given size can be placed at the starting position.
                int blockStart = query[1] - query[2]; // Calculate the block's start position.
                if (blockStart >= root.end) {
                    results.add(true); // If blockStart is beyond the range, it is trivially placeable.
                } else {
                    results.add(isBlockPlaceable(root, blockStart, query[2]));
                }
            }
        }
        root.printTree();
        System.out.println();
        
        return results;
    }
    
    private boolean isBlockPlaceable(SegmentTreeNode root, int blockStart, int blockSize) {
        if (root.leftChild == null && root.rightChild == null) {
            // Leaf node case: Check the local conditions for block placement.
            if (blockStart >= root.end) {
                return blockSize <= root.maxFreeSpace;
            } else if (blockStart < root.start) {
                return false; // Block starts before this range, invalid.
            } else {
                return blockSize <= (root.nearestObstacle - root.start);
            }
        }
        
        // If the block is entirely in the right child.
        if (root.rightChild.end <= blockStart) {
            if (root.rightChild.maxFreeSpace >= blockSize) {
                return true;
            }
        }
        
        // If the block is entirely in the left child.
        if (root.leftChild.end <= blockStart) {
            if (root.leftChild.maxFreeSpace >= blockSize) {
                return true;
            }
        } else {
            // Recursively check the left child.
            return isBlockPlaceable(root.leftChild, blockStart, blockSize);
        }
        
        // Recursively check the right child.
        if (root.rightChild.start <= blockStart && root.rightChild.end >= blockStart) {
            return isBlockPlaceable(root.rightChild, blockStart, blockSize);
        }
        
        return false;
    }
    
    private int addObstacle(SegmentTreeNode root, int obstaclePosition) {
        if (root.end == root.start) {
            // Leaf node: Update the obstacle and maximum free space.
            root.nearestObstacle = (root.end < obstaclePosition && obstaclePosition < root.nearestObstacle)
                ? obstaclePosition : root.nearestObstacle;
            root.maxFreeSpace = root.nearestObstacle == Integer.MAX_VALUE
                ? root.nearestObstacle : root.nearestObstacle - root.start;
            return root.maxFreeSpace;
        }
        
        if (obstaclePosition <= root.start) return root.maxFreeSpace;
        
        if (obstaclePosition > root.end) {
            if (obstaclePosition < root.nearestObstacle) {
                root.nearestObstacle = obstaclePosition;
                if (root.leftChild == null && root.rightChild == null) {
                    root.maxFreeSpace = (obstaclePosition - root.start);
                } else {
                    root.maxFreeSpace = Math.max(addObstacle(root.leftChild, obstaclePosition),
                        addObstacle(root.rightChild, obstaclePosition));
                }
            }
            return root.maxFreeSpace;
        }
        
        if (root.leftChild != null && root.rightChild != null) {
            root.maxFreeSpace = Math.max(addObstacle(root.leftChild, obstaclePosition),
                addObstacle(root.rightChild, obstaclePosition));
            return root.maxFreeSpace;
        }
        
        // Split the node if not already split.
        int mid = (root.end - root.start) / 2 + root.start;
        root.leftChild = new SegmentTreeNode(root.start, mid, root.nearestObstacle);
        root.rightChild = new SegmentTreeNode(mid + 1, root.end, root.nearestObstacle);
        root.maxFreeSpace = Math.max(addObstacle(root.leftChild, obstaclePosition),
            addObstacle(root.rightChild, obstaclePosition));
        return root.maxFreeSpace;
    }
}

class SegmentTreeNode {
    SegmentTreeNode leftChild;
    SegmentTreeNode rightChild;
    int start;           // Start of the range.
    int end;             // End of the range.
    int maxFreeSpace;    // Maximum free space in the current range.
    int nearestObstacle; // Position of the nearest obstacle.
    
    SegmentTreeNode(int start, int end, int obstaclePosition) {
        this.start = start;
        this.end = end;
        this.nearestObstacle = obstaclePosition;
        this.maxFreeSpace = obstaclePosition == Integer.MAX_VALUE
            ? Integer.MAX_VALUE : obstaclePosition - start;
    }
    
    void printTree() {
        System.out.print("[" + start + "-" + end + ": " + nearestObstacle + ", " + maxFreeSpace);
        if (leftChild != null) {
            System.out.print(" -- ");
            leftChild.printTree();
            rightChild.printTree();
            System.out.print(" -- " + start + "-" + end);
        }
        System.out.print("]");
    }
}
/**
 * 1. 时间复杂度：
 * * addObstacle: 每次插入时，递归深度为 O(logn)（其中 n 是最大范围），总插入次数为 m，复杂度为 O(mlogn)。
 * * isBlockPlaceable: 每次检查操作也需要递归，复杂度为 O(logn)，总检查次数为 k，复杂度为 O(klogn)。
 * * 综合时间复杂度：O((m+k)logn)其中 m 是添加障碍物的查询数，k 是检查块的查询数，n 是最大范围。
 * 2. 空间复杂度：
 * * 使用了一个分段树，空间复杂度为 O(n)（存储节点）。
 * * 综合复杂度：
 * * 时间复杂度：O((m+k)logn)
 * * 空间复杂度：O(n)
 */