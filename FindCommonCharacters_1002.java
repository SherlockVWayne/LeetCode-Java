package LeetCode;

import java.util.*;

public class FindCommonCharacters_1002 {
    public List<String> commonChars(String[] A) {
        List<String> commonChars = new ArrayList<>();
        int[] minFrequencies = new int[26];
        Arrays.fill(minFrequencies, Integer.MAX_VALUE);

        for (String currentString : A) {
            int[] charFrequencies = new int[26];

            for (char c : currentString.toCharArray()) {
                charFrequencies[c - 'a']++;
            }

            for (int i = 0; i < 26; i ++) {
                minFrequencies[i] = Math.min(minFrequencies[i], charFrequencies[i]);
            }
        }

        for (int i = 0; i < 26; i ++) {
            while (minFrequencies[i] > 0) {
                commonChars.add("" + (char)(i + 'a'));
                minFrequencies[i]--;
            }
        }

        return commonChars;
    }
}
