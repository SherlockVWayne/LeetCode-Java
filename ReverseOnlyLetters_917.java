package LeetCode;

import java.util.Stack;

public class ReverseOnlyLetters_917 {
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack<>();
        for (int i = 0; i < S.length(); i ++) {
            if (Character.isLetter(S.charAt(i))) {
                letters.push(S.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i ++) {
            if (Character.isLetter(S.charAt(i))) {
                result.append(letters.pop());
            } else {
                result.append(S.charAt(i));
            }
        }

        return result.toString();
    }

    public String reverseOnlyLetters_II(String S) {

        StringBuilder result = new StringBuilder();
        int j = S.length() - 1;

        for (int i = 0; i < S.length(); i ++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) {
                    j --;
                }
                result.append(S.charAt(j));
                j --;
            } else {
                result.append(S.charAt(i));
            }
        }

        return result.toString();
    }
}
