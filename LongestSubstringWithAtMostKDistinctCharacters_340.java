package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters_340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // key: char  -> keySet.size() == k? ==> valid substring
        // val: frequency
        
        int left = 0;
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // i    -> window right bound
            // left -> window left bound
            char currChar = s.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
            while (map.size() > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                
                left++; // if current substring exceeds k distinct chars, move window left by 1
            }
            result = Math.max(result, i - left + 1);
        }
        
        return result;
    }
}
