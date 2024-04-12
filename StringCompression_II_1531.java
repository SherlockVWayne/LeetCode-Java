package LeetCode;

public class StringCompression_II_1531 {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1]; // Only declare the size array needed
        for (int i = 1; i <= n; i++) { // No need to populate i = 0
            for (int j = 0; j <= k; j++) dp[i][j] = n; // Only need values of j <= k
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1); // Store this char as a variable rather than looking it up multiple times in the for loops
            for (int j = 0; j <= k; j++) {
                int cnt = 0;
                int del = 0;
                for (int l = i; l > 0; l--) {
                    if (s.charAt(l - 1) == c) cnt++;
                    else del++;
                    if (j < del) break; // Break the for loop when j < del
                    dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + (cnt == 1 ? 1 : cnt < 10 ? 2 : cnt < 100 ? 3 : 4)); // Checking smallest to largest reduces number of operations
                    // Every character will have a cnt of 1 at some point, many will have cnt of 2-9, at most only one character can have a cnt of 100
                }
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        return dp[n][k];
    }
}
//We define the state dp[i][k]: the minimum length for s.substring(0, i+1) with at most k deletion.
//For each char s[i], we can either keep it or delete it.
//If delete, dp[i][j]=dp[i-1][j-1].
//If keep, we delete at most j chars in s.substring(0, i+1) that are different from s[i].