package LeetCode;

public class PalindromicSubstrings_647 {
    public static int countSubstrings_II(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            result += expandFromCenter(s, i, i);
            result += expandFromCenter(s, i, i + 1);
        }
        return result;
    }
    
    private static int expandFromCenter(String s, int i, int j) {
        int result = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            System.out.println(s.substring(i, j + 1));
            result += 1;
            i--;
            j++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        countSubstrings_II("abc");
        countSubstrings("abc");
    }
    
    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        dp[i][j] = true;
                        result += 1;
                    } else if (i + 1 == j) {
                        dp[i][j] = true;
                        result += 1;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            result += 1;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    // 1. what is dp array, and what does index mean:
    // dp[i][j]: is substring[i, j] palindrome
    // 2. Recursion formula:
    // if (s.charAt(i) == s.charAt(j))
    // i)   i == j: true
    // ii)  i + 1 = j: dp[i][j] = true
    // iii) j > i + 1: if(dp[i + 1][j - 1] == true) dp[i][j] = true
    
    // 3. Initialize dp array:
    // all false
    
    // 4. Iteration order:
    // dp[i + 1][j - 1] => dp[i][j], i: bottom -> top, j: left -> right
    // 5. Examples to check dp logic
}