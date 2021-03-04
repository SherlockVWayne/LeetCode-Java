package LeetCode;

import java.util.*;

public class LongestWordInDictionary_720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String result = "";

        HashSet<String> builtWords = new HashSet();
        for (String word : words) {
            if (word.length() == 1 || builtWords.contains(word.substring(0, word.length() - 1))) {
                if (word.length() > result.length()) result = word;
                builtWords.add(word);
            }
        }

        return result;
    }
}
