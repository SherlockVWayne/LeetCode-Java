package LeetCode;

import java.util.LinkedList;

public class BasicCalculator_II_227 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        LinkedList<Character> queue = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offerLast(c);
            }
        }
        return calculate(queue);
    }
    
    private int calculate(LinkedList<Character> queue) {
        int num = 0;
        char prevOperator = '+';
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        while (!queue.isEmpty()) {
            char c = queue.pollFirst();
            
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                num = calculate(queue);
            } else if (c == ')') {
                break;
            } else if ("+-*/".indexOf(c) != -1) {
                evaluate(stack, num, prevOperator);
                num = 0;
                prevOperator = c;
            }
        }
        evaluate(stack, num, prevOperator);
        return stack.stream().mapToInt(a -> a).sum();
    }
    
    private void evaluate(LinkedList<Integer> stack, int num, char prevOperator) {
        switch (prevOperator) {
            case '+':
                stack.offerLast(num);
                break;
            case '-':
                stack.offerLast(-num);
                break;
            case '*':
                stack.offerLast(stack.pollLast() * num);
                break;
            case '/':
                stack.offerLast(stack.pollLast() / num);
                break;
            default:
                break;
        }
    }
}
