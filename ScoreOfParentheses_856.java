package LeetCode;

import java.util.LinkedList;

public class ScoreOfParentheses_856 {
    
    public static void main(String[] args) {
        System.out.println(new ScoreOfParentheses_856().scoreOfParentheses("(((())()))"));
    }
    
    public int scoreOfParentheses(String S) {
        LinkedList<Integer> stack = new LinkedList<>();
        int score = 0;
        
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.offerLast(score);
                score = 0;
            } else if (c == ')') {
                score = stack.pollLast() + Math.max(score * 2, 1);
            }
        }
        
        return score;
    }
    
}
