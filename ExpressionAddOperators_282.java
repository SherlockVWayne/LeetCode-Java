package LeetCode;

import java.util.*;

public class ExpressionAddOperators_282 {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if (num == null || num.length() == 0) return result;
        helper(result, "", num, target, 0, 0, 0);
        return result;
    }
    
    public void helper(List<String> result, String path, String num, int target, int position, long value, long multiply) {
        if (position == num.length()) {
            if (target == value) {
                result.add(path);
            }
            return;
        }
        for (int i = position; i < num.length(); i++) {
            if (i != position && num.charAt(position) == '0') {
                break;
            }
            long currentValue = Long.parseLong(num.substring(position, i + 1));
            // substring(a, b): [a, b)
            if (position == 0) {
                helper(result, path + currentValue, num, target, i + 1, currentValue, currentValue);
            } else {
                helper(result, path + "+" + currentValue, num, target, i + 1, value + currentValue, currentValue);
                
                helper(result, path + "-" + currentValue, num, target, i + 1, value - currentValue, -currentValue);
                
                helper(result, path + "*" + currentValue, num, target, i + 1, value - multiply + multiply * currentValue, multiply * currentValue);
            }
        }
    }
}
