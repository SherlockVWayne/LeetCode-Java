package LeetCode;

public class DistributeCoinInBinaryTree_979 {
    int numMoves;
    public int distributeCoins(TreeNode root) {
        numMoves = 0;
        givenCoins(root);
        return numMoves;
    }

    public int givenCoins(TreeNode root) {
        if (root == null) return 0;

        int left = givenCoins(root.left);
        int right = givenCoins(root.right);
        numMoves += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
