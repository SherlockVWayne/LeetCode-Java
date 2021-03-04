package LeetCode;

import java.util.*;

public class GoatLatin_824 {
    public String toGoatLatin(String S) {
        HashSet<Character> vowels = new HashSet();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }

        String result = "";
        int index = 1;
        for (String word : S.split("\\s"))  {
            if (index > 1) {
                result += " ";
            }

            char firstLetter = word.charAt(0);
            if (vowels.contains(firstLetter)) {
                result += word + "ma";
            } else {
                result += word.substring(1) + firstLetter + "ma";
            }

            for (int j = 0; j < index; j ++) {
                result += "a";
            }

            index += 1;
        }

        return result;
    }

    public String toGoatLatinII(String S) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String res = "";
        int i = 0, j = 0;
        for (String w : S.split("\\s")) {
            res += ' ' + (vowels.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, ++i; j < i; ++j) {
                res += "a";
            }
        };
        return res.substring(1);
    }
}
