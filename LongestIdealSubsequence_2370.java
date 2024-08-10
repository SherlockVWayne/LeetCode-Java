package LeetCode;

public class LongestIdealSubsequence_2370 {
    public int longestIdealString(String s, int k) {
        int result = 0;
        int[] dp = new int[128];
        for (int ci = 0; ci < s.length(); ci++) {
            int i = s.charAt(ci);
            for (int j = i - k; j <= i + k; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
            result = Math.max(result, dp[i]++);
        }
        return result;
    }
    
}
//dp[c] means the length of the longest ideal subsequence
//ending with character c.
//
//Iterate the character i in string s,
//c can be the next character for string ending from i - k to i + k.
//So that dp[i] = max(dp[i-k], dp[i-k+1] ... , dp[i+k]) + 1.
//
//return the max(dp) as result.
//
//
//Complexity
//Time O(n)
//Space O(128)