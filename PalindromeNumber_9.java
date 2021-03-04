package LeetCode;

public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reverseInt = 0;
        while(x > reverseInt) {
            int pop = x % 10;
            x /= 10;

            reverseInt = (reverseInt * 10) + pop;
        }
        if (x == reverseInt || x == reverseInt / 10) {
            return true;
        } else {
            return false;
        }
    }
}
