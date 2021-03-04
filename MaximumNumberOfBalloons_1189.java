package LeetCode;

public class MaximumNumberOfBalloons_1189 {
    public int maxNumberOfBalloons(String text) {
        int[] charCounts = new int[26];
        for (int i = 0; i < text.length(); i++) {
            charCounts[text.charAt(i) - 'a'] ++;
        }
        int min = charCounts['b' - 'a'];                 // b
        min = Math.min(min, charCounts['a' - 'a']);      // a
        min = Math.min(min, charCounts['l' - 'a'] / 2);  // l
        min = Math.min(min, charCounts['o' - 'a'] / 2);  // o
        min = Math.min(min, charCounts['n' - 'a']);      // a
        return min;
    }
}
