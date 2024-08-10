package LeetCode;

public class IntegerBreak_343 {
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1]; // 0 indexed, and dp[0] has no meaning
        for (int i = 2; i < n + 1; i++) {
            if (i == 2) {
                dp[i] = 1;
            } else {
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }
        }
        Print.printIntArray(dp);
        return dp[n];
    }
    
    public static void main(String[] args) {
        integerBreak(10);
    }
}
// 1. what is dp array, and what does index mean:
// dp[i]: max multi until i

// 2. Recursion formula:
// iterate j from 1 -> i,
// dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
//                         only 2 nums, >= 2 nums
// e.g.:
// dp[5] = max(current_dp[5], max(1 * 4, 1 * dp[4]))
// dp[5] = max(current_dp[5], max(2 * 3, 2 * dp[3]))
// dp[5] = max(current_dp[5], max(3 * 2, 3 * dp[2])) // repeated

// 3. Initialize dp array:
// dp[1] = 1, dp[2] = 1

// 4. Iteration order:
// from 1 -> n (top down)

// 5. Examples to check dp logic

