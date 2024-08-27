package LeetCode;

public class ValidPalindrome_IV_2330 {
    public boolean makePalindrome(String s) {
        int miss = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                miss++;
            }
        }
        return miss <= 2;
    }
}
