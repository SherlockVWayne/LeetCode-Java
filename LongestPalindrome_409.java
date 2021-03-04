package LeetCode;

public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        int result = 0;
        int[] charCounts = new int[128];

        for (char c : s.toCharArray()) {
            charCounts[c] ++;
        }

        for (Integer charCount : charCounts) {
            result += charCount / 2 * 2;
            if (result % 2 == 0 && charCount % 2 == 1) {
                result += 1;
            }
        }

        return result;
    }
}
