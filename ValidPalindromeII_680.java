package LeetCode;

public class ValidPalindromeII_680 {
    public boolean validPalindrome(String s) {
        int aPointer = 0;
        int bPointer = s.length() - 1;
        
        while (aPointer <= bPointer) {
            if (s.charAt(aPointer) != s.charAt(bPointer)) {
                return helper(s, aPointer + 1, bPointer) || helper(s, aPointer, bPointer - 1);
            }
            aPointer++;
            bPointer--;
        }
        
        return true;
    }
    
    public boolean helper(String s, int aPointer, int bPointer) {
        while (aPointer <= bPointer) {
            if (s.charAt(aPointer) != s.charAt(bPointer)) {
                return false;
            }
            aPointer++;
            bPointer--;
        }
        
        return true;
    }
    
    
    public boolean validPalindrome_II(String s) {
        int l = -1, r = s.length();
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r + 1) || isPalindromic(s, l - 1, r);
        return true;
    }
    
    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
    
    
    public boolean validPalindrome_III(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return isPalindrome_III(s, i + 1, s.length() - i - 1) || isPalindrome_III(s, i, s.length() - i - 2);
                // remove character at index left or right, and check if this would be palindromic
            }
        }
        return true;
    }
    
    public boolean isPalindrome_III(String s, int left, int right) {
        while (left < right) { // right will always be bigger than left,
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
