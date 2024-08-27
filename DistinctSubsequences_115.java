package LeetCode;

public class DistinctSubsequences_115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] // consider using s.charAt(i)
                        + dp[i - 1][j]; // consider NOT using s.charAt(i)
                    // e.g.: s: bag g
                    //       t: bag
                    // dp[4: bagg][3: bag] = dp[4: bagg][3: bag]  => using s.charAt(i)
                    //                     + dp[3: bag][3: bag]   => not using s.charAt(i)
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
// 1. what is dp array, and what does index mean:
// dp[i][j]:
// in s.substring[0, i] OR EMPTY, nums of distinct t.substring[0, j] OR EMPTY

// 2. Recursion formula:
// if (s.charAt(i) == t.charAt(j))
// dp[i][j] = dp[i - 1][j - 1] // consider using s.charAt(i)
//    + dp[i - 1][j]; // consider NOT using s.charAt(i)
// e.g.: s: bag g
//       t: bag
// dp[3: bagg][2: bag] = dp[3: bagg][2: bag]  => using s.charAt(i)
//                     + dp[2: bag][2: bag]   => not using s.charAt(i)
// else
// dp[i][j] = dp[i - 1][j]

// 3. Initialize dp array:
// dp[0][]: 1 -> empty s can form nothing
// dp[][0]: 0 -> any s can form into an empty string

// 4. Iteration order:
// i: 0 -> s.length() => dp rows: s.length() + 1
// j: 0 -> t.length() => dp cols: t.length() + 1

// 5. Examples to check dp logic

