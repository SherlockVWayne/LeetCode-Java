package LeetCode;

public class LongestIdealSubsequence_2370 {
    public int longestIdealString(String s, int k) {
        int result = 0;
        int n = s.length();
        int[] dp = new int[150];
        for (int i = 0; i < n; ++i) {
            int currChar = s.charAt(i);
            for (int j = currChar - k; j <= currChar + k; j++) {
                dp[currChar] = Math.max(dp[currChar], dp[j]);
            }
            result = Math.max(result, dp[currChar]++);
        }
        return result;
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
    
    public int longestIdealString_II(String s, int k) {
        int[] dp = new int[26];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currChar = s.charAt(i) - 'a';
            int max = 0;
            for (int j = Math.max(0, currChar - k); j <= Math.min(25, currChar + k); j++) {
                // checks all characters that can form an "ideal" pair
                // with the current character from (currChar - k) to (currChar + k)
                // ensure the indices stay within the valid range (0 to 25).
                
                max = Math.max(max, dp[j]);
            }
            dp[currChar] = 1 + max;
            
            result = Math.max(result, dp[currChar]);
        }
        
        return result;
    }
    
    // 1. what is dp array, and what does index mean:
    // dp[c]: max length of subsequence ending with character c
    // 2. Recursion formula:
    // given c = s.charAt(j)
    // dp[c] = 1 + max(dp[c - k], dp[c - k + 1], ..., dp[c + k])
    // 3. Initialize dp array:
    // all 0
    // 4. Iteration order:
    //
    // 5. Examples to check dp logic
}