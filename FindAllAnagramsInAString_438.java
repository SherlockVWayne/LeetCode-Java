package LeetCode;

import java.util.*;

public class FindAllAnagramsInAString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();

        if (s == null || s.length() == 0) return result;

        int[] charCounts = new int[26];
        for (char c : p.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {
            if (charCounts[s.charAt(right++) - 'a']-- >= 1) count --;
            if (count == 0) result.add(left);
            if (right - left == p.length() && charCounts[s.charAt(left++) - 'a']++ >= 0) count++;
        }

        return result;
    }
}
