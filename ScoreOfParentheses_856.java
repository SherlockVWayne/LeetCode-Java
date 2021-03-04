package LeetCode;

import java.util.Stack;

public class ScoreOfParentheses_856 {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        int score = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(score * 2, 1);
            }
        }

        return score;
    }
}
