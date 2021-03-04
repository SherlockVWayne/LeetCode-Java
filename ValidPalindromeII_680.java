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
}
