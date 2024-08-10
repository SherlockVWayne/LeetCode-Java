package LeetCode;

public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        // base cases
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;
        
        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
    
    public int climbStairs_II(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}

// 1. what is dp array, and what does index mean:
// dp[i]: number of ways of getting to i-th staircase
// 2. Recursion formula:
// dp[i] = dp[i - 1] + dp[i - 2]
// 3. Initialize dp array:
// dp[1] = 1, dp[2] = 2
// 4. Iteration order:
// from 1 -> n (top down)
// 5. Examples to check dp logic
