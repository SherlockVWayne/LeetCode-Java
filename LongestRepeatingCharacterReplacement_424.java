package LeetCode;

public class LongestRepeatingCharacterReplacement_424 {
    public int characterReplacement(String s, int k) {
        int[] charCounts = new int[26];

        int windowStart = 0;
        int maxLength = 0;
        int maxCount = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd ++) {
            charCounts[s.charAt(windowEnd) - 'A'] ++;
            maxCount = Math.max(maxCount, charCounts[s.charAt(windowEnd) - 'A']);

            while (windowEnd - windowStart - maxCount + 1 > k) {
                charCounts[s.charAt(windowStart) - 'A'] --;
                windowStart ++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
