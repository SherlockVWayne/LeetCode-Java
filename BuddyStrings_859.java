package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings_859 {
    public static void main(String[] args) {
        System.out.println(new BuddyStrings_859().buddyStrings("abcd", "cbad"));
    }
    
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        
        if (s.equals(goal)) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : s.toCharArray()) {
                uniqueChars.add(c);
            }
            if (uniqueChars.size() < s.length()) {
                return true;
            } else {
                return false;
            }
        }
        
        List<Integer> difference = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                difference.add(i);
            }
        }
        
        return difference.size() == 2 &&
            s.charAt(difference.get(0)) == goal.charAt(difference.get(1)) &&
            goal.charAt(difference.get(0)) == s.charAt(difference.get(1));
    }
    
}
