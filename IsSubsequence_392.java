package LeetCode;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        if (t == null || t.length() == 0 || s.length() > t.length()) {
            return false;
        }
        
        int sIndex = 0;
        int tIndex = 0;
        
        while (tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                if (sIndex == s.length()) {
                    return true;
                }
            }
            tIndex++;
        }
        return false;
    }
    
    public boolean isSubsequence_II(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < t.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[s.length()][t.length()] == s.length();
    }
    // 1. what is dp array, and what does index mean:
    // dp[i][j]: s.substring(0, i) matched length with t.substring(0, j)
    // 2. Recursion formula:
    // if (s.chatAt(i) == t.charAt(j))
    // dp[i][j] = dp[i - 1][j - 1] + 1
    // else // only move j
    // dp[i][j] = dp[i][j - 1]
    // 3. Initialize dp array:
    // all 0
    // 4. Iteration order:
    // i 0->s.length
    // j 0->t.length
    // 5. Examples to check dp logic
    
    public boolean isSubsequence_III(String s, String t) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // "" is a substring of t
        for (int i = 0; i < t.length(); i++) {
            for (int j = s.length(); j > 0; j--) {
                if (t.charAt(i) == s.charAt(j - 1)) {
                    dp[j] = dp[j - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }
    // 1. what is dp array, and what does index mean:
    // dp[i]:
    // is s.substring[0, i] OR EMPTY a subseq of t OR EMPTY
    
    // 2. Recursion formula:
    // if (s.charAt(j - 1) == t.charAt(i))
    // dp[j] = dp[j - 1] // consider using s.charAt(i)
    
    // 3. Initialize dp array:
    // dp[0]: T -> "" is a substring of t
    
    // 4. Iteration order:
    // j: 0 -> s.length() => dp cols: t.length() + 1
    
    // 5. Examples to check dp logic
    
}
