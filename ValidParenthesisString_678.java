package LeetCode;

public class ValidParenthesisString_678 {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int min = 0;
        int max = 0;
        // record the range of open parenthesis: [min, max]
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                min--;
                max--;
            } else if (c == '*') {
                min--; // if `*` become `)` then openCount--
                max++; // if `*` become `(` then openCount++
            }
            
            if (max < 0) {
                return false;
                // e.g.: ())(
            }
            
            min = Math.max(min, 0);
        }
        
        return min == 0;
    }
}
