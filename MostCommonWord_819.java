package LeetCode;

import java.util.*;

public class MostCommonWord_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet();
        HashMap<String, Integer> validWordCounts = new HashMap();

        for (String bannedWord : banned) {
            bannedWords.add(bannedWord);
        }

        String[] words = paragraph.toLowerCase().split("\\W+");

        for (String word : words) {
            if (!bannedWords.contains(word)) {
                validWordCounts.put(word, validWordCounts.getOrDefault(word, 0) + 1);
            }
        }

        int max = 0;
        String result = "";

        for (String validWord : validWordCounts.keySet()) {
            if (validWordCounts.get(validWord) > max) {
                max = validWordCounts.get(validWord);
                result = validWord;
            }
        }

        return result;
    }
}
