package LeetCode;

import java.util.HashMap;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        HashMap<Character, String> map = new HashMap();
        for (int i = 0; i < pattern.length(); i ++) {
            char currentChar = pattern.charAt(i);
            if (map.containsKey(currentChar)) {
                if (!map.get(currentChar).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(currentChar, words[i]);
            }
        }
        return true;
    }
}
