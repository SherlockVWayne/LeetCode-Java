package LeetCode;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null) return null;

        StringBuilder sb = new StringBuilder();

        int[] charFreq = new int[128];

        for (int i = 0; i < t.length(); i++) {
            charFreq[t.charAt(i)]++;
        }

        int leftPointer = 0;
        int count = 0;
        int size = Integer.MAX_VALUE;

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            if (--charFreq[s.charAt(rightPointer)] >= 0) {
                count++;
            }

            while (count == t.length()) {
                if (size > rightPointer - leftPointer + 1) {
                    size = rightPointer - leftPointer + 1;

                    sb.delete(0, sb.length());
                    sb.append(s.substring(leftPointer, rightPointer + 1));
                }

                if (++charFreq[s.charAt(leftPointer++)] > 0) {
                    count--;
                }
            }

        }

        return sb.toString();
    }
}
