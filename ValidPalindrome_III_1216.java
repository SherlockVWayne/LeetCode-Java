package LeetCode;

public class ValidPalindrome_III_1216 {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome_III_1216().isValidPalindrome("abcdeca", 2));
    }
    
    public boolean isValidPalindrome_II(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return s.length() <= k + dp[0][s.length() - 1];
    }
    // 1. what is dp array, and what does index mean:
    // dp[i][j]: the longest palindromic subsequence's length of substring(i, j)
    
    // 2. Recursion formula:
    // if s.charAt(i) == s.charAt(j):
    // dp[i][j] = dp[i+1][j-1] + 2
    // otherwise,
    // dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
    
    // 3. Initialize dp array:
    // dp[i][i] Initialized to 1.
    
    // 4. Iteration order:
    // from 1 -> n (top down)
    
    // 5. Examples to check dp logic
    
    public boolean isValidPalindrome(String s, int k) {
        boolean result = false;
        backtracking(s, k, false);
        return result;
    }
    
    private void backtracking(String currStr, int restK, boolean isPalindrome) {
        if (restK == 0) {
            return;
        }
        if (isPalindrome(currStr) && restK >= 0) {
            isPalindrome = true;
            return;
        }
        for (int i = 0; i < currStr.length(); i++) {
            String newStr = currStr.substring(0, i) + currStr.substring(i + 1, currStr.length());
            backtracking(newStr, restK - 1, isPalindrome);
        }
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
