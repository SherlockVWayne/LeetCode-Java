package LeetCode;

public class LongestPalindromicSubstring_5 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int length1 = expandFromMiddle(s, i, i);
            int length2 = expandFromMiddle(s, i, i + 1);
            // starting with [s.charAt(i)] or [s.charAt(i)+s.charAt(i+1)]
            // what's the max length of palindrome it can form
            int curMaxPalindromeLength = Math.max(length1, length2);
            
            // (end - start) is the previous max length
            if (curMaxPalindromeLength > end - start) {
                start = i - ((curMaxPalindromeLength - 1) / 2);
                end = i + curMaxPalindromeLength / 2;
            }
        }
        
        return s.substring(start, end + 1); // [start, end]
    }
    
    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) return 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)
