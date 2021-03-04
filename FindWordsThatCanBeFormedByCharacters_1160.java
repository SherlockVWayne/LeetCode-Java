package LeetCode;

import java.util.Arrays;

public class FindWordsThatCanBeFormedByCharacters_1160 {
    public int countCharacters(String[] words, String chars) {
        int goodWordLengthsSum = 0;
        int[] charCounts = new int[26];

        for (char c : chars.toCharArray()) {
            charCounts[c - 'a'] ++;
        }

        for (String word : words) {
            int[] tempCharCounts = Arrays.copyOf(charCounts, charCounts.length);
            int validCharCount = 0;

            for (char c : word.toCharArray()) {
                if (tempCharCounts[c - 'a'] > 0) {
                    validCharCount ++;
                    tempCharCounts[c - 'a'] --;
                }
            }

            if (validCharCount == word.length()) {
                goodWordLengthsSum += word.length();
            }
        }
        return goodWordLengthsSum;
    }
}
