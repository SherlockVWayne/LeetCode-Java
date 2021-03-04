package LeetCode;

import java.util.*;

public class WordSubsets_916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();

        int[] maxBFrequencies = new int[26];

        for (int i = 0; i < B.length; i ++) {
            String currentBWord = B[i];
            int[] charBFrequencies = getCharFrequency(currentBWord);

            for (int j = 0; j < 26; j ++) {
                maxBFrequencies[j] = Math.max(maxBFrequencies[j], charBFrequencies[j]);
            }
        }

        for (int i = 0; i < A.length; i ++) {
            String currentAWord = A[i];
            int[] charAFrequencies = getCharFrequency(currentAWord);

            boolean valid = true;
            for (int j = 0; j < 26; j ++) {
                if (maxBFrequencies[j] > charAFrequencies[j]) {
                    valid = false;
                    break;
                }
            }

            if (valid) result.add(currentAWord);
        }

        return result;
    }

    public int[] getCharFrequency (String S) {
        int[] result = new int[26];
        for (char c : S.toCharArray()) {
            result[c - 'a'] ++;
        }
        return result;
    }
}
