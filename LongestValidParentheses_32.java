package LeetCode;

import java.util.LinkedList;

public class LongestValidParentheses_32 {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses_32().longestValidParentheses_III(")))(()))))))((("));
//        System.out.println(new LongestValidParentheses_32().longestValidParentheses("()"));
    }
    
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        
        stack.offerLast(-1);
        
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerLast(i);
            } else if (s.charAt(i) == ')') {
                stack.pollLast();
                if (stack.isEmpty()) {
                    stack.offerLast(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peekLast());
                }
            }
        }
        
        return maxLength;
    }
    
    public int longestValidParentheses_II(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int maxLength = 0;
        
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            }
            if (right > left) {
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else if (s.charAt(i) == '(') {
                left++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            }
            if (right < left) {
                left = 0;
                right = 0;
            }
        }
        
        return maxLength;
    }
    
    public String longestValidParentheses_III(String s) {
        if (s == null || s.isEmpty()) return "";
        
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerLast(i + 1);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peekLast() < 0) {
                    stack.offerLast(-(i + 1));
                } else if (stack.peekLast() > 0) {
                    stack.pollLast();
                }
            }
        }
        
        StringBuilder result = new StringBuilder(s);
        
        while (!stack.isEmpty()) {
            result.deleteCharAt(Math.abs(stack.pollLast()) - 1);
        }
        
        return result.toString();
    }
}
//Time complexity:O(n)
//Space complexity:O(n)
