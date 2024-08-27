package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses_301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> resultSet = new ArrayList<>();
        backtracking(s, resultSet, 0, 0, new char[]{'(', ')'});
        return resultSet;
    }
    
    // parenthesesBalance: count the balance of parentheses
    //  - (: ++
    //  - ): --
    // lastIndexI: starting index for the current scan of the string to identify imbalanced parentheses
    // lastIndexJ: starting index for considering which parentheses can be removed to correct an imbalance
    private void backtracking(String s, List<String> resultSet, int lastIndexI, int lastIndexJ, char[] pair) {
        int parenthesesBalance = 0;
        for (int i = lastIndexI; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) parenthesesBalance++;
            if (s.charAt(i) == pair[1]) parenthesesBalance--;
            if (parenthesesBalance >= 0) continue; // having more '(' than ')'
            // if parenthesesBalance < 0, there is imbalance
            for (int j = lastIndexJ; j <= i; j++) {
                // remove each ')' responsible for the imbalance by backtracking recursively
                if (s.charAt(j) == pair[1] &&
                    (j == lastIndexJ || s.charAt(j - 1) != pair[1])) {
                    // ensures that only the first of consecutive closing parentheses is considered for removal to avoid duplicates.
                    backtracking(s.substring(0, j) + s.substring(j + 1, s.length())/* the whole string with s.charAt(j) removed*/,
                        resultSet, i, j, pair);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') { // finished left to right
            backtracking(reversed, resultSet, 0, 0, new char[]{')', '('});
        } else { // finished right to left
            resultSet.add(reversed);
        }
    }
}
/**
 * Consider a string s = "())(", and let's see how lastIndexI and lastIndexJ interact:
 * <p>
 * 1. Initial Call: backtracking(s, resultSet, 0, 0, new char[]{'(', ')'})
 * First Imbalance: Detected at index 2 (stack becomes negative).
 * <p>
 * 2. Handling Imbalance:
 * For j = 0 to i = 2, possible removal of ) at index 1 is considered, ensuring lastIndexJ matches the scan position.
 * <p>
 * 3. Recursive Call:
 * After removal of the parenthesis at j, a recursive call is made with updated indices to reflect progress in processing: backtracking(s', resultSet, i, j, pair).
 * <p>
 * 4. Subsequent Calls:
 * Each subsequent call respects the condition lastIndexI >= lastIndexJ to efficiently manage the recursion path and prevent revisiting sections of the string that have already been resolved or scanned.
 */

// Backtracking principle:
// 1. input, output of backtracking/recursion function
// 2. termination condition
// 3. single level logic