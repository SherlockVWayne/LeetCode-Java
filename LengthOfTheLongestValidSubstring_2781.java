package LeetCode;

import java.util.*;

public class LengthOfTheLongestValidSubstring_2781 {
    public static int longestValidSubstring(String word, List<String> forbidden) {
        if (word == null || word.length() == 0) {
            return 0;
        }
        
        int maxForbiddenLength = 0;
        Set<String> forbiddenSet = new HashSet<String>();
        for (String s : forbidden) {
            forbiddenSet.add(s);
            maxForbiddenLength = Math.max(s.length(), maxForbiddenLength);
        }
        
        int maxLength = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));
            
            /**
             * This for block is to ensure that when adding the new char, none of the substrings is forbidden
             * Iteration starts from right because the right most char is just added
             * e.g., baa + a -> cbaaa
             *                      j
             * a
             * aa
             * aaa -> forbidden -> (cba)aa => aa
             * baaa
             * cbaaa
             */
            for (int j = sb.length() - 1; j >= Math.max(0, sb.length() - maxForbiddenLength); j--) {
                String s = sb.substring(j);
                if (forbiddenSet.contains(s)) {
                    sb.delete(0, j + 1);
                    break;
                }
            }
            maxLength = Math.max(sb.length(), maxLength);
        }
        return maxLength;
    }

//    Time complexity:
//    O(n * max_length_of_forbidden_words ^ 2) the square is because hashmap is not free. It needs O(length) to calculate the hash value and find.
//
//    Space complexity:
//    O(sum of forbidden words length)
    
    public static void main(String[] args) {
        String[] strings = new String[]{"aaa", "cb"};
        
        System.out.println(longestValidSubstring("cbaaaabc", Arrays.asList(strings)));
    }
}
