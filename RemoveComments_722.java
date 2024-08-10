package LeetCode;

import java.util.*;

public class RemoveComments_722 {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        boolean isMultiLineComment = false;
        
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (isMultiLineComment) {
                    if (s.charAt(i) == '*' &&
                        i < s.length() - 1 &&
                        s.charAt(i + 1) == '/') { // case of "*/"
                        isMultiLineComment = false;
                        i++; //skip '/' on next iteration of i
                    }
                } else {
                    if (s.charAt(i) == '/' &&
                        i < s.length() - 1 &&
                        s.charAt(i + 1) == '/') { // case of "//"
                        break; //ignore remaining characters on line s
                    } else if (s.charAt(i) == '/' &&
                        i < s.length() - 1 &&
                        s.charAt(i + 1) == '*') { // case of "/*"
                        isMultiLineComment = true; // start of /*, might be multiple line comment
                        i++; //skip '*' on next iteration of i
                    } else {
                        sb.append(s.charAt(i)); // not comment
                    }
                }
            }
            
            if (!isMultiLineComment && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder(); //reset for next line of source code
            }
        }
        
        return result;
    }
}
// We only need to check for two things:
//
// 1. If we see '//' we stop reading the current line, and add whatever characters we have seen to the result.
// 2. If we see '/*' then we start the multiline comment mode and we keep on ignoring characters until we see '*/'.
// 3. If the current character is neither of the above two and the multiline comment mode is off, then we add that character to the current line.
// Once we parse one line (source[i]), then if the mode is off, we add the currently generated line (StringBuilder) to the result and repeat for source[i + 1].
