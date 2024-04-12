package LeetCode;

public class KthSmallestElementInABST_230 {
    // DFS in-order recursive:
    // time complexity: O(N)
    
    // better keep these two variables in a wrapper class
    private static int number = 0;
    private static int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return number;
    }
    
    public void dfs(TreeNode n) {
        if (n.left != null) dfs(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) dfs(n.right);
    }
}
