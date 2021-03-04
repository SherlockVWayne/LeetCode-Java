package LeetCode;

import java.util.Stack;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;

        int i_pointer = inorder.length - 1;
        int p_pointer = postorder.length - 1;

        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[p_pointer--]);

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (p_pointer >= 0) {
            while (!stack.isEmpty() && inorder[i_pointer] == stack.peek().val) {
                prev = stack.pop();
                i_pointer--;
            }

            TreeNode currentNode = new TreeNode(postorder[p_pointer]);

            if (prev != null) {
                prev.left = currentNode;
            } else {
                TreeNode top = stack.peek();
                top.right = currentNode;
            }
            stack.push(currentNode);
            prev = null;
            p_pointer--;
        }
        return root;
    }
}
