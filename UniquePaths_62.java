package LeetCode;

import java.util.Arrays;

public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
    
    public int uniquePaths_II(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
// 1. what is dp array, and what does index mean:
// dp[i][j]: ways of getting to the point [i][j]
// 2. Recursion formula:
// dp[i][j] = dp[i - 1][j] (DOWN) + dp[i][j - 1] (RIGHT)
// 3. Initialize dp array:
// dp[0][0-n], dp[0-m][0] shoud be 1
// 4. Iteration order:
// from top->down, left->right
// 5. Examples to check dp logic
