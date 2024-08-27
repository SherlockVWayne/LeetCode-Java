package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CheckIfOneStringSwapCanMakeStringsEqual_1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if ((s1 == null && s2 != null) ||
            (s2 == null && s1 != null) ||
            (s1.length() != s2.length())) {
            return false;
        }
        List<Integer> diffList = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffList.add(i);
            }
            if (diffList.size() > 2) {
                return false;
            }
        }
        
        return (diffList.isEmpty()) ||
            (diffList.size() == 2 && s1.charAt(diffList.get(0)) == s2.charAt(diffList.get(1)) && s1.charAt(diffList.get(1)) == s2.charAt(diffList.get(0)));
    }
}
