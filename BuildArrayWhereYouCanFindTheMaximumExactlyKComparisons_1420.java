package LeetCode;

import java.util.Arrays;

public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons_1420 {
    
    // search_cost: starting from beginning of the array, how many steps to find the max
    // 3  4  2     ->  2
    // 7  1  3  4  ->  1
    public static int numOfArrays(int n, int m, int k) {
        Integer[][][] dp = new Integer[n + 1][m + 1][k + 1];
        // dp[i][j][k]: number of ways of (building array[1:i]) && (Math.max(array[1:i]) == j) && (search_cost == k)
        return dfs(n, m, k, 0, 0, 0, dp);
    }
    
    // dfs(... i, currMax, currCost) the number of ways to build the valid array `arr[i:]`
    // keep in mind that current maximum element is `currMax` and current search cost is `currCost`
    private static int dfs(int n, int m, int k, int i, int currMax, int currCost, Integer[][][] dp) {
        if (i == n) {
            if (k == currCost) return 1; // valid if the value search cost is equal to k
            return 0;
        }
        if (dp[i][currMax][currCost] != null) return dp[i][currMax][currCost];
        int ans = 0;
        // Case 1: num in range [1, currMax], newMax = currMax, newCost = currCost
        ans += (long) currMax * dfs(n, m, k, i + 1, currMax, currCost, dp) % 1_000_000_007;
        
        // Case 2: num in range [currMax+1, m], newMax = num, newCost = currCost + 1
        if (currCost + 1 <= k) {
            for (int num = currMax + 1; num <= m; num++) {
                ans += dfs(n, m, k, i + 1, num, currCost + 1, dp);
                ans %= 1_000_000_007;
            }
        }
        return dp[i][currMax][currCost] = ans;
    }
    
    public static int numOfArrays_II(int n, int m, int k) {
        Integer[][][] dp = new Integer[n + 1][m + 1][k + 1];
        return dfs_II(n, m, k, 0, 0, 0, dp);
    }
    
    // dfs(... i, currMax, currCost) the number of ways to build the valid array `arr[i:]`
    //     keeping in mind that current maximum element is `currMax` and current search cost is `currCost`
    private static int dfs_II(int n, int m, int k, int i, int currMax, int currCost, Integer[][][] dp) {
        if (i == n) {
            if (k == currCost) return 1; // valid if the value search cost is equal to k
            return 0;
        }
        if (dp[i][currMax][currCost] != null) return dp[i][currMax][currCost];
        int ans = 0;
        // Case 1: num in range [1, currMax], newMax = currMax, newCost = currCost
        ans += (long) currMax * dfs(n, m, k, i + 1, currMax, currCost, dp) % 1_000_000_007;
        
        // Case 2: num in range [currMax+1, m], newMax = num, newCost = currCost + 1
        if (currCost + 1 <= k) {
            for (int num = currMax + 1; num <= m; num++) {
                ans += dfs(n, m, k, i + 1, num, currCost + 1, dp);
                ans %= 1_000_000_007;
            }
        }
        return dp[i][currMax][currCost] = ans;
    }
    
    public static int numOfArrays_III(int n, int m, int k) {
        Integer[][][] dp = new Integer[n][m + 1][k + 1];
        // dp[i][j][k]: number of ways of (building array[1:i]) && (Math.max(array[1:i]) == j) && (search_cost == k)
        
        for (int ii = 0; ii < n; ii++) {
            for (int jj = 0; jj < m + 1; jj++) {
                for (int kk = 0; kk < k + 1; kk++) {
                    dp[ii][jj][kk] = 0;
                }
            }
        }
        
        for (int j = 1; j <= m; j++) {
            dp[0][j][1] = 1;
        }
        
        for (int ii = 1; ii < n; ii++) {
            for (int jj = 1; jj < m + 1; jj++) {
                for (int kk = 1; kk < k + 1; kk++) {
                    dp[ii][jj][kk] = 0;
                    for (int tt = 1; tt < jj; tt++) {
                        dp[ii][jj][kk] = Math.toIntExact((long) (dp[ii][jj][kk] + dp[ii - 1][tt][kk - 1]) % 1_000_000_007);
                    }
                    dp[ii][jj][kk] = Math.toIntExact((long) (dp[ii][jj][kk] + dp[ii - 1][jj][kk] * jj) % 1_000_000_007);
                }
            }
        }
        // if arr[i] is the largest among arr[1:i]   =>    arr[i] == j
        // dp[i][j][k] += sum(dp[i-1][1..j-1][k-1])
        // if arr[i] is not largest among arr[1:i]   =>    arr[i] <= j
        // dp[i][j[k]＋= dp[i-1][j][k]*j
        
        Integer result = 0;
        for (int jj = 1; jj <= m; jj++) {
            result = (result + dp[n - 1][jj][k]) % 1_000_000_007;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(numOfArrays_III(50, 100, 25));
        System.out.println(numOfArrays_II(50, 100, 25));
    }
}

// Time: O(n * m * k * m)
// Explain: There are total n*m*k states stored in dp, each state needs maximum m iteration loops to calculate the result.
// Space: O(n * m * k)
