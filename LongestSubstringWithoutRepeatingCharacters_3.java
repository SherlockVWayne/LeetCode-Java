package LeetCode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        int aPointer = 0;
        int bPointer = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet<>();

        while (bPointer < s.length()) {
            if (!hashSet.contains(s.charAt(bPointer))) {
                hashSet.add(s.charAt(bPointer));
                bPointer ++;
                max = Math.max(hashSet.size(), max);
            } else {
                hashSet.remove(s.charAt(aPointer));
                aPointer ++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringII(String s) {
        if ( s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }
}
