package LeetCode;

import java.util.*;

public class BuddyStrings_859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;

        if (A.equals(B)) {
            HashSet<Character> uniqueChars = new HashSet();
            for (char c : A.toCharArray()) {
                uniqueChars.add(c);
            }
            if (uniqueChars.size() < A.length()) {
                return true;
            } else {
                return false;
            }
        }

        List<Integer> difference = new ArrayList();
        for (int i = 0; i < A.length(); i ++) {
            if (A.charAt(i) != B.charAt(i)) {
                difference.add(i);
            }
        }

        if (difference.size() == 2 &&
                A.charAt(difference.get(0)) == B.charAt(difference.get(1)) &&
                B.charAt(difference.get(0)) == A.charAt(difference.get(1))
        ){
            return true;
        } else {
            return false;
        }
    }
}
