package LeetCode;

public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {
        if (n == 0) return 0;
        
        int[] dp = new int[n + 1]; // 0 indexed
        dp[0] = 1; // no left/right child nodes is also a way
        for (int i = 1; i < n + 1; i++) {
            if (i == 1 || i == 2) {
                dp[i] = i;
            } else {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
        }
        
        return dp[n];
    }
}

// e.g., n = 4
// counts(head as 4) +
// counts(head as 3) +
// counts(head as 2) +
// counts(head as 1)

// counts(head as 3) =
// left : counts(head as 2) *
// right: counts(head as 1)

// 1. what is dp array, and what does index mean:
// dp[i]: ways of forming valid BST given i nodes
// 2. Recursion formula:
// given j to calculate counts(head as j) (1 <= j <= i)
// left : counts(head as (j - 1)) *
// right: counts(head as (i - j))
// dp[i] = sum(dp[j - 1] * dp[i - j])
// 3. Initialize dp array:
// dp[1] = 1
// dp[2] = 2
// 4. Iteration order:
// 1 <= i <= n
// 5. Examples to check dp logic

/**
 * F(i, n) = arr(i - 1) * arr(n - i)
 * <p>
 * arr(n) = arr(0) * arr(n - 1) + arr(1) * arr(n - 2) + ... + arr(n - 1) * arr(0)
 */