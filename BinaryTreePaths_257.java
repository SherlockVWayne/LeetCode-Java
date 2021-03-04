package LeetCode;

import java.util.*;

public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        if (root == null) return result;

        String currentPath = Integer.toString(root.val);
        if (root.left == null && root.right == null) result.add(currentPath);
        if (root.left != null) dfs(root.left, currentPath, result);
        if (root.right != null) dfs(root.right, currentPath, result);
        return result;
    }

    public void dfs(TreeNode root, String currentPath, List<String> result) {
        currentPath += "->" + root.val;

        if (root.left == null && root.right == null) {
            result.add(currentPath);
            return;
        }
        if (root.left != null) dfs(root.left, currentPath, result);
        if (root.right != null) dfs(root.right, currentPath, result);
    }
}
