package LeetCode;

import java.util.Stack;

public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        Stack<Character> stack = new Stack();

        int counter = 0;
        while (counter < num.length()) {

            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(counter)) {
                stack.pop();
                k --;
            }

            stack.push(num.charAt(counter));
            counter ++;
        }

        while (k > 0) {
            stack.pop();
            k --;
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            char currentChar = stack.pop();
            stringBuilder.append(currentChar);
        }

        stringBuilder.reverse();

        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }


        return stringBuilder.toString();
    }
}
