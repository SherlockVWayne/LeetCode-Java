package LeetCode;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        String fixedString = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                fixedString += c;
            }
        }
        fixedString = fixedString.toLowerCase();

        int aPointer = 0;
        int bPointer = fixedString.length() - 1;

        while (aPointer <= bPointer) {
            if (fixedString.charAt(aPointer) != fixedString.charAt(bPointer)) {
                return false;
            }
            aPointer += 1;
            bPointer -= 1;
        }
        return true;
    }
}
