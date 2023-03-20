package LeetCode;

import java.util.*;

public class BasicCalculator_224 {
  public static int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    
    LinkedList<Character> queue = new LinkedList<Character>();
    for (Character c : s.toCharArray()) {
      if (c != ' ') {
        queue.offerLast(c);
      }
    }
    return calculate(queue);
  }
  
  private static int calculate(LinkedList<Character> queue) {
    int num = 0;
    char previousOperator = '+';
    LinkedList<Integer> stack = new LinkedList<Integer>();
    
    while (!queue.isEmpty()) {
      char c = queue.pollFirst();
      
      if (Character.isDigit(c)) {
        num = num * 10 + (c - '0');
      } else if (c == '(') {
        calculate(queue);
      } else if (c == ')') {
        break;
      } else if ("+-".indexOf(c) != -1) {
        evaluate(stack, num, previousOperator);
        num = 0;
        previousOperator = c;
      }
    }
    
    evaluate(stack, num, previousOperator);
    
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pollLast();
    }
    
    return result;
  }
  
  private static void evaluate(LinkedList<Integer> stack, int num, char operator) {
    switch (operator) {
      case '+':
        stack.offerLast(num);
        break;
      case '-':
        stack.offerLast(-num);
        break;
      default:
        break;
    }
  }
  
  public static void main(String[] args) {
    String s = "(1+(4+5+2)-3)+(6+8)";
    System.out.println(calculate(s));
  }
}
