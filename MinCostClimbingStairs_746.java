package LeetCode;

public class MinCostClimbingStairs_746 {
    public int minCostClimbingStairs_II(int[] cost) {
        int n = cost.length;
        int[] dp = new int[cost.length];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0 || i == 1) {
                dp[i] = 0;
            } else {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
        }
        // CANNOT return dp[n - 1], top floor is dp[n]
        // should step 1 floor from dp[n - 1] OR step 2 floors from dp[n - 2]
        return Math.min(dp[n - 1] + cost[n - 1], dp[n - 2] + cost[n - 2]);
    }
    // Input: cost = [10,15,20]
    // Output: 15
    // Explanation: You will start at index 1.
    // - Pay 15 and climb ___[TWO]___ steps to reach the top.
    // The total cost is 15.
    
    // 1. what is dp array, and what does index mean:
    // dp[i]: min cost to get to i-th floor
    // 2. Recursion formula:
    // dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
    // 3. Initialize dp array:
    // dp[0] = 0, dp[1] = 0
    // 4. Iteration order:
    // from 0 -> end (top down)
    // 5. Examples to check dp logic
    
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
    
    public int minCostClimbingStairsII(int[] cost) {
        int step1 = 0;
        int step2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int currentStep = cost[i] + Math.min(step1, step2);
            step1 = step2;
            step2 = currentStep;
        }
        return Math.min(step1, step2);
    }
}
