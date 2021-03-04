package LeetCode;

import java.util.*;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] strings = path.split("/");

        for (String string : strings) {
            if (!stack.isEmpty() && string.equals("..")) {
                stack.pop();
            } else if (!string.equals(".") && !string.equals("") && !string.equals("..")) {
                stack.push(string);
            }
        }
        List<String> list = new ArrayList<String>(stack);

        return "/" + String.join("/", list);
    }
}
