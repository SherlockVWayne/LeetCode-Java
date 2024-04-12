package LeetCode;

public class KInversePairsArray_629 {
    // use sub-optimal to calculate main-optimal
    // => DP
    
    public int kInversePairs(int n, int k) {
        if (k > n * (n - 1) / 2) { // n numbers can generate at most n * (n - 1) / 2 inverse pairs
            return 0;
        }
        
        if (k == n * (n - 1) / 2 || k == 0) {
            return 1;
        }
        
        int mod = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        // dp[x][y]: from [0, x], how many ways of having y pairs inverse pairs
        
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 1; // deal with j = 0, no inverse pairs
            for (int j = 1; j < Math.min(k, i * (i - 1) / 2) + 1; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j] - (j >= i ? dp[i - 1][j - i] : 0)) % mod;
                // all dp[i][j] modulo 10^9 + 7
                // so dp[i - 1][j - 1] might bigger than dp[i][j - 1] + dp[i - 1][j]
                if (dp[i][j] < 0)
                    dp[i][j] += mod;
            }
        }
        
        return dp[n][k];
    }
}
//    The difficulty of this question is how to find the relationship between the big problem and the sub-problems.
//    I'm sure many of us think about dynamic programming but fail to find the inner relationship.
//    Let us consider this question step by step. For a given k, when we get a new numebr n, we have lots of position to put it.
//
//    1 - If we put it in the last position, we can get dp[n - 1][k] inverse pairs.
//    2 - If we put it in the second last position, we can get dp[n - 1][k - 1] inverse pairs, since n is bigger than the number in the last position.
//    3 - ...
//    4 - If we put it in the first position, we can get dp[n - 1][k - n + 1] inverse pairs.
//    So, we get the relationship!
//    dp[n][k] = dp[n - 1][k] + dp[n - 1][k - 1] + ... + dp[n - 1][k - n + 1]
//
//    Let dp[n][k] minus dp[n][k - 1], we can get the formula:
//    dp[n][k] = dp[n][k - 1] + dp[n - 1][k] - dp[n - 1][k - n]
//
