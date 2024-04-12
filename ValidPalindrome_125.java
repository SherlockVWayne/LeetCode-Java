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
    
    public static boolean isPalindrome_II(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(c);
            }
        }
        String trimmedStr = sb.toString().toLowerCase();
        for (int i = 0; i < trimmedStr.length() / 2; i++) {
            if (trimmedStr.charAt(i) != trimmedStr.charAt(trimmedStr.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isPalindrome_II("A man, a plan, a canal: Panama"));
    }
}
