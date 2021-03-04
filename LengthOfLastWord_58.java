package LeetCode;

public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;

        s = s.trim();

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }
}
