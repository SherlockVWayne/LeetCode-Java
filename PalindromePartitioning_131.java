package LeetCode;

import java.util.*;

public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();

        if (s == null || s.length() == 0) return result;

        dfs(s, 0, new ArrayList<String>(), result);

        return result;
    }

    public void dfs(String s, int position, List<String> list, List<List<String>> result) {
        if (position == s.length())  {
            result.add(new ArrayList<String>(list)); // deep copy
        } else {
            for (int i = position; i <s.length(); i++) {
                if (isPalindrome(s, position, i)) {
                    list.add(s.substring(position, i + 1));
                    dfs(s, i + 1, list, result);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left ++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
