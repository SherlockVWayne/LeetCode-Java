package LeetCode;

public class LongestContinuousIncreasingSubsequence_674 {
    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int anchor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) anchor = i;
            result = Math.max(result, i - anchor + 1);
        }
        return result;
    }
    
    public int findLengthOfLCIS_II(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = dp[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
    // 1. what is dp array, and what does index mean:
    // dp[i]: continuous length ending with nums[i]
    // 2. Recursion formula:
    // if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
    // else dp[i] = 1;
    // 3. Initialize dp array:
    // dp[0] = 1
    // 4. Iteration order:
    // 0 -> nums.length
    // 5. Examples to check dp logic
}
