package LeetCode;

import java.util.Stack;

public class DecodeString_394 {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack();
        Stack<String> resultStack = new Stack();
        String result = "";
        int index = 0;
        
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index += 1;
                }
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                resultStack.push(result);
                result = "";
                index += 1;
            } else if (s.charAt(index) == ']') {
                StringBuilder stringBuilder = new StringBuilder(resultStack.pop());
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    stringBuilder.append(result);
                }
                result = stringBuilder.toString();
                index += 1;
            } else {
                result += s.charAt(index);
                index += 1;
            }
        }
        
        return result;
    }
}
