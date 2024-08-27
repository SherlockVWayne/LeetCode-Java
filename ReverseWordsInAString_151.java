package LeetCode;

import java.util.Arrays;

public class ReverseWordsInAString_151 {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] words = s.trim().split("\s+");
        for (int i = 0; i < words.length / 2; i++) {
            String tempWord = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - i - 1] = tempWord;
        }
        return String.join(" ", words);
    }
    
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
    }
}
