package LeetCode;

public class LongestPalindromicSubsequence_516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
// 1. what is dp array, and what does index mean:
// dp[i][j]: in substring[i, j], the max length of Palindrome Subseq

// 2. Recursion formula:
// if (s.charAt(i) == s.charAt(j))
// dp[i][j] = dp[i + 1][j - 1] + 2
// else
// dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])

// 3. Initialize dp array:
// i, j == 0 => 1

// 4. Iteration order:
// i: bottom -> top
// j: left -> right

// 5. Examples to check dp logic